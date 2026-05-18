-- Задача 3*: Комплексная оценка военной эффективности отрядов

SELECT
    ms.squad_id,
    ms.name AS squad_name,
    ms.formation_type,

    (SELECT d.name
     FROM DWARVES d
     WHERE d.dwarf_id = ms.leader_id
    ) AS leader_name,

    (SELECT COUNT()
     FROM SQUAD_BATTLES sb
     WHERE sb.squad_id = ms.squad_id
    ) AS total_battles,

    (SELECT COUNT()
     FROM SQUAD_BATTLES sb
     WHERE sb.squad_id = ms.squad_id AND sb.outcome = 'Victory'
    ) AS victories,

    ROUND(
        (SELECT COUNT() FROM SQUAD_BATTLES sb
         WHERE sb.squad_id = ms.squad_id AND sb.outcome = 'Victory')
        / 
        (SELECT COUNT() FROM SQUAD_BATTLES sb
        WHERE sb.squad_id = ms.squad_id)
    ) AS victory_percentage,

    ROUND(
        (SELECT SUM(sb.casualties) FROM SQUAD_BATTLES sb
         WHERE sb.squad_id = ms.squad_id)
        /
        (SELECT SUM(sb.casualties) + SUM(sb.enemy_casualties)
          FROM SQUAD_BATTLES sb
          WHERE sb.squad_id = ms.squad_id)
    ) AS casualty_rate,

    ROUND(
        (SELECT SUM(sb.enemy_casualties) FROM SQUAD_BATTLES sb
         WHERE sb.squad_id = ms.squad_id
        )
        /
        (SELECT SUM(sb.casualties) FROM SQUAD_BATTLES sb
        WHERE sb.squad_id = ms.squad_id)
    ) AS casualty_exchange_ratio,

    (SELECT COUNT()
     FROM SQUAD_MEMBERS sm
     WHERE sm.squad_id = ms.squad_id
       AND sm.exit_date IS NULL
    ) AS current_members,

    (SELECT COUNT()
     FROM SQUAD_MEMBERS sm
     WHERE sm.squad_id = ms.squad_id
    ) AS total_members_ever,

    ROUND(
        (SELECT COUNT() FROM SQUAD_MEMBERS sm
         WHERE sm.squad_id = ms.squad_id AND sm.exit_date IS NULL)
        / 
        (SELECT COUNT() FROM SQUAD_MEMBERS sm
        WHERE sm.squad_id = ms.squad_id)
    ) AS retention_rate,

    (SELECT ROUND(AVG(e.quality::DECIMAL), 2)
     FROM SQUAD_EQUIPMENT se
     JOIN EQUIPMENT e ON e.equipment_id = se.equipment_id
     WHERE se.squad_id = ms.squad_id
    ) AS avg_equipment_quality,

    (SELECT COUNT()
     FROM SQUAD_TRAINING st
     WHERE st.squad_id = ms.squad_id
    ) AS total_training_sessions,

    (SELECT ROUND(AVG(st.effectiveness), 2)
     FROM SQUAD_TRAINING st
     WHERE st.squad_id = ms.squad_id
    ) AS avg_training_effectiveness,
  
    JSON_OBJECT(
        'member_ids', (
            SELECT JSON_ARRAYAGG(sm.dwarf_id)
            FROM SQUAD_MEMBERS sm
            WHERE sm.squad_id = ms.squad_id AND sm.exit_date IS NULL
        ),
        'equipment_ids', (
            SELECT JSON_ARRAYAGG(DISTINCT se.equipment_id)
            FROM SQUAD_EQUIPMENT se
            WHERE se.squad_id = ms.squad_id
        ),
        'battle_report_ids', (
            SELECT JSON_ARRAYAGG(sb.report_id)
            FROM SQUAD_BATTLES sb
            WHERE sb.squad_id = ms.squad_id
        ),
        'training_ids', (
            SELECT JSON_ARRAYAGG(st.schedule_id)
            FROM SQUAD_TRAINING st
            WHERE st.squad_id = ms.squad_id
        )
    ) AS related_entities

FROM MILITARY_SQUADS ms;


