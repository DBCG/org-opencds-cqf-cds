package com.alphora.exceptions;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {}

    public NotImplementedException(String message) {
        super(message);
    }
}
