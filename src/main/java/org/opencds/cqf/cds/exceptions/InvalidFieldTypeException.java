package org.opencds.cqf.cds.exceptions;

public class InvalidFieldTypeException extends RuntimeException {

    private String message;

    public InvalidFieldTypeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
