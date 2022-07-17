package com.example.employee.exception;

public class NotFoundEmployeeException extends RuntimeException{
    public NotFoundEmployeeException() {
        super();
    }

    public NotFoundEmployeeException(String message) {
        super(message);
    }
}
