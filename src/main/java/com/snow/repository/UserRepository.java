package com.snow.repository;

import com.snow.model.SUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kelvin on 2017/2/9.
 */
@Repository
public interface UserRepository extends JpaRepository<SUserEntity, Integer> {

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update SUserEntity us set us.nickName=:qNickName, us.realName=:qRealName, us.phoneNum=:qPhoneNum, us.pwd=:qPwd where us.id=:qId")
    public void updateUser(@Param("qNickName") String nickName, @Param("qRealName") String realName,
                           @Param("qPhoneNum") String phoneNum, @Param("qPwd") String pwd, @Param("qId") Integer id);


}
