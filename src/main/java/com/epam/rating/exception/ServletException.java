package com.epam.rating.exception;

public class ServletException extends Exception{
    public ServletException() {
    }

    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Exception e) {
        super(message, e);
    }

    public ServletException(Exception e) {
        super(e);
    }
}
