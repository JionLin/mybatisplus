package com.jiaolin.mybatisdemo1;

import com.jiaolin.mybatisdemo1.mapper.UserMapper;
import com.jiaolin.mybatisdemo1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisdemo1ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


}
