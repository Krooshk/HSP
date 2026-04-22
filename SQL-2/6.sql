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

-- Задача 4: Данные о военном отряде с составом и операциями
