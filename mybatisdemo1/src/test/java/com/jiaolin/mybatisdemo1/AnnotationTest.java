package com.jiaolin.mybatisdemo1;

import com.jiaolin.mybatisdemo1.pojo.User;
import com.jiaolin.mybatisdemo1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author johnny
 * @Classname AnotationTest
 * @Description 注解测试
 * @Date 2022/6/26 09:55
 */
@SpringBootTest
public class AnnotationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testTableName() {
        User byId = userService.getById(1L);
        System.out.println(byId);
    }

    @Test
    public void testInsert() {

        User user = new User();
        user.setAge(18);
        boolean save = userService.save(user);
        System.out.println(save);
    }

    @Test
    public void testFiledName() {

        User user = new User();
        user.setAge(18);
        user.setName("xq");
        boolean save = userService.save(user);
        System.out.println(save);
    }

    @Test
    public void testTableLogic() {
        boolean value = userService.removeById(3L);
        System.out.println(value);
    }


}
