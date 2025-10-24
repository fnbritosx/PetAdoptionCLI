package exception;

public class TerminalNullException extends RuntimeException {
  public TerminalNullException(String message) {
    super(message);
  }
  public TerminalNullException() {
    super("Você não digitou nada. Por favor, digite um número válido: ");
  }
}
