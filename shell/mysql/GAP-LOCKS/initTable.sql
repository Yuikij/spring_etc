CREATE TABLE `t` (
                     `id` INT ( 11 ) NOT NULL,
                     `c` INT ( 11 ) DEFAULT NULL,
                     `d` INT ( 11 ) DEFAULT NULL,
                     PRIMARY KEY ( `id` ),
                     KEY `c` ( `c` )
) ENGINE = INNODB;

insert into t values(0,0,0),(5,5,5), (10,10,10),(15,15,15),(20,20,20),(25,25,25);

insert into t values(30,10,30);



