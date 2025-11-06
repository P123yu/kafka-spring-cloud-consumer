package com.cms.demo.CitizenLiseningSystem.exception;


public class RefreshTokenExpired extends RuntimeException{
    public RefreshTokenExpired(String message) {
        super(message);
    }

}
