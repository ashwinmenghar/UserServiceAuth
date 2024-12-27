package dev.ashwin.userservicemaven.exception;

public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException() {}

    public InvalidCredentialException(String message) {
        super(message);
    }
}
