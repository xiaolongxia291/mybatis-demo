package com.tracy.mybatisdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tracy.mybatisdemo.entity.User;
import org.springframework.stereotype.Repository;


@Repository
// 继承Mybatis-Plus提供的BaseMapper，提供基础的CRUD及分页方法
public interface UserDao extends BaseMapper<User> {
}
