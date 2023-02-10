SHOW
VARIABLES LIKE 'transaction_isolation';

-- 设置读未提交
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

BEGIN

-- step1 读
SELECT key1 FROM undo_demo WHERE id = 1;

-- step2 （添加写锁）写
UPDATE undo_demo set key1=2 where id = 1;

COMMIT