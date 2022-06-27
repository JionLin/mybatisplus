package com.jiaolin.mybatisdemo1.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.jiaolin.mybatisdemo1.enums.SexEnum;
import lombok.Data;

/**
 * @author johnny
 * @Classname User
 * @Description
 * @Date 2022/6/25 15:09
 */
@Data
@TableName("t_user")
public class User {
    @TableId(value = "uid",type = IdType.AUTO)
    private Long uid;
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;


    private SexEnum sex;

    @TableLogic
    private Integer isDelete;
}
