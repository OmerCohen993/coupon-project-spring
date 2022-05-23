package com.coupon.couponprojectspring.exceptions;

public class TokenException extends Exception {
    public TokenException() {
        super("Token Exception");
    }

    public TokenException(String message) {
        super(message);
    }

}
