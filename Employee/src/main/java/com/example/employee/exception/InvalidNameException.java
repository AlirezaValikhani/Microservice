package com.example.employee.exception;

public class InvalidNameException extends RuntimeException{

    public InvalidNameException() {
        super();
    }

    public InvalidNameException(String message) {
        super(message);
    }
}
