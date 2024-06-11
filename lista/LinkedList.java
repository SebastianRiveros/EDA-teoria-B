public class LinkedList<T> {
    private Node<T> head;
    private int size;
//dfsd
    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insertAtBeginning(T data){
        Node<T> aux = new Node<>(data);
        aux.setNext(this.head);
        this.head = aux;
        this.size++;
    }

    public void insertAtPosition(T data, int k){
        if (k < 0 || k > size){
            throw new IndexOutOfBoundsException("fuera de limite");
        }
        if(k == 0){
            insertAtBeginning(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> aux = head;
            for(int i = 0; i < k-1; i++){
                aux = aux.getNext();
            }
            newNode.setNext(aux.getNext());
            aux.setNext(newNode);
            size++;
        }
    }

    public int search(T data){
        Node<T> aux = head;
        for(int i = 0; aux != null; i++){
            if(aux.getData().equals(data)){
                return i;
            }
            aux = aux.getNext();
        }
        return -1;
    }

    public int size(){
        return this.size;
    }

    public boolean contains(T data){
        if (isEmpty()) 
            return false;
        else{
            Node<T> aux = head;
            while(aux != null){
                if(aux.getData().equals(data))
                    return true;
                aux = aux.getNext();
            }
        }
        return false;
    }

    public void remove(T data){
        if(isEmpty()){
            return;
        }
        if(head.getData().equals(data)){
            head = head.getNext();
            size--;
            return;
        }
        else{
            Node<T> aux = head;
            while(aux.getNext() != null){
                if(aux.getNext().getData().equals(data)){
                    aux.setNext(aux.getNext().getNext());
                    size--;
                    return;
                }
                aux = aux.getNext();
            }
        }
    }

    @Override
    public String toString(){
        String lista = "";
        Node<T> aux = head;
        while(aux != null){
            lista += aux.getData() + " ";
            aux = aux.getNext();
        }
        return lista;
    }
}