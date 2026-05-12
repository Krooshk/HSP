-- Задача 2*: Комплексный анализ эффективности производства

SELECT 
    w.workshop_id,
    w.name AS workshop_name,
    w.name AS workshop_type,
    (SELECT COUNT() FROM WORKSHOP_CRAFTSDWARVES  
      WHERE workshop_id = w.workshop_id
    ) AS num_craftsdwarves,
  
    (SELECT SUM(quantity) FROM WORKSHOP_PRODUCTS  
      WHERE workshop_id = w.workshop_id
    ) AS total_quantity_produced,
  
    (SELECT SUM(value) FROM WORKSHOP_PRODUCTS  
      WHERE workshop_id = w.workshop_id
    ) AS total_production_value,
  
    (SELECT SUM(quantity) / COUNT() FROM WORKSHOP_PRODUCTS  
      WHERE workshop_id = w.workshop_id
      GROUP BY production_date
    ) AS daily_production_rate,

    (SELECT AVG(level) FROM WORKSHOP_CRAFTSDWARVES  
      WHERE workshop_id = w.workshop_id
      JOIN DWARF_SKILLS on DWARF_SKILLS.dwarf_id = WORKSHOP_CRAFTSDWARVES.dwarf_id
      GROUP BY dwarf_id
    ) AS daily_production_rate,
  
    JSON_OBJECT(
        'craftsdwarf_ids', (
            SELECT JSON_ARRAYAGG(w_c.dwarf_id )
            FROM WORKSHOP_CRAFTSDWARVES w_c
            WHERE w.workshop_id = w_c.workshop_id
        ),
        'product_ids', (
            SELECT JSON_ARRAYAGG(w_p.product_id)
            FROM WORKSHOP_PRODUCTS w_p
            WHERE w.workshop_id = w_p.workshop_id
        ),
        'material_ids', (
            SELECT JSON_ARRAYAGG(w_m.material_id)
            FROM WORKSHOP_MATERIALS w_m
            WHERE w.workshop_id = w_m.workshop_id
        ),
        'project_ids', (
            SELECT JSON_ARRAYAGG(p.project_id)
            FROM PROJECTS p
            WHERE w.workshop_id = p.workshop_id
        ),
    ) AS related_entities
FROM 
    WORKSHOPS w;
