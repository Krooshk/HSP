-- 1. Получить информацию о всех гномах, которые входят в какой-либо отряд, вместе с информацией об их отрядах.

SELECT Dwarves.dwarf_id, Dwarves.name , Dwarves.age, Dwarves.profession, Squads.name , Squads.mission 
FROM Dwarves, Squads
WHERE Dwarves.squad_id IS NOT NULL AND Dwarves.squad_id = Squads.squad_id;   

-- 2. Найти всех гномов с профессией "miner", которые не состоят ни в одном отряде.

SELECT * FROM Dwarves
WHERE profession = "miner" AND squad_id IS NULL

-- 3. Получить все задачи с наивысшим приоритетом, которые находятся в статусе "pending".

SELECT * FROM Tasks
WHERE priority = (SELECT Max(priority) FROM Tasks) 
AND status = 'pending'

-- 4. Для каждого гнома, который владеет хотя бы одним предметом, получить количество предметов, которыми он владеет.
  
-- Предварительный расчет, сколько предметов общих. Нужно потом приплюсовать к значению total
SELECT Count() FROM Items
GROUP BY owner_id
HAVING owner_id IS NULL
  
SELECT * FROM Dwarves, 
WHERE dwarf_id = ANY 
(SELECT owner_id FROM Items) 
OR EXISTS 
(SELECT owner_id FROM Items
WHERE owner_id IS NULL)
JOIN 
(SELECT COUNT() as total FROM Items
GROUP BY owner_id) as countItems
ON countItems.owner_id = dwarf_id;

-- 5. Получить список всех отрядов и количество гномов в каждом отряде. Также включите в выдачу отряды без гномов.

SELECT * FROM Squads
LEFT JOIN (
  SELECT squad_id, Count() as count From Dwarves
  GROUP BY squad_id
) as TotalDwarves ON Squads.squad_id = TotalDwarves.squad_id 

-- 6. Получить список профессий с наибольшим количеством незавершённых задач ("pending" и "in_progress") у гномов этих профессий.
  
SELECT profession FROM Dwarves 
LEFT JOIN Tasks on Tasks.assigned_to = Dwarves.dwarf_id
WHERE status IN ('pending', 'in_progress')
GROUP BY profession
HAVING MAX(Tasks.status)

-- 7. Для каждого типа предметов узнать средний возраст гномов, владеющих этими предметами.

SELECT  Items.type, AVG(Dwarves.age) FROM Items 
LEFT JOIN Dwarves on Dwarves.dwarf_id = Items.owner_id
GROUP BY Items.type

-- 8. Найти всех гномов старше среднего возраста (по всем гномам в базе), которые не владеют никакими предметами.
  
SELECT * FROM Dwarves
WHERE age > (SELECT AVG(age) FROM Dwarves)
WHERE dwarf_id <> ALL 
(SELECT owner_id  FROM Items);
