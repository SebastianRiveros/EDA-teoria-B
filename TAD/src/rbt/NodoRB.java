package rbt;

// Clase NodoRB que representa un nodo en un Árbol Rojo-Negro
class NodoRB<T extends Comparable<T>> {
    T dato; // Dato almacenado en el nodo
    NodoRB<T> izquierdo; // Referencia al nodo hijo izquierdo
    NodoRB<T> derecho; // Referencia al nodo hijo derecho
    NodoRB<T> padre; // Referencia al nodo padre
    boolean esRojo; // Indicador del color del nodo (true = rojo, false = negro)

    // Constructor que inicializa el nodo con un dato y color específicos
    NodoRB(T dato, boolean esRojo) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
        this.padre = null;
        this.esRojo = esRojo;
    }
}
