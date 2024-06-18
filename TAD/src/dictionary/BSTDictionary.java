package dictionary;
import exceptions.ItemNotFound;
import bst.BST;

public class BSTDictionary<K extends Comparable<K>, V> implements Dictionary<K, V> {
    private BST<EntryDic<K, V>> dict;

    public BSTDictionary(){
        dict = new BST<>();
    }

    @Override
    public void insert(K key, V value){
        dict.insert(new EntryDic<>(key, value));
    }

    @Override
    public void remove(K key) throws ItemNotFound {
        dict.remove(new EntryDic<>(key));
    }

    @Override
    public V search(K key) throws ItemNotFound {
        return dict.search(new EntryDic<>(key)).getValue();
    }

    @Override
    public boolean isEmpty(){
        return dict.isEmpty();
    }
}