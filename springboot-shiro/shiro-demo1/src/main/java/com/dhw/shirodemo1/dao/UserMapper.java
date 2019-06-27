package com.dhw.shirodemo1.dao;

import com.dhw.shirodemo1.model.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {

    UserInfo selectUserByNameAndPwd(@Param ("loginName") String loginName, @Param ("password") String password);

    @Select ("SELECT * FROM tb_user_info")
    // 返回 Map 结果集
    @Results ( { @Result (property = "id", column = "id"), @Result (property = "loginName", column = "login_name"),
            @Result (property = "cnName", column = "cnName"), })
    UserInfo findByName(@Param ("loginName") String loginName);
}
