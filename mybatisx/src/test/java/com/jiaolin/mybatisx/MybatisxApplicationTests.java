package com.jiaolin.mybatisx;

import com.jiaolin.mybatisx.generator.mapper.UserMapper;
import com.jiaolin.mybatisx.generator.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class MybatisxApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

        List<User> users1 = userMapper.selectByUid(1L);
        System.out.println(users1);
    }


    @Test
    public void test2() {
        User user = new User();
        user.setUid(1L);
        user.setUserName("zs");
        int value = userMapper.insert(user);
        System.out.println(value);
    }


}
