-- Рефлексия

Не использовался WITH для создания временного запроса. 
Опечатался здесь: w.name AS workshop_type (надо было написать w.type). 
Не сделал LEFT JOIN с другими таблицами, для каждого значения вложенные запросы использовал. 
total_quantity_produced - сделал правильно.
total_production_value - не умножил каждое значение value на wp.quantity.
num_craftsdwarves, products_produced -  не использовал DISTINCT, поэтому могут учитываться повторябщиеся id.
daily_production_rate - сделал аналогично, но во вложенном запросе всё.
craftsdwarf_skills - неправильно сделал.
related_entities - сделал правильно.
Не посчитал метрики.
