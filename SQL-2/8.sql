-- Задача 1*: Анализ эффективности экспедиций

SELECT 
    e.expedition_id,
    e.destination,
    e.status,
    (SELECT COUNT() FROM EXPEDITION_MEMBERS 
      WHERE expedition_id = e.expedition_id
      AND survived = TRUE
    ) / 
    (SELECT COUNT() FROM EXPEDITION_MEMBERS 
      WHERE expedition_id = e.expedition_id
    ) * 100 AS survival_rate,
  
    (SELECT SUM(value) FROM EXPEDITION_ARTIFACTS  
      WHERE expedition_id = e.expedition_id
    ) AS artifacts_value,
  
    (SELECT COUNT() FROM EXPEDITION_SITES  
      WHERE expedition_id = e.expedition_id
    ) AS discovered_sites,
  
    (SELECT COUNT() FROM EXPEDITION_CREATURES 
      WHERE expedition_id = e.expedition_id
      AND outcome = TRUE
    ) / 
    (SELECT COUNT() FROM EXPEDITION_CREATURES 
      WHERE expedition_id = e.expedition_id
    ) * 100 AS encounter_success_rate,
  
    (SELECT SUM(experience)
    FROM DWARF_SKILLS
    INNER JOIN EXPEDITION_MEMBERS
    ON DWARF_SKILLS.dwarf_id = EXPEDITION_MEMBERS.dwarf_id;
    WHERE expedition_id = e.expedition_id
    ) AS skill_improvement,
      
    e.return_date - e.departure_date AS expedition_duration,  
    JSON_OBJECT(
        'member_ids', (
            SELECT JSON_ARRAYAGG(e_m.dwarf_id )
            FROM EXPEDITION_MEMBERS e_m
            WHERE e.expedition_id = e_m.expedition_id
        ),
        'artifact_ids', (
            SELECT JSON_ARRAYAGG(e_a.artifact_id)
            FROM EXPEDITION_ARTIFACTS e_a
            WHERE e.expedition_id = e_a.expedition_id
        ),
        'site_ids', (
            SELECT JSON_ARRAYAGG(e_s.site_id)
            FROM EXPEDITION_SITES e_s
            WHERE e.expedition_id = e_s.expedition_id
        ),
    ) AS related_entities
FROM 
    EXPEDITIONS e;


