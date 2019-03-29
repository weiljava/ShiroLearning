package com.dhw.shirodemo1.model.resp;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/3/27
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
public class Result {

    private String code;
    private String msg;

    public Result() {
    }

    public Result(String code) {
        this.code = code;
    }
}