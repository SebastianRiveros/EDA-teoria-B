package lista;
public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        // Agregar elementos al inicio y al final de la lista
        lista.agregarInicio(1);
        lista.agregarFinal(2);
        lista.agregarFinal(3);
        
        // Imprimir la lista
        lista.imprimir(); // 1 -> 2 -> 3 -> null
        
        // Obtener y mostrar el tamaño de la lista
        System.out.println("Tamaño: " + lista.obtenerTamaño()); // Tamaño: 3

        // Buscar elementos en la lista
        System.out.println("Buscar 2: " + lista.buscar(2)); // Buscar 2: true
        System.out.println("Buscar 4: " + lista.buscar(4)); // Buscar 4: false

        // Eliminar un elemento de la lista
        lista.eliminar(2);
        lista.imprimir(); // 1 -> 3 -> null

        // Intentar eliminar un elemento que no existe (lanzará una excepción)
        lista.eliminar(4); // ItemNotFound: El elemento no se encuentra en la lista.

        // Intentar obtener un elemento en un índice fuera de los límites (lanzará una excepción)
        lista.obtener(3); // IndexOutOfBoundsException: Índice fuera de los límites de la lista.
    }
}
