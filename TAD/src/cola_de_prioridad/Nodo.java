package cola_de_prioridad;

// Clase Nodo que contiene un dato y una referencia al siguiente nodo en la cola de prioridad
class Nodo<T> {
    T dato; // Dato almacenado en el nodo
    int prioridad; // Prioridad del nodo
    Nodo<T> siguiente; // Referencia al siguiente nodo

    // Constructor que inicializa el dato y la prioridad y establece la referencia siguiente a null
    Nodo(T dato, int prioridad) {
        this.dato = dato;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
}
