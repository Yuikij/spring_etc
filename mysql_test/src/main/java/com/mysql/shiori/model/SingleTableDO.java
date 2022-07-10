package com.mysql.shiori.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 *   `id` int NOT NULL AUTO_INCREMENT,
 *   `key1` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
 *   `key2` int DEFAULT NULL,
 *   `key3` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
 *   `key_part1` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
 *   `key_part2` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
 *   `key_part3` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
 */
@Data
@Builder
@TableName("single_table")
public class SingleTableDO {
    @TableField
    private int id;
    private String key1;
    private int key2;
    private String key3;
    private String key_part1;
    private String key_part2;
    private String key_part3;


}
