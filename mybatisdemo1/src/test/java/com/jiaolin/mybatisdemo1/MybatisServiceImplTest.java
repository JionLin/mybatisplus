package com.jiaolin.mybatisdemo1;

import com.jiaolin.mybatisdemo1.pojo.User;
import com.jiaolin.mybatisdemo1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author johnny
 * @Classname MybatisServiceImplTest
 * @Description
 * @Date 2022/6/26 09:47
 */
@SpringBootTest
public class MybatisServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCount(){
        System.out.println(userService.count());
    }

    @Test
    public void testInsertBatch(){

        Collection<User> users=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user=new User();
            user.setName("johnny"+i);
            user.setAge(18+i);
            users.add(user);
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b);
    }
}
