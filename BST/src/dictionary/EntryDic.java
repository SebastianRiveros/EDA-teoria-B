package dictionary;

public class EntryDic<K extends Comparable<K>, V> implements Comparable<EntryDic<K, V>> {
    private K key;
    private V value;

    public EntryDic(K key, V value){
        this.key = key;
        this.value = value;
    }

    public EntryDic(K key){
        this(key, null);
    }

    public boolean equals(Object x){
        return ((EntryDic<K, V>) x).key.equals(this.key);
    }

    public int compareTo(EntryDic<K, V> x){
        return this.key.compareTo(x.getKey());
    }

    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }
}