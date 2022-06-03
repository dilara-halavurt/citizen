package com.d14ai.citizen.exception;

public class NoSuchCitizenExistsException extends RuntimeException {
    private String message;

    public NoSuchCitizenExistsException() {}

    public NoSuchCitizenExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
