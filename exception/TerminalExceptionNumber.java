package exception;

public class TerminalExceptionNumber extends RuntimeException {
    public TerminalExceptionNumber(String message) {
        super(message);
    }
    public TerminalExceptionNumber(){
        super("Entrada inválida: o número digitado não é válido. Tente novamente.");
    }
}
