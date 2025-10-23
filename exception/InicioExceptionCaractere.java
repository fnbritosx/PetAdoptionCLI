package exception;

public class InicioExceptionCaractere extends RuntimeException {
    public InicioExceptionCaractere(String message) {
        super(message);
    }
    public InicioExceptionCaractere() {
        super("Você digitou um caractere em vez de um número. Digite um número válido por favor.");
    }
}
