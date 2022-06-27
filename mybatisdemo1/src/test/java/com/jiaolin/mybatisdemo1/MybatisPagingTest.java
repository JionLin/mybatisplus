package com.jiaolin.mybatisdemo1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaolin.mybatisdemo1.mapper.UserMapper;
import com.jiaolin.mybatisdemo1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author johnny
 * @Classname MybatisPagingTest
 * @Description
 * @Date 2022/6/26 23:51
 */
@SpringBootTest
public class MybatisPagingTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPaging() {
        Page<User> page = new Page(1, 3);
        userMapper.selectPage(page, null);
        List<User> users = page.getRecords();
        users.forEach(System.out::println);
        System.out.println("当前页\t" + page.getCurrent());
        System.out.println("每页显示的条数：\t" + page.getSize());
        System.out.println("总记录数：\t" + page.getTotal());
        System.out.println("总页数：\t" + page.getPages());
        System.out.println("是否有上一页\t" + page.hasPrevious());
        System.out.println("是否有下一页\t" + page.hasNext());
    }


    @Test
    public void test2() {
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPageVo(page, 18);
        List<User> users = page.getRecords();
        users.forEach(System.out::println);
        System.out.println("当前页\t" + page.getCurrent());
        System.out.println("每页显示的条数：\t" + page.getSize());
        System.out.println("总记录数：\t" + page.getTotal());
        System.out.println("总页数：\t" + page.getPages());
        System.out.println("是否有上一页\t" + page.hasPrevious());
        System.out.println("是否有下一页\t" + page.hasNext());
    }
}
