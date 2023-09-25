package src;

public class ArrayException extends Exception{
    private final static String exception = "Array can't have more than 10 elements";
    ArrayException() {
        super(exception);
    }

    @Override
    public String getMessage(){
        return exception;
    }
}
