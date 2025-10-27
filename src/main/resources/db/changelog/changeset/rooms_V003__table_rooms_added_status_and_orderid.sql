-- Основная таблица апартаментов, дополнительные колонки
ALTER TABLE rooms
    ADD COLUMN IF NOT EXISTS room_status VARCHAR(16) NOT NULL,
    ADD COLUMN IF NOT EXISTS order_id BIGINT
;