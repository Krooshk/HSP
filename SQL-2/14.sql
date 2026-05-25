-- Задача 4*: Комплексный анализ торговых отношений и их влияния на крепость

SELECT 
  (SELECT COUNT(DISTINCT c.civilization_type)
  FROM CARAVANS c
  ) as total_trading_partners,
  (
  SELECT COALESCE(SUM(tt.value), 0)
  FROM TRADE_TRANSACTIONS tt
  ) as all_time_trade_value,
  
  JSON_OBJECT(
        'civilization_trade_data', (
            SELECT JSON_ARRAYAGG(civ_row)
            FROM (
                SELECT JSON_OBJECT(
                    'civilization_type', c.civilization_type,

                    'total_caravans', COUNT(DISTINCT c.caravan_id),

                    'total_trade_value', (
                        SELECT COALESCE(SUM(tt.value), 0)
                        FROM TRADE_TRANSACTIONS tt
                        WHERE tt.caravan_id IN (
                            SELECT c2.caravan_id FROM CARAVANS c2
                            WHERE c2.civilization_type = c.civilization_type
                        )
                    ),

                    'trade_balance', (
                        SELECT COALESCE(SUM(
                            CASE tt.balance_direction
                                WHEN 'Fortress' THEN tt.value
                                WHEN 'Caravan'  THEN -tt.value
                                ELSE 0
                            END
                        ), 0)
                        FROM TRADE_TRANSACTIONS tt
                        WHERE tt.caravan_id IN (
                            SELECT c2.caravan_id FROM CARAVANS c2
                            WHERE c2.civilization_type = c.civilization_type
                        )
                    ),

                    'trade_relationship', CASE
                        WHEN (
                            SELECT COALESCE(SUM(
                                CASE tt.balance_direction
                                    WHEN 'Fortress' THEN tt.value
                                    WHEN 'Caravan'  THEN -tt.value
                                    ELSE 0
                                END), 0)
                            FROM TRADE_TRANSACTIONS tt
                            WHERE tt.caravan_id IN (
                                SELECT c2.caravan_id FROM CARAVANS c2
                                WHERE c2.civilization_type = c.civilization_type
                            )
                        ) > 0 THEN 'Favorable'
                        ELSE 'Unfavorable'
                    END,

                    'caravan_ids', (
                        SELECT JSON_ARRAYAGG(c3.caravan_id)
                        FROM CARAVANS c3
                        WHERE c3.civilization_type = c.civilization_type
                    )
                ) AS civ_row
                FROM CARAVANS c
                GROUP BY c.civilization_type
            ) AS civ_summary
        )
    )
) AS trade_analysis;

