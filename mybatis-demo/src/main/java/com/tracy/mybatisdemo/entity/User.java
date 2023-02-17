package com.tracy.mybatisdemo.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;


// 建立实体类和数据库表之间的对应关系
@TableName("tb_user")
// 添加getter，setter，toString等方法
@Data
public class User {
    // 用于标识数据库表的主键字段，MP 默认数据库表中名为 id 的字段是主键，如若不是，需通过该注解进行标识。
    // type = IdType.AUTO 表示数据库主键自增
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer id;

    // 建立实体类字段和数据库表属性之间的对应关系，当两者相同时可省略该注解。
    @TableField
    private String userName;

    private Integer userAge;

}
