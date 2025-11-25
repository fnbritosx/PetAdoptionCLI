package exception;

public class MenuNumberException extends RuntimeException {
    public MenuNumberException(String message) {
        super(message);
    }
    public MenuNumberException(){
        super("Entrada inválida: o valor digitado não é um número válido. Tente novamente.");
    }
}
