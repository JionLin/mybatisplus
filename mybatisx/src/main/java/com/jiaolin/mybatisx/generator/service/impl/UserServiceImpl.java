package com.jiaolin.mybatisx.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaolin.mybatisx.generator.mapper.UserMapper;
import com.jiaolin.mybatisx.generator.pojo.User;
import com.jiaolin.mybatisx.generator.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author johnny
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-06-27 13:58:56
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




