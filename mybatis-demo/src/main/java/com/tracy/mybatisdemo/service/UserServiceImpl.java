package com.tracy.mybatisdemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tracy.mybatisdemo.dao.UserDao;
import com.tracy.mybatisdemo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService{
}
