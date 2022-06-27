package com.jiaolin.mybatisdemo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaolin.mybatisdemo1.pojo.Product;
import org.springframework.stereotype.Repository;

/**
 * @author johnny
 * @Classname ProductMapper
 * @Description
 * @Date 2022/6/27 09:33
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}