SHOW VARIABLES LIKE 'transaction_isolation';

SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;

BEGIN

insert into t values(2,2,2);

insert into t values(6,6,6);


select * from performance_schema.data_locks;

SELECT * from t where c = 7 for UPDATE;


SELECT key1 FROM undo_demo WHERE id = 1;

UPDATE t set d=d+1  where id = 15;

ROLLBACK

    COMMIT