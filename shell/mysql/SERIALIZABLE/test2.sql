SHOW
VARIABLES LIKE 'transaction_isolation';

-- 设置读未提交
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;

BEGIN

-- step2 （尝试添加读锁...）读 ---------- 会阻塞
SELECT key1 FROM undo_demo WHERE id = 1;

COMMIT