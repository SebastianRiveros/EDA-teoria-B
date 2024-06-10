public class Main {
    public static void main(String[] args) {
        // Crear una lista enlazada de enteros
        LinkedList<Integer> list = new LinkedList<>();

        // Insertar elementos al principio de la lista
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);

        // Imprimir la lista
        System.out.println("Lista después de la inserción al principio: " + list);

        // Insertar elementos en posiciones específicas
        list.insertAtPosition(4, 3); // Insertar 4 en la posición 3 (índice 0-based)
        list.insertAtPosition(5, 1); // Insertar 5 en la posición 1 (índice 0-based)

        // Imprimir la lista
        System.out.println("Lista después de la inserción en posiciones específicas: " + list);

        // Verificar si la lista contiene ciertos elementos
        System.out.println("¿La lista contiene el elemento 3? " + list.contains(3));
        System.out.println("¿La lista contiene el elemento 6? " + list.contains(6));

        // Buscar un elemento en la lista
        System.out.println("La posición del elemento 3 en la lista es: " + list.search(3));
        System.out.println("La posición del elemento 6 en la lista es: " + list.search(6));

        // Eliminar elementos de la lista
        list.remove(2);
        list.remove(4);

        // Imprimir la lista después de eliminar elementos
        System.out.println("Lista después de eliminar elementos: " + list.toString());

        // Verificar el tamaño de la lista
        System.out.println("Tamaño de la lista: " + list.size());
    }
}
