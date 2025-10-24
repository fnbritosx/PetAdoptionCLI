package exception;

public class TerminalExceptionCharacter extends RuntimeException {
    public TerminalExceptionCharacter(String message) {
        super(message);
    }
    public TerminalExceptionCharacter() {
        super("Você digitou um caractere em vez de um número. Digite um número válido por favor.");
    }
}
