-- REPEATABLE READ   | READ COMMITTED   | READ UNCOMMITTED   | SERIALIZABLE

SHOW VARIABLES LIKE 'transaction_isolation';

-- 设置读未提交
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

BEGIN

-- step3 （尝试添加写锁...）写 ---------- 会阻塞
UPDATE undo_demo set key1=2 where id = 1;

COMMIT