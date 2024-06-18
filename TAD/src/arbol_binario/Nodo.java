package arbol_binario;

// Clase Nodo que contiene un dato y referencias a los nodos hijo izquierdo y derecho
class Nodo<T> {
    T dato; // Dato almacenado en el nodo
    Nodo<T> izquierdo; // Referencia al nodo hijo izquierdo
    Nodo<T> derecho; // Referencia al nodo hijo derecho

    // Constructor que inicializa el dato y establece las referencias a null
    Nodo(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}
