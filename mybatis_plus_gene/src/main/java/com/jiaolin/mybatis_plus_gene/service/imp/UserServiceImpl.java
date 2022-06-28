package com.jiaolin.mybatis_plus_gene.service.imp;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaolin.mybatis_plus_gene.mapper.UserMapper;
import com.jiaolin.mybatis_plus_gene.pojo.User;
import com.jiaolin.mybatis_plus_gene.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author johnny
 * @Classname UserServiceImpl
 * @Description
 * @Date 2022/6/28 14:38
 */
@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
