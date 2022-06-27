package com.jiaolin.mybatisx;

import com.jiaolin.mybatisx.generator.mapper.UserMapper;
import com.jiaolin.mybatisx.generator.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisxApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
