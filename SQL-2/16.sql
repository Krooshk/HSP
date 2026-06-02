SELECT
    (SELECT COUNT(*) FROM CREATURE_ATTACKS) AS total_recorded_attacks,

    (SELECT COUNT(DISTINCT creature_id) FROM CREATURE_ATTACKS) AS unique_attackers,

    (SELECT ROUND(
        COUNT(*) FILTER (
            WHERE outcome IN ('repelled', 'victory')
        ) * 100.0 / NULLIF(COUNT(*), 0), 2)
     FROM CREATURE_ATTACKS) AS overall_defense_success_rate,

    (SELECT CASE
        WHEN MAX(c.threat_level) >= 5
         AND MIN(ct.distance_to_fortress) < 2.0 THEN 'Critical'
        WHEN MAX(c.threat_level) >= 4 THEN 'High'
        WHEN MAX(c.threat_level) >= 3 THEN 'Moderate'
        ELSE 'Low'
     END
     FROM CREATURES AS c
     JOIN CREATURE_SIGHTINGS cs ON cs.creature_id = c.creature_id
     JOIN CREATURE_TERRITORIES ct ON ct.creature_id = c.creature_id
     WHERE c.active = TRUE
       AND cs.date >= CURRENT_DATE - INTERVAL '90 days') AS current_threat_level,

    c.type AS creature_type,
    MAX(c.threat_level) AS threat_level,
    MAX(cs.date) AS last_sighting_date,
    MIN(ct.distance_to_fortress) AS territory_proximity,
    SUM(c.estimated_population) AS estimated_numbers,
    ARRAY_AGG(DISTINCT c.creature_id ORDER BY c.creature_id) AS creature_ids

FROM CREATURES as c
JOIN CREATURE_SIGHTINGS cs ON cs.creature_id = c.creature_id
JOIN CREATURE_TERRITORIES ct ON ct.creature_id = c.creature_id
WHERE c.active = TRUE
  AND cs.date >= CURRENT_DATE - INTERVAL '90 days'
GROUP BY c.type
