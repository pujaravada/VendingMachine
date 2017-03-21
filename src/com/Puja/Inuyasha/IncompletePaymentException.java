package com.Puja.Inuyasha;

/**
 * Created by Puja on 3/20/17.
 */

public class IncompletePaymentException extends RuntimeException
{
    private String message;
    private long remaining;
    public IncompletePaymentException(String message, long remaining)
    {
        this.message = message;
        this.remaining = remaining;
    }
    public long getRemaining()
    {
        return remaining;
    }
    @Override
    public String getMessage()
    {
        return message + remaining;
    }
}
