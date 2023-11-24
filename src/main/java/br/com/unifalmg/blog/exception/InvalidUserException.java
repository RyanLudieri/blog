package br.com.unifalmg.blog.exception;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String message){
        super(message);
    }

}
