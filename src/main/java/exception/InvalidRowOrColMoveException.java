package exception;

public class InvalidRowOrColMoveException extends RuntimeException{

    public InvalidRowOrColMoveException(String message){
        super(message);
    }
}
