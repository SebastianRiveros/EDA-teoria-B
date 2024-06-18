package splay_tree;

// Clase NodoSplay que representa un nodo en un Árbol Splay
class NodoSplay<T extends Comparable<T>> {
    T dato; // Dato almacenado en el nodo
    NodoSplay<T> izquierdo; // Referencia al nodo hijo izquierdo
    NodoSplay<T> derecho; // Referencia al nodo hijo derecho

    // Constructor que inicializa el nodo con un dato específico
    NodoSplay(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}
