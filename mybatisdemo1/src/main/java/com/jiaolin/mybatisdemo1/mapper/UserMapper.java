package com.jiaolin.mybatisdemo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaolin.mybatisdemo1.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author johnny
 * @Classname UserMapper
 * @Description
 * @Date 2022/6/25 15:10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);

    User selectUserById(@Param("id") long id);
}
