package com.jiaolin.mybatisdemo1.pojo;

import com.baomidou.mybatisplus.annotation.*;
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

    @TableLogic
    private Integer isDelete;
}
