package com.jiaolin.mybatis_plus_gene.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author johnny
 * @Classname User
 * @Description
 * @Date 2022/6/28 14:36
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


    private Integer sex;

    private Integer isDelete;
}
