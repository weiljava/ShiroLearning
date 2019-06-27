package com.dhw.shirodemo1.model.domain;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/3/27
 * Time: 9:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
public class UserInfo {

    private long id;
    private String loginName;
    private String password;
    private String cnName;

}