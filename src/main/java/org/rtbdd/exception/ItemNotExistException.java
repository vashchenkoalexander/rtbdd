package org.rtbdd.exception;

public class ItemNotExistException extends RuntimeException{
    public ItemNotExistException(String message) {
        super(message);
    }
}
