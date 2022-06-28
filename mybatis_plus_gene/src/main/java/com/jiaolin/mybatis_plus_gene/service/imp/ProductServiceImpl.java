package com.jiaolin.mybatis_plus_gene.service.imp;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaolin.mybatis_plus_gene.mapper.ProductMapper;
import com.jiaolin.mybatis_plus_gene.pojo.Product;
import com.jiaolin.mybatis_plus_gene.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author johnny
 * @Classname ProductServiceImpl
 * @Description
 * @Date 2022/6/28 14:42
 */
@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
