package common.error;

public class ATFException extends Exception {
    public ATFException(String message) {
        super(message);
    }

    public ATFException(String message, Throwable cause) {
        super(message, cause);
    }
}
