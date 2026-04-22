-- Задача 2: Получение данных о гноме с навыками и назначениями

SELECT 
    d.dwarf_id,
    d.name,
    d.age,
    d.profession,
    JSON_OBJECT(
        'skill_ids', (
            SELECT JSON_ARRAYAGG(d_s.skill_id)
            FROM DWARF_SKILLS d_s
            WHERE d.dwarf_id = d_s.dwarf_id
        ),
        'assignment_ids', (
            SELECT JSON_ARRAYAGG(d_a.assignment_id)
            FROM DWARF_ASSIGNMENTS d_a
            WHERE d.dwarf_id = d_a.dwarf_id
        ),
        'squad_ids', (
            SELECT JSON_ARRAYAGG(s_m.squad_id)
            FROM SQUAD_MEMBERS s_m
            WHERE d.dwarf_id = s_m.dwarf_id
        ),
        'equipment_ids', (
            SELECT JSON_ARRAYAGG(d_e.equipment_id)
            FROM DWARF_EQUIPMENT d_e
            WHERE d.dwarf_id = d_e.dwarf_id
        )
    ) AS related_entities
FROM 
    DWARVES d;

-- Задача 3: Данные о мастерской с назначенными рабочими и проектами
   
SELECT 
    w.workshop_id,
    w.name,
    w.type,
    w.quality,
    JSON_OBJECT(
        'craftsdwarf_ids', (
            SELECT JSON_ARRAYAGG(w_c.dwarf_id)
            FROM WORKSHOP_CRAFTSDWARVES w_c
            WHERE w.workshop_id = w_c.workshop_id
        ),
        'project_ids', (
            SELECT JSON_ARRAYAGG(p.project_id)
            FROM PROJECTS p
            WHERE w.workshop_id = p.workshop_id
        ),
        'input_material_ids', (
            SELECT JSON_ARRAYAGG(w_m.material_id )
            FROM WORKSHOP_MATERIALS w_m
            WHERE w.workshop_id = w_m.workshop_id
        ),
        'output_product_ids', (
            SELECT JSON_ARRAYAGG(w_p.product_id)
            FROM WORKSHOP_PRODUCTS w_p
            WHERE w.workshop_id = w_p.workshop_id
        )
    ) AS related_entities
FROM 
    WORKSHOPS w;

-- Задача 4: Данные о военном отряде с составом и операциями

SELECT 
    m_s.squad_id,
    m_s.name,
    m_s.formation_type,
    m_s.leader_id,
    JSON_OBJECT(
        'member_ids', (
            SELECT JSON_ARRAYAGG(s_m.dwarf_id)
            FROM SQUAD_MEMBERS s_m
            WHERE m_s.squad_id = s_m.squad_id
        ),
        'equipment_ids', (
            SELECT JSON_ARRAYAGG(s_e.equipment_id)
            FROM SQUAD_EQUIPMENT s_e
            WHERE m_s.squad_id = s_e.squad_id
        ),
        'operation_ids', (
            SELECT JSON_ARRAYAGG(s_o.operation_id)
            FROM SQUAD_OPERATIONS s_o
            WHERE m_s.squad_id = s_o.squad_id
        ),
        'training_schedule_ids', (
            SELECT JSON_ARRAYAGG(s_t.schedule_id)
            FROM SQUAD_TRAINING s_t
            WHERE m_s.squad_id = s_t.squad_id
        ),
        'battle_report_ids', (
            SELECT JSON_ARRAYAGG(s_b.report_id)
            FROM SQUAD_BATTLES s_b
            WHERE m_s.squad_id = s_b.squad_id
        )
    ) AS related_entities
FROM 
    MILITARY_SQUADS m_s;
