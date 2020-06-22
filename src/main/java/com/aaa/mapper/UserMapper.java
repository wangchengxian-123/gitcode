package com.aaa.mapper;

import com.aaa.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/6/19 9:49
 * @describe
 */
@Repository
public interface UserMapper {
    //展示所有员工信息
    @Select("select d.dName,u.userName,u.name,u.email,u.phoneNum,u.status,u.userId from tb_dept d,tb_user u where d.deptId=u.deptId")
     List<Map> userList();
    //添加员工
    @Insert("insert into tb_user (userName,deptId,email,phoneNum,status,passWord,salt,name) values (#{userName},#{deptId}," +
            "#{email},#{phoneNum},#{status},#{passWord},#{salt},#{name})")
    int addUser(User user);
    //shiro
    @Select("select * from tb_user where username=#{userName}")
    User findByName(String userName);
    //根据姓名查找
    @Select("select d.dName,u.userName,u.userId,u.name,u.email,u.phoneNum,u.status from tb_dept d,tb_user u where d.deptId=u.deptId and u.name=#{name}")
    List<Map> queryByName(String name);
    //删除用户
    @Update("update tb_user set status=2 where userId=#{userId}")
    int delUser(Integer userId);
    //修改信息
    @Update("update tb_user set status=#{status},userName=#{userName},deptId=#{deptId},email=#{email},phoneNum=#{phoneNum},passWord=#{passWord},name=#{name} where userId=#{userId}")
    int updUser(User user);
    //根据id查找
    @Select("select * from tb_user where userId=#{userId}")
    List<Map> queryById(Integer userId);
}
