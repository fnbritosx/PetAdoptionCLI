package exception;

public class InicioNullException extends RuntimeException {
  public InicioNullException(String message) {
    super(message);
  }
  public InicioNullException() {
    super("Você não digitou nada. Por favor, digite um número válido: ");
  }
}
