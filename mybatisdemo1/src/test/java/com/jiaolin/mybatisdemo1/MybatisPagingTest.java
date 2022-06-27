package com.jiaolin.mybatisdemo1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaolin.mybatisdemo1.mapper.ProductMapper;
import com.jiaolin.mybatisdemo1.mapper.UserMapper;
import com.jiaolin.mybatisdemo1.pojo.Product;
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

    @Autowired
    private ProductMapper productMapper;

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

    @Test
    public void test3() {
        Product p1 = productMapper.selectById(1L);
        System.out.println("小李取出的价格:" + p1.getPrice());

        Product p2 = productMapper.selectById(1L);
        System.out.println("小王取出的价格:" + p2.getPrice());

        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改结果:" + result1);

//4、小王将商品减了30元，存入了数据库
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        if (result2 == 0) {
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            productMapper.updateById(p2);
        }
        System.out.println("小王修改结果:" + result2);

        Product p3 = productMapper.selectById(1L); //价格覆盖，最后的结果:70 System.out.println("最后的结果:" + p3.getPrice());
        System.out.println("最后的结果" + p3);
    }
}
