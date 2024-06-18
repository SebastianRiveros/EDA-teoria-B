package heap;

import java.util.ArrayList;
import java.util.List;

// Implementación de un Heap (Max-Heap) genérico
public class Heap<T extends Comparable<T>> {
    private List<T> elementos; // Lista para almacenar los elementos del Heap

    // Constructor que inicializa un Heap vacío
    public Heap() {
        this.elementos = new ArrayList<>();
    }

    // Método para obtener el tamaño del Heap
    public int tamano() {
        return elementos.size();
    }

    // Método para verificar si el Heap está vacío
    public boolean estaVacio() {
        return elementos.isEmpty();
    }

    // Método para insertar un elemento en el Heap
    public void insertar(T elemento) {
        elementos.add(elemento); // Agregar el elemento al final del Heap
        flotar(elementos.size() - 1); // Restaurar la propiedad del Heap (flotar)
    }

    // Método para eliminar y devolver el elemento máximo del Heap (raíz)
    public T eliminarMaximo() {
        if (estaVacio()) {
            throw new IllegalStateException("El Heap está vacío, no se puede eliminar.");
        }

        T maximo = elementos.get(0); // El máximo es la raíz del Heap
        T ultimo = elementos.remove(elementos.size() - 1); // Último elemento del Heap
        if (!elementos.isEmpty()) {
            elementos.set(0, ultimo); // Mover el último elemento a la raíz
            hundir(0); // Restaurar la propiedad del Heap (hundir)
        }
        return maximo;
    }

    // Método para obtener el elemento máximo del Heap (raíz) sin eliminarlo
    public T obtenerMaximo() {
        if (estaVacio()) {
            throw new IllegalStateException("El Heap está vacío, no se puede obtener el máximo.");
        }
        return elementos.get(0);
    }

    // Método para flotar un elemento hacia arriba para restaurar la propiedad del Heap
    private void flotar(int indice) {
        T valor = elementos.get(indice); // Valor a flotar

        while (indice > 0) {
            int indicePadre = (indice - 1) / 2; // Índice del padre en el Heap

            T padre = elementos.get(indicePadre);
            if (valor.compareTo(padre) <= 0) {
                break; // Si el valor es menor o igual que el padre, detenerse
            }

            elementos.set(indice, padre); // Mover el padre hacia abajo
            indice = indicePadre; // Mover al índice del padre
        }

        elementos.set(indice, valor); // Colocar el valor en su posición correcta
    }

    // Método para hundir un elemento hacia abajo para restaurar la propiedad del Heap
    private void hundir(int indice) {
        T valor = elementos.get(indice); // Valor a hundir
        int tamaño = elementos.size();

        while (indice < tamaño / 2) {
            int hijoIzquierdoIndice = 2 * indice + 1; // Índice del hijo izquierdo
            int hijoDerechoIndice = 2 * indice + 2; // Índice del hijo derecho (si existe)

            int hijoMayorIndice = hijoIzquierdoIndice;
            if (hijoDerechoIndice < tamaño && elementos.get(hijoDerechoIndice).compareTo(elementos.get(hijoIzquierdoIndice)) > 0) {
                hijoMayorIndice = hijoDerechoIndice; // Si el hijo derecho es mayor, seleccionarlo
            }

            if (valor.compareTo(elementos.get(hijoMayorIndice)) >= 0) {
                break; // Si el valor es mayor o igual que el hijo mayor, detenerse
            }

            elementos.set(indice, elementos.get(hijoMayorIndice)); // Mover el hijo mayor hacia arriba
            indice = hijoMayorIndice; // Mover al índice del hijo mayor
        }

        elementos.set(indice, valor); // Colocar el valor en su posición correcta
    }
}
