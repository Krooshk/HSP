-- 6.3. Задания

-- 6.3.1. 
--   Выполните агрегацию таблицы Contacts по полю ContactType.
SELECT ContactType FROM Contacts
GROUP BY ContactType;

-- 6.3.2. 
--   Выведите средние цены товаров (UnitPrice) в каждой 
--   из категорий (CategoryId) таблицы Products, отсортированные по возрастанию.
SELECT AVG(UnitPrice) as AVG_PRICE, CategoryID FROM Products
GROUP BY CategoryID
ORDER BY AVG_PRICE;

-- Рефлексия по заданию 5.
-- Сделал аналогичным образом.
