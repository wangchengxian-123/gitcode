package com.aaa.service;

import com.aaa.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/6/19 10:04
 * @describe
 */
public interface UserService {
    //查询所有员工
    List<Map> userList();
    //添加员工
    int addUser(User user);
    //shiro
    User findByName(String userName);
    int reg(User user);
    //根据名字查询员工
    List<Map> queryByName(String name);
    //删除员工
    int delUser(Integer userId);
    int updUser(User user);
    List<Map> queryById(Integer userId);
}
