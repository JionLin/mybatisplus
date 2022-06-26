package com.jiaolin.mybatisdemo1;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jiaolin.mybatisdemo1.mapper.UserMapper;
import com.jiaolin.mybatisdemo1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author johnny
 * @Classname WapperMybatisTest
 * @Description
 * @Date 2022/6/26 17:27
 */
@SpringBootTest
public class WapperMybatisTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        // 查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWapper = new QueryWrapper<>();
        queryWapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test2() {
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWapper = new QueryWrapper<>();
        queryWapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> users = userMapper.selectList(queryWapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test3() {
        //删除email为空的用户
        QueryWrapper<User> wapper = new QueryWrapper<>();
        wapper.isNull("email");
        int value = userMapper.delete(wapper);
        System.out.println(value);
    }

    @Test
    public void test4() {
        // 将(年龄大于20并且用户名中包含有a)或邮箱为null的用户信息修改
        // wapper 是进行匹配的条件
        // user 对象是为修改后的值
        QueryWrapper<User> wapper = new QueryWrapper<>();
        wapper.gt("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setAge(18);
        int value = userMapper.update(user, wapper);
        System.out.println(value);

    }

    @Test
    public void test5() {
        //将用户名中包含有a并且(年龄大于20或邮箱为null)的用户信息修改
        // 优先条件 需要使用and() 包含起来,去里面进行运算
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "a")
                .and(i -> i.gt("age", 20)
                        .or()
                        .isNull("email"));
        User user = new User();
        user.setAge(18);
        int value = userMapper.update(user, queryWrapper);
        System.out.println(value);

    }

    @Test
    public void test6() {
        //查询用户信息的username和age字段
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test7() {
        //实现子查询  查询id小于等于3的用户信息
        // select * from user where id in(select id from user id <=3)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid", "select uid from t_user where uid <= 10");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    @Test
    public void test8() {
        //将(年龄大于20或邮箱为null)并且用户名中包含有a的用户信息修改
        // ==>  Preparing: UPDATE t_user SET age=? WHERE is_delete=0 AND (age > ? AND email IS NULL AND user_name LIKE ?)
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age", 18)
                .set("email", "xxx@qq.com")
                .and(i -> i.gt("age", 20)
                        .or()
                        .isNull("email"))
                .like("user_name", 'a')
        ;
        int value = userMapper.update(null, wrapper);
        System.out.println(value);
    }

    @Test
    public void test9() {
        //定义查询条件，有可能为null(用户未输入或未选择)
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "user_name", "a")
                .gt(ageBegin != null, "age", ageBegin)
                .lt(ageEnd != null, "age", ageEnd);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    @Test
    public void test10() {
        // lambda 表达式 //定义查询条件，有可能为null(用户未输入)
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        String username = "a";
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        wrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .gt(ageBegin != null, User::getAge, ageBegin)
                .lt(ageEnd != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test11() {
        //组装set子句
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(User::getAge, 18)
                .like(User::getName, "a")
                .and(i -> i.lt(User::getAge, 20).or().isNull(User::getEmail));
        User user=new User();
        int value = userMapper.update(user, updateWrapper);
        System.out.println(value);

    }
}
