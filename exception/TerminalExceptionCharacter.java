package exception;

public class TerminalExceptionCharacter extends RuntimeException {
    public TerminalExceptionCharacter(String message) {
        super(message);
    }
    public TerminalExceptionCharacter() {
        super("Entrada inválida: foi digitado um caractere em vez de um número. Por favor, insira um número válido.");
    }
}
