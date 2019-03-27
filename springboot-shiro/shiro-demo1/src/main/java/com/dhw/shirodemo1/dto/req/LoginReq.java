package com.dhw.shirodemo1.dto.req;

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
public class LoginReq {

    private String userName;
    private String pwd;

}