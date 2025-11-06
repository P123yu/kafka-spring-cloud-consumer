package com.cms.demo.CitizenLiseningSystem.exception;


public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(String message) {
        super(message);
    }

}
