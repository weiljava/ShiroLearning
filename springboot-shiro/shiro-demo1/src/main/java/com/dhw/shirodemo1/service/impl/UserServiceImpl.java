package com.dhw.shirodemo1.service.impl;

import com.dhw.shirodemo1.dao.UserMapper;
import com.dhw.shirodemo1.exception.UserException;
import com.dhw.shirodemo1.model.domain.UserInfo;
import com.dhw.shirodemo1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/6/26
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserByLoginNameAndPwd(String loginName, String password) throws UserException {
        UserInfo selectUser = userMapper.selectUserByNameAndPwd(loginName, password);
        if (selectUser == null) {
            throw new UserException("账号密码不匹配");
        } else {
            return selectUser;
        }
    }

    @Override
    public UserInfo getUserByLoginName(String loginName) {
        return userMapper.findByName(loginName);
    }
}