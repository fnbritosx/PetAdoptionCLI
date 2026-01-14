package model.exception;

public class DeletePetException extends RuntimeException {
    public DeletePetException(String message) {
        super(message);
    }
}
