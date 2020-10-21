package com.baomidou.springboot.controller;

import java.util.Date;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.entity.enums.AgeEnum;
import com.baomidou.springboot.entity.enums.PhoneEnum;
import com.baomidou.springboot.service.IUserService;

/**
 * 代码生成器，参考源码测试用例：
 * <p>
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/MysqlGenerator.java
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 分页 PAGE
     */
    @GetMapping("/test")
    public Page<User> test() {
        return null;
    }
}
