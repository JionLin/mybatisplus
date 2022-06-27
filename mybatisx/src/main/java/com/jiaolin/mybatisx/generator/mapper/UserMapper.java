package com.jiaolin.mybatisx.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaolin.mybatisx.generator.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author johnny
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-06-27 13:58:56
* @Entity generator.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {


    // 插入
    int insertSelective(User user);

    // 插入
    int insertAll(User user);
    // 查询
    List<User> selectByUid(@Param("uid") Long uid);

    List<User> selectUidAndAge();


    int deleteByUid(@Param("uid") Long uid);

    int deleteUidAndAgeByUid(@Param("uid") Long uid);

}




