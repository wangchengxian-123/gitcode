package com.aaa.controller;

import com.aaa.entity.User;
import com.aaa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/6/19 10:07
 * @describe
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //员工列表
    @GetMapping("/list")
    public String userList(Map map){
        List<Map> list = userService.userList();
        map.put("user",list);
        return "main";
    }
    //添加员工
    @RequestMapping("/toAdd")
    public String addUser(Map map,Integer userId){
        List<Map> list = userService.userList();
        map.put("user",list);
        return "add_user";
    }
    //保存添加的员工
    @PostMapping("/save")
    public String save(User user){
        int i = userService.addUser(user);
        return "redirect:list";
    }
    //查找某个员工
    @PostMapping("/queryByName")
    public String findOne(String name,Map map){
        List<Map> list = userService.queryByName(name);
        map.put("user",list);
        return "main";
    }
    @GetMapping("/del")
    public String delUser(Integer userId){
        int i = userService.delUser(userId);
        return "redirect:list";
    }
    //修改员工
    @GetMapping("/upd")
    public String updUser(Integer userId,Map map){
        List<Map> list = userService.queryById(userId);
        map.put("user",list);
        return "upd_user";
    }
    //保存修改的员工信息
    @PostMapping("/updSave")
    public String updSave(User user){
        int i = userService.updUser(user);
        return "redirect:list";
    }

}
