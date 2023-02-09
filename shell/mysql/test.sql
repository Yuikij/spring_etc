BEGIN
UPDATE undo_demo set key1=2 where id = 1;
ROLLBACK
    COMMIT