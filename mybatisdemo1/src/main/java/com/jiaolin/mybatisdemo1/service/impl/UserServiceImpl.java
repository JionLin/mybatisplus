package com.jiaolin.mybatisdemo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaolin.mybatisdemo1.mapper.UserMapper;
import com.jiaolin.mybatisdemo1.pojo.User;
import com.jiaolin.mybatisdemo1.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author johnny
 * @Classname UserServiceImpl
 * @Description
 * @Date 2022/6/26 09:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
