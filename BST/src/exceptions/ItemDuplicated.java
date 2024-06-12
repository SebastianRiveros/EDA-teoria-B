package exceptions;

// Excepción personalizada para manejar el caso en que un elemento duplicado se intenta insertar en el árbol.
public class ItemDuplicated extends Exception {
    public ItemDuplicated(String message) {
        super(message);
    }
}
