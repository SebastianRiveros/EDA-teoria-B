package cola;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

// Implementación de una cola genérica
public class Cola<T> {
    private Nodo<T> frente; // Nodo al frente de la cola
    private Nodo<T> fondo; // Nodo al fondo de la cola
    private int tamaño; // Tamaño de la cola

    // Constructor que inicializa una cola vacía
    public Cola() {
        this.frente = null;
        this.fondo = null;
        this.tamaño = 0;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Método para obtener el tamaño de la cola
    public int obtenerTamaño() {
        return tamaño;
    }

    // Método para agregar un elemento a la cola (enqueue)
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato); // Crear un nuevo nodo con el dato proporcionado
        if (estaVacia()) {
            frente = nuevoNodo; // Si la cola está vacía, el nuevo nodo es el frente
        } else {
            fondo.siguiente = nuevoNodo; // Enlazar el último nodo con el nuevo nodo
        }
        fondo = nuevoNodo; // Actualizar el fondo para que apunte al nuevo nodo
        tamaño++; // Incrementar el tamaño de la cola
    }

    // Método para eliminar y devolver el elemento del frente de la cola (dequeue)
    public T desencolar() {
        if (estaVacia()) {
            // Lanzar una excepción si la cola está vacía
            throw new ItemNotFound("La cola está vacía.");
        }
        T dato = frente.dato; // Obtener el dato del nodo en el frente
        frente = frente.siguiente; // Actualizar el frente para que apunte al siguiente nodo
        if (frente == null) {
            fondo = null; // Si la cola se vacía, actualizar el fondo a null
        }
        tamaño--; // Disminuir el tamaño de la cola
        return dato; // Retornar el dato eliminado
    }

    // Método para obtener el elemento del frente de la cola sin eliminarlo (peek)
    public T frente() {
        if (estaVacia()) {
            // Lanzar una excepción si la cola está vacía
            throw new ItemNotFound("La cola está vacía.");
        }
        return frente.dato; // Retornar el dato del nodo en el frente
    }

    // Método para buscar un elemento en la cola
    public boolean buscar(T dato) {
        Nodo<T> actual = frente;
        // Recorrer la cola para buscar el dato
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true; // Retornar true si se encuentra el dato
            }
            actual = actual.siguiente;
        }
        return false; // Retornar false si no se encuentra el dato
    }

    // Método para imprimir la cola
    public void imprimir() {
        Nodo<T> actual = frente;
        // Recorrer la cola y imprimir cada dato
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null"); // Indicar el final de la cola
    }
}
