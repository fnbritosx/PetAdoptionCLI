package exception;

public class NamePetExcepetion extends RuntimeException {
    public NamePetExcepetion(String message) {
        super(message);
    }
    public NamePetExcepetion() {
        super("Entrada inválida: você digitou um nome inválido. Por favor, tente novamente.");
    }
}
