package com.jiaolin.mybatisdemo1.pojo;

import lombok.Data;

/**
 * @author johnny
 * @Classname User
 * @Description
 * @Date 2022/6/25 15:09
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
