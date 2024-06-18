package dictionary;
import exceptions.ItemNotFound;

public interface Dictionary<K, V> {
    void insert(K key, V val);
    void remove(K key) throws ItemNotFound;
    V search(K key) throws ItemNotFound;
    boolean isEmpty();
}