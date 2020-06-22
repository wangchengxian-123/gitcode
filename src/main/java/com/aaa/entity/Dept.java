package com.aaa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WCX
 * @data 2020/6/19 9:33
 * @describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Dept {
    Integer deptId;
    String dName;
    String remark;
}
