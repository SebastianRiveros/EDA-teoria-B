package exceptions;

// Excepción personalizada para manejar el caso en que un elemento no se encuentra en el árbol.
public class ItemNotFound extends RuntimeException {
    public ItemNotFound(String message) {
        super(message);
    }
}
