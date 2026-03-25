-- 12.3. Задания

-- 12.3.1. 
--   Добавьте нового пользователя в таблицу Employees.
INSERT INTO Employees(LastName, FirstName, City, Country, Address, ReportsTo, Title, HireDate) 
VALUES ('Sidorov', 'Ivan', 'Novgorod', 'Russia', 'Proletarskaya 10', 2, 'Intern', '2025-10-10'); 

-- 12.3.2. 
--   Свяжите этого нового пользователя с какой-либо территорией с помощью таблицы EmployeeTerritories (многие-ко-многим).
INSERT INTO EmployeeTerritories(EmployeeID, TerritoryID) 
VALUES (14, '03801'); 

-- 12.3.3. 
--   Попробуйте добавить новую запись в таблицу заказов Orders. Возникнут ли какие-либо конфликты?
INSERT INTO Orders(CustomerID, EmployeeID) 
VALUES ('VINET', 14); 
-- Конфликты не возникли. Только возникнет, если я захочу задать пустые значения таким образом:
INSERT INTO [Order Details] DEFAULT VALUES;
-- Если будут вручную задавать пустые значения, id автоматически проставится для OrderId и не будет ошибки.
INSERT INTO Orders(CustomerID) 
VALUES (null); 

-- Рефлексия по заданию 11.
-- Не соединил по условию "Orders.CustomerID = Customers.CustomerID". Не сделал сортировку по типу.
