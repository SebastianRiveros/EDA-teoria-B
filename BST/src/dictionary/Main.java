package dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary<Integer, String> dictionary = new BSTDictionary<>();

        dictionary.insert(1, "one");
        dictionary.insert(2, "two");
        dictionary.insert(3, "three");

        System.out.println("Search key 2: " + dictionary.search(2));
        System.out.println("Search key 3: " + dictionary.search(3));

        dictionary.remove(2);
        System.out.println("Key 2 removed");

        // Esta línea lanzará ItemNotFound si la clave no se encuentra
        System.out.println("Search key 2: " + dictionary.search(2));
    }
}