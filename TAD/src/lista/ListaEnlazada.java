package lista;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

// Implementación de una lista enlazada genérica
public class ListaEnlazada<T> {
    private Nodo<T> cabeza; // Primer nodo de la lista
    private int tamaño; // Tamaño de la lista

    // Constructor que inicializa una lista vacía
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Método para obtener el tamaño de la lista
    public int obtenerTamaño() {
        return tamaño;
    }

    // Método para agregar un elemento al inicio de la lista
    public void agregarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato); // Crear un nuevo nodo con el dato proporcionado
        nuevoNodo.siguiente = cabeza; // Enlazar el nuevo nodo con el antiguo primer nodo
        cabeza = nuevoNodo; // Actualizar la cabeza para que apunte al nuevo nodo
        tamaño++; // Incrementar el tamaño de la lista
    }

    // Método para agregar un elemento al final de la lista
    public void agregarFinal(T dato) {
        if (estaVacia()) {
            // Si la lista está vacía, agregar el elemento al inicio
            agregarInicio(dato);
            return;
        }
        Nodo<T> actual = cabeza;
        // Recorrer la lista hasta encontrar el último nodo
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = new Nodo<>(dato); // Enlazar el último nodo con el nuevo nodo
        tamaño++; // Incrementar el tamaño de la lista
    }

    // Método para eliminar un elemento de la lista
    public void eliminar(T dato) {
        if (estaVacia()) {
            // Lanzar una excepción si la lista está vacía
            throw new ItemNotFound("El elemento no se encuentra en la lista.");
        }

        if (cabeza.dato.equals(dato)) {
            // Si el elemento a eliminar está en el primer nodo
            cabeza = cabeza.siguiente; // Actualizar la cabeza para que apunte al siguiente nodo
            tamaño--; // Disminuir el tamaño de la lista
            return;
        }

        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;
        // Recorrer la lista para encontrar el nodo a eliminar
        while (actual != null && !actual.dato.equals(dato)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            // Lanzar una excepción si el elemento no se encuentra en la lista
            throw new ItemNotFound("El elemento no se encuentra en la lista.");
        }

        anterior.siguiente = actual.siguiente; // Enlazar el nodo anterior con el siguiente nodo
        tamaño--; // Disminuir el tamaño de la lista
    }

    // Método para buscar un elemento en la lista
    public boolean buscar(T dato) {
        Nodo<T> actual = cabeza;
        // Recorrer la lista para buscar el dato
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true; // Retornar true si se encuentra el dato
            }
            actual = actual.siguiente;
        }
        return false; // Retornar false si no se encuentra el dato
    }

    // Método para obtener el elemento en una posición específica
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            // Lanzar una excepción si el índice está fuera de los límites de la lista
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la lista.");
        }

        Nodo<T> actual = cabeza;
        int contador = 0;
        // Recorrer la lista hasta alcanzar el índice deseado
        while (contador < indice) {
            actual = actual.siguiente;
            contador++;
        }
        return actual.dato; // Retornar el dato en el índice especificado
    }

    // Método para imprimir la lista
    public void imprimir() {
        Nodo<T> actual = cabeza;
        // Recorrer la lista y imprimir cada dato
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null"); // Indicar el final de la lista
    }
}
