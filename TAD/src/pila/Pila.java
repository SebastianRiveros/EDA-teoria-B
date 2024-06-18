package pila;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

// Implementación de una pila genérica
public class Pila<T> {
    private Nodo<T> cima; // Nodo en la parte superior de la pila
    private int tamaño; // Tamaño de la pila

    // Constructor que inicializa una pila vacía
    public Pila() {
        this.cima = null;
        this.tamaño = 0;
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }

    // Método para obtener el tamaño de la pila
    public int obtenerTamaño() {
        return tamaño;
    }

    // Método para agregar un elemento a la pila (push)
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato); // Crear un nuevo nodo con el dato proporcionado
        nuevoNodo.siguiente = cima; // Enlazar el nuevo nodo con el nodo en la cima
        cima = nuevoNodo; // Actualizar la cima para que apunte al nuevo nodo
        tamaño++; // Incrementar el tamaño de la pila
    }

    // Método para eliminar y devolver el elemento de la cima de la pila (pop)
    public T desapilar() {
        if (estaVacia()) {
            // Lanzar una excepción si la pila está vacía
            throw new ItemNotFound("La pila está vacía.");
        }
        T dato = cima.dato; // Obtener el dato del nodo en la cima
        cima = cima.siguiente; // Actualizar la cima para que apunte al siguiente nodo
        tamaño--; // Disminuir el tamaño de la pila
        return dato; // Retornar el dato eliminado
    }

    // Método para obtener el elemento de la cima de la pila sin eliminarlo (peek)
    public T cima() {
        if (estaVacia()) {
            // Lanzar una excepción si la pila está vacía
            throw new ItemNotFound("La pila está vacía.");
        }
        return cima.dato; // Retornar el dato del nodo en la cima
    }

    // Método para buscar un elemento en la pila
    public boolean buscar(T dato) {
        Nodo<T> actual = cima;
        // Recorrer la pila para buscar el dato
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true; // Retornar true si se encuentra el dato
            }
            actual = actual.siguiente;
        }
        return false; // Retornar false si no se encuentra el dato
    }

    // Método para imprimir la pila
    public void imprimir() {
        Nodo<T> actual = cima;
        // Recorrer la pila y imprimir cada dato
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null"); // Indicar el final de la pila
    }
}
