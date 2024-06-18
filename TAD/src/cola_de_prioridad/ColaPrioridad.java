package cola_de_prioridad;

import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

// Implementación de una cola de prioridad genérica
public class ColaPrioridad<T> {
    private Nodo<T> cabeza; // Nodo con la mayor prioridad
    private int tamaño; // Tamaño de la cola de prioridad

    // Constructor que inicializa una cola de prioridad vacía
    public ColaPrioridad() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    // Método para verificar si la cola de prioridad está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Método para obtener el tamaño de la cola de prioridad
    public int obtenerTamaño() {
        return tamaño;
    }

    // Método para agregar un elemento a la cola de prioridad
    public void encolar(T dato, int prioridad) {
        Nodo<T> nuevoNodo = new Nodo<>(dato, prioridad); // Crear un nuevo nodo con el dato y la prioridad proporcionados
        if (estaVacia() || cabeza.prioridad < prioridad) {
            // Si la cola de prioridad está vacía o la prioridad del nuevo nodo es mayor que la del primer nodo
            nuevoNodo.siguiente = cabeza; // Enlazar el nuevo nodo con el antiguo primer nodo
            cabeza = nuevoNodo; // Actualizar la cabeza para que apunte al nuevo nodo
        } else {
            Nodo<T> actual = cabeza;
            // Recorrer la cola de prioridad para encontrar la posición correcta del nuevo nodo
            while (actual.siguiente != null && actual.siguiente.prioridad >= prioridad) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente; // Enlazar el nuevo nodo con el nodo siguiente
            actual.siguiente = nuevoNodo; // Enlazar el nodo actual con el nuevo nodo
        }
        tamaño++; // Incrementar el tamaño de la cola de prioridad
    }

    // Método para eliminar y devolver el elemento con la mayor prioridad (dequeue)
    public T desencolar() {
        if (estaVacia()) {
            // Lanzar una excepción si la cola de prioridad está vacía
            throw new ItemNotFound("La cola de prioridad está vacía.");
        }
        T dato = cabeza.dato; // Obtener el dato del nodo con la mayor prioridad
        cabeza = cabeza.siguiente; // Actualizar la cabeza para que apunte al siguiente nodo
        tamaño--; // Disminuir el tamaño de la cola de prioridad
        return dato; // Retornar el dato eliminado
    }

    // Método para obtener el elemento con la mayor prioridad sin eliminarlo (peek)
    public T cima() {
        if (estaVacia()) {
            // Lanzar una excepción si la cola de prioridad está vacía
            throw new ItemNotFound("La cola de prioridad está vacía.");
        }
        return cabeza.dato; // Retornar el dato del nodo con la mayor prioridad
    }

    // Método para buscar un elemento en la cola de prioridad
    public boolean buscar(T dato) {
        Nodo<T> actual = cabeza;
        // Recorrer la cola de prioridad para buscar el dato
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true; // Retornar true si se encuentra el dato
            }
            actual = actual.siguiente;
        }
        return false; // Retornar false si no se encuentra el dato
    }

    // Método para imprimir la cola de prioridad
    public void imprimir() {
        Nodo<T> actual = cabeza;
        // Recorrer la cola de prioridad y imprimir cada dato junto con su prioridad
        while (actual != null) {
            System.out.print("(" + actual.dato + ", " + actual.prioridad + ") -> ");
            actual = actual.siguiente;
        }
        System.out.println("null"); // Indicar el final de la cola de prioridad
    }
}
