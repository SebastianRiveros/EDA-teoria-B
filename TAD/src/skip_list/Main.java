package skip_list;

public class Main {
    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();

        // Insertar elementos en la Skip List
        skipList.insertar(10);
        skipList.insertar(20);
        skipList.insertar(15);
        skipList.insertar(30);

        // Buscar elementos en la Skip List
        System.out.println("Buscar 15: " + skipList.buscar(15)); // Debería imprimir: true
        System.out.println("Buscar 25: " + skipList.buscar(25)); // Debería imprimir: false

        // Eliminar un elemento de la Skip List
        skipList.eliminar(20);

        // Verificar nuevamente la búsqueda después de la eliminación
        System.out.println("Buscar 20 después de eliminar: " + skipList.buscar(20)); // Debería imprimir: false
    }
}
