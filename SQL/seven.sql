-- 7.3. Задание.

-- 7.3.1. 
--   Выведите вычислимое поле таблицы Order Details, 
--   в котором укажите значение поля Discount (скидка), выраженное в процентах.
SELECT Discount * 100 as DISCOUNT_IN_PERCENTAGE FROM [Order Details]

-- 7.3.2. 
--   Выведите все поля таблицы Order Details, для которых количество единиц товара 
--   на складе больше 40. Поле UnitsInStock (складские запасы) извлеките вложенным 
--   запросом через FK-поле ProductId, ссылающееся на таблицу Products.
SELECT * FROM [Order Details]
WHERE ProductID IN 
(SELECT ProductID FROM PRODUCTS
WHERE UnitsInStock > 40);

-- 7.3.3. 
--   Расширьте предыдущий запрос проверкой, чтобы стоимость товара 
--   (поле Freight таблицы Orders) было не менее 50. 
--   Связь с таблицей Orders происходит через FK-поле OrderID.
SELECT * FROM [Order Details]
WHERE ProductID IN 
(SELECT ProductID FROM PRODUCTS
WHERE UnitsInStock > 40)
AND 
OrderId IN 
(SELECT OrderId FROM Orders
WHERE Freight >= 50);

-- Рефлексия по заданию 6.
-- Для 6.3.1 не использовал COUNT(ContactType) для подсчета числа записей определенного типа.
