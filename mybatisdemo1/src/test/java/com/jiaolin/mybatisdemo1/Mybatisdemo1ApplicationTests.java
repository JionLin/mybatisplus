package com.jiaolin.mybatisdemo1;

import com.jiaolin.mybatisdemo1.mapper.UserMapper;
import com.jiaolin.mybatisdemo1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisdemo1ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


    @Test
    public void test2(){
        User user=new User();
        user.setAge(18);
        user.setEmail("xxx.com");
        user.setName("xz");
        int value = userMapper.insert(user);
        System.out.println(value);
        System.out.println(user.getId());
    }
    @Test
    public void testDeleteMap(){
        Map<String, Object> map=new HashMap<>();
        map.put("age", 18);
        map.put("name", "xz");
        int value = userMapper.deleteByMap(map);
        System.out.println(value);
    }


    @Test
    public void testUpdate(){

        User user=new User();
        user.setId(3L);
        user.setAge(22);
        user.setName("johnny");
        int value = userMapper.updateById(user);
        System.out.println(value);
    }

    @Test
    public void testByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("age", 18);
        map.put("name","johnny");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }







}
