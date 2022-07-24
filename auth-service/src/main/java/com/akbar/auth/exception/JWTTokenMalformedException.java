package com.akbar.auth.exception;

import javax.naming.AuthenticationException;

public class JWTTokenMalformedException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public JWTTokenMalformedException(String msg) {
        super(msg);
    }
}
