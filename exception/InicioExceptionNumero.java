package exception;

public class InicioExceptionNumero extends RuntimeException {
    public InicioExceptionNumero(String message) {
        super(message);
    }
    public InicioExceptionNumero(){
        super("Você digitou um número inválido.");
    }
}
