package com.jiaolin.mybatis_plus_gene.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author johnny
 * @Classname Product
 * @Description
 * @Date 2022/6/28 14:36
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer version;
}