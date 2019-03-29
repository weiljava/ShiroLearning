package com.dhw.shirodemo1.model.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

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
    @NotBlank (message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String pwd;

}