Задание 3.9

-- 3.9.1.
SELECT ProductName, UnitsInStock FROM Products 

--3.9.2. 
SELECT ProductName, UnitPrice FROM Products
WHERE UnitPrice < 20

--3.9.3.
SELECT * FROM Orders
WHERE Freight > 11.7 AND Freight < 98.1

--3.9.4. 
SELECT * FROM Employees
WHERE TitleOfCourtesy = 'Mr.' OR TitleOfCourtesy = 'Dr.'

--3.9.5.
SELECT * FROM Suppliers
WHERE Country = 'Japan'

--3.9.6. Отберите все заказы, для которых идентификатор сотрудника-исполнителя равен 2, 4 или 8.
SELECT * FROM Orders
WHERE EmployeeID = 2 OR EmployeeID = 4 OR EmployeeID = 8

--3.9.7. 
SELECT OrderId, ProductId FROM [Order Details]
WHERE UnitPrice > 40 AND Quantity < 10

-- Рефлексия по заданию 2.
-- EmployeeTerritories  - промежуточную таблицу причислил к "один-к-одному"
-- Сделал не в ту сторону. То есть написал, что Products -> Suppliers, Products -> Categories являются
-- "один ко многим", а не наоборот Suppliers -> Products  и т.д..
-- Также не расписал в отношении противоположного направления Orders -> (Customers, Employees, Shippers	) и Territories -> Region

