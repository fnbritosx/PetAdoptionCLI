package exception;

public class TerminalExceptionNumber extends RuntimeException {
    public TerminalExceptionNumber(String message) {
        super(message);
    }
    public TerminalExceptionNumber(){
        super("Você digitou um número inválido.");
    }
}
