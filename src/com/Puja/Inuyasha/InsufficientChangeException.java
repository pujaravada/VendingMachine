package com.Puja.Inuyasha;

/**
 * Created by Puja on 3/20/17.
 */
public class InsufficientChangeException extends RuntimeException {
    private String message;
    public InsufficientChangeException(String string)
    { this.message = string; }

    @Override
    public String getMessage(){ return message; } }

