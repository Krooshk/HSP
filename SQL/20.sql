-- 1. Найдите все отряды, у которых нет лидера.

SELECT * FROM Squads
WHERE leader_id <> ALL 
(SELECT dwarf_id FROM Dwarves);

-- 2. Получите список всех гномов старше 150 лет, у которых профессия "Warrior".

SELECT * FROM Dwarves
WHERE age > 150 
AND profession = 'Warrior'

-- 3. Найдите гномов, у которых есть хотя бы один предмет типа "weapon".

SELECT * FROM Dwarves
JOIN Items ON Dwarves.dwarf_id = Items.owner_id
WHERE Items.type = 'weapon'
GROUP BY Dwarves.dwarf_id

-- 4. Получите количество задач для каждого гнома, сгруппировав их по статусу.

SELECT * FROM Dwarves
JOIN Tasks ON Dwarves.dwarf_id = Tasks.assigned_to
GROUP BY Dwarves.dwarf_id, Tasks.status

-- 5. Найдите все задачи, которые были назначены гномам из отряда с именем "Guardians".

SELECT * FROM Tasks
JOIN Dwarves ON Dwarves.dwarf_id = Tasks.assigned_to
JOIN Squads ON Squads.squad_id = Dwarves.squad_id
WHERE Squads.name = 'Guardians'

-- 6. Выведите всех гномов и их ближайших родственников, указав тип родственных отношений.

SELECT Dwarves.name, Relationships.relationship, Dwarves2.name as homie FROM Dwarves 
JOIN Relationships ON Dwarves.dwarf_id = Relationships.dwarf_id
JOIN (SELECT name FROM Dwarves) as Dwarves2 Dwarves2.dwarf_id = Relationships.dwarf_id
