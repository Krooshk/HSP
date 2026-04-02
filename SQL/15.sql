-- 15.7. Задание
--   Создайте в новой базе таблицу Territories со структурой, 
--   аналогичной структуре таблицы Territories из учебной базы. 
--   Добавьте в неё и таблицу Region несколько значений так, 
--   чтобы они оказались связаны друг с другом через FK.

USE MyTest
CREATE TABLE Territories (
    TerritoryId nvarchar(20) NOT NULL, 
    TerritoryDescription nchar(50) NOT NULL,
    RegionID int NOT NULL); 

USE MyTest
INSERT INTO Region (RegionId,RegionDescription)
VALUES(1, 'Odintsovo')

USE MyTest
INSERT INTO Territories (TerritoryId, TerritoryDescription, RegionId)
VALUES(1, 'Moscow', 1)


-- Рефлексия по заданию 14.
-- Описал немного другими словами, в основном суть такая же.
