package com.aaa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WCX
 * @data 2020/6/19 9:43
 * @describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    Integer userId;
    String userName;
    Integer deptId;
    String email;
    String phoneNum;
    Integer status;
    String passWord;
    String salt;
    String name;
}
