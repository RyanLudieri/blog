package br.com.unifalmg.blog.exception;

public class UserNotFoundException extends RuntimeException {


    public UserNotFoundException(String message){
        super(message);
    }
}
