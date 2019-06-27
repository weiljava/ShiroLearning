package com.dhw.shirodemo1.exception;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/6/26
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UserException extends Exception {
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}