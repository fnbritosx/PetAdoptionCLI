package src.model.exception;

public class MenuNumberException extends RuntimeException {
    public MenuNumberException(String message) {
        super(message);
    }

    public MenuNumberException() {
        super("Entrada inválida: Por favor, digite um número válido!");
    }
}
