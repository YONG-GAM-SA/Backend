package com.yonggamsa.withsuyeonjung.user.framework.exception;

public class UserNotFoundException extends RuntimeException{

    private static final String message = "해당하는 유저를 찾을 수 없습니다";

    public UserNotFoundException() {
        super(message);
    }

    public UserNotFoundException(String userId) {
        super(message + ":: " + userId);
    }

    public UserNotFoundException(Throwable cause) {
        super(message, cause);
    }
}
