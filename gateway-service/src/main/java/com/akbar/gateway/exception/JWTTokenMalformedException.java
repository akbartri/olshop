package com.akbar.gateway.exception;

import javax.naming.AuthenticationException;

public class JWTTokenMalformedException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public JWTTokenMalformedException(String msg) {
        super(msg);
    }
}
