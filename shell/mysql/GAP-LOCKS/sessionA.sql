SHOW VARIABLES LIKE 'transaction_isolation';

SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;

BEGIN

select * from t where id>9 and id<12  for update;

select * from t where id>=10 and id<11 for update;

select * from t where id>9 and id<12 order by id asc for update;


select * from t where id>9 and id<12 order by id desc for update;


SELECT * from t where c = 7 lock in share mode;

UPDATE undo_demo set key1=2 where id = 1;

ROLLBACK

    COMMIT