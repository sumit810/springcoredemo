package com.luv2code.springcoredemo.exceptionHandling;

public class StudentFoundException extends RuntimeException{

    public StudentFoundException(String message){
        super(message);
    }
}
