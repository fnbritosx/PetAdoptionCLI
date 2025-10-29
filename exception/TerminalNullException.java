package exception;

public class TerminalNullException extends RuntimeException {
  public TerminalNullException(String message) {
    super(message);
  }
  public TerminalNullException() {
    super("Entrada inválida: nenhum valor foi digitado. Por favor, insira um número válido:");
  }
}
