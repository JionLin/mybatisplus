package com.jiaolin.mybatisdemo1.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author johnny
 * @Classname SexEnum
 * @Description
 * @Date 2022/6/27 09:57
 */
@Getter
public enum SexEnum {

    MALE(0,"男"),
    FEMALE(1,"女"),
    ;

    @EnumValue
    private Integer sex;

    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
