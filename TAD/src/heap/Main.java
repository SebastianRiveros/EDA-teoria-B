package heap;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();

        // Insertar elementos en el Heap
        heap.insertar(10);
        heap.insertar(30);
        heap.insertar(20);
        heap.insertar(5);
        heap.insertar(15);

        // Imprimir el tamaño del Heap
        System.out.println("Tamaño del Heap: " + heap.tamano()); // Debería imprimir: 5

        // Imprimir y eliminar el máximo del Heap varias veces
        while (!heap.estaVacio()) {
            System.out.println("Máximo del Heap: " + heap.eliminarMaximo());
        }
    }
}
