package com.aaa.service.impl;

import com.aaa.entity.User;
import com.aaa.mapper.UserMapper;
import com.aaa.service.UserService;

import com.aaa.util.EnctypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/6/19 10:05
 * @describe
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<Map> userList() {
        return userMapper.userList();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User findByName(String userName) {
        return userMapper.findByName(userName);
    }
    @Override
    public int reg(User user) {
        String encPassword = EnctypeUtil.encPassword(user.getPassWord(), user.getUserName());
        user.setPassWord(encPassword);
        //调用mapper中的录入方法
        return 0;
    }

    @Override
    public List<Map> queryByName(String name) {
        return userMapper.queryByName(name);
    }

    @Override
    public int delUser(Integer userId) {
        return userMapper.delUser(userId);
    }

    @Override
    public int updUser(User user) {
        return userMapper.updUser(user);
    }

    @Override
    public List<Map> queryById(Integer userId) {
        return userMapper.queryById(userId);
    }


}
