package lista;

// Clase Nodo que contiene un dato y una referencia al siguiente nodo en la lista
class Nodo<T> {
    T dato; // Dato almacenado en el nodo
    Nodo<T> siguiente; // Referencia al siguiente nodo

    // Constructor que inicializa el dato y establece la referencia siguiente a null
    Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
