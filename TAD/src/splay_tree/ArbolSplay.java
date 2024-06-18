package splay_tree;

import exceptions.ItemNotFound;

// Implementación de un Árbol Splay genérico
public class ArbolSplay<T extends Comparable<T>> {
    private NodoSplay<T> raiz; // Nodo raíz del árbol

    // Constructor que inicializa un árbol vacío
    public ArbolSplay() {
        this.raiz = null;
    }

    // Método para verificar si el árbol está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // Método para insertar un elemento en el árbol
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato); // Insertar de manera recursiva
    }

    // Método recursivo para insertar un elemento en el árbol
    private NodoSplay<T> insertarRecursivo(NodoSplay<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoSplay<>(dato); // Caso base: Insertar en una hoja
        }

        int comparacion = dato.compareTo(nodo.dato);
        if (comparacion < 0) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato); // Insertar en el subárbol izquierdo
        } else if (comparacion > 0) {
            nodo.derecho = insertarRecursivo(nodo.derecho, dato); // Insertar en el subárbol derecho
        }

        return nodo; // Retornar el nodo actualizado
    }

    // Método para buscar un elemento en el árbol y realizar la operación de Splay
    public boolean buscar(T dato) {
        if (raiz == null) {
            throw new ItemNotFound("El árbol está vacío.");
        }

        raiz = buscarRecursivo(raiz, dato); // Buscar de manera recursiva
        return raiz != null && raiz.dato.compareTo(dato) == 0; // Verificar si se encontró el elemento
    }

    // Método recursivo para buscar un elemento en el árbol y realizar la operación de Splay
    private NodoSplay<T> buscarRecursivo(NodoSplay<T> nodo, T dato) {
        if (nodo == null || nodo.dato.compareTo(dato) == 0) {
            return nodo; // Casos base: Nodo nulo o dato encontrado
        }

        int comparacion = dato.compareTo(nodo.dato);
        if (comparacion < 0) {
            // Buscar en el subárbol izquierdo
            if (nodo.izquierdo == null) {
                return nodo; // El dato no está presente, retornar el último nodo visitado
            }
            nodo.izquierdo = buscarRecursivo(nodo.izquierdo, dato);
            return rotarDerecha(nodo); // Realizar la rotación a la derecha después de la búsqueda
        } else {
            // Buscar en el subárbol derecho
            if (nodo.derecho == null) {
                return nodo; // El dato no está presente, retornar el último nodo visitado
            }
            nodo.derecho = buscarRecursivo(nodo.derecho, dato);
            return rotarIzquierda(nodo); // Realizar la rotación a la izquierda después de la búsqueda
        }
    }

    // Método para realizar una rotación a la izquierda
    private NodoSplay<T> rotarIzquierda(NodoSplay<T> nodo) {
        NodoSplay<T> hijoDerecho = nodo.derecho;
        nodo.derecho = hijoDerecho.izquierdo;
        hijoDerecho.izquierdo = nodo;
        return hijoDerecho;
    }

    // Método para realizar una rotación a la derecha
    private NodoSplay<T> rotarDerecha(NodoSplay<T> nodo) {
        NodoSplay<T> hijoIzquierdo = nodo.izquierdo;
        nodo.izquierdo = hijoIzquierdo.derecho;
        hijoIzquierdo.derecho = nodo;
        return hijoIzquierdo;
    }
}
