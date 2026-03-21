-- 10.4. Задания

-- 10.4.1. 
--   Перепишите задание 8.3.2 через синтаксис JOIN.
--   8.3.2 Организуйте эквисоединение, которое выводит цену и названия тех товаров, для которых цена за единицу (UnitPrice) в таблице Order Details меньше 20.
SELECT Products.ProductName, [Order Details].UnitPrice FROM Products
JOIN [Order Details]
ON Products.ProductID = [Order Details].ProductID 
AND
[Order Details].UnitPrice < 20;

-- 10.4.2. 
--   Имеется запрос
---- Значение NULL встречается только в одном поле набора. Появляется, потому что для Customers не нашлось нужного совпадения(нет в заказах нужной компании).

-- 10.4.3. 
--   Подумайте, как с помощью предложения WHERE превратить запрос CROSS JOIN в INNER JOIN. 
---- Использовать предложение WHERE в условии ON

-- 10.4.4. 
--   Перепишите данный запрос в INNER JOIN:
SELECT Products.ProductName, [Order Details].UnitPrice
FROM Products INNER JOIN [Order Details]
ON Products.ProductID = [Order Details].ProductID

-- Рефлексия по заданию 9.
-- Сделал аналогичным образом.
