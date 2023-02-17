package com.tracy.mybatisdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import com.tracy.mybatisdemo.entity.User;
import com.tracy.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    /**
     * 查询所有-list()方法
     */
    @GetMapping("/list")
    public String list() {
        List<User> list = userService.list();
        return list.toString();
    }

    /**
     * 根据年龄查询用户
     */
    @GetMapping("/queryByAge")
    public String queryByAge(Integer age) {
        // 查询名字不为空且年龄大于给定年龄的用户
        // 条件查询方式1：使用QueryWrapper,使用数据库字段
        List<User> list = userService.list(new QueryWrapper<User>().isNotNull("user_name").ge("user_age", age));
        // 条件查询方式2：使用LambdaQueryWrapper,使用POJO字段
        List<User> list1 = userService
                .list(new LambdaQueryWrapper<User>().isNotNull(User::getUserName).ge(User::getUserAge, age));
        // 条件查询方式3：使用链式query,使用数据库字段
        List<User> list2 = userService.query().isNotNull("user_name").ge("user_age", age).list();
        // 条件查询方式4：使用链式lambdaquery,使用POJO字段
        List<User> list3 = userService.lambdaQuery().isNotNull(User::getUserName).ge(User::getUserAge, age).list();
        // 只返回其中一种方式的查询结果
        return list.toString();
    }

    /**
     * 添加用户-save()
     */
    @PostMapping("/save")
    public boolean save(String userName, Integer userAge) {
        User user = new User();
        user.setUserName(userName);
        user.setUserAge(userAge);
        return userService.save(user);
    }

    /**
     * 删除用户-removeById()
     */
    @DeleteMapping("/remove")
    public boolean remove(Integer userId) {
        return userService.removeById(userId);
    }

    /**
     * 更新用户-updateById()
     */
    @PutMapping("/update")
    public boolean update(User user) {
        // 注意，参数是一个对象
        return userService.updateById(user);
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public Page<User> page(Integer pageNum, Integer pageSize) {
        Page<User> userPage = new Page<>();
        // 设置当前页
        userPage.setCurrent(pageNum);
        // 设置页面大小
        userPage.setSize(pageSize);
        // 方式1.无条件分页查询
        Page<User> page = userService.page(userPage);
        // 方式2.条件分页查询
        Page<User> pageByWrapper = userService.page(userPage,
                new LambdaQueryWrapper<User>().isNotNull(User::getUserName));
        return page;
    }

}
