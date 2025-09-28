package six.jay.EventClean.infrastructure.exception;

public class DuplicateEventException extends RuntimeException{

    public DuplicateEventException(String message){
        super(message);
    }
}
