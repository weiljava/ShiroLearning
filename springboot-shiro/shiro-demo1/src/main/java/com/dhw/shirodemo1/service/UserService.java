package com.dhw.shirodemo1.service;

import com.dhw.shirodemo1.exception.UserException;
import com.dhw.shirodemo1.model.domain.UserInfo;

public interface UserService {

    UserInfo getUserByLoginNameAndPwd(String loginName, String password) throws UserException;

    UserInfo getUserByLoginName(String loginName);
}
