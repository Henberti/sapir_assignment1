public class Queue<T> {
    private Node<T> first, last;
    private int size = 0;


    public Queue(){
        first = last = null;
    }

    public boolean isEmty(){
        return first==null;
    }

    public void enqueue(T value){
        Node<T> temp = new Node<T>(value);

        if(first == null)
            first = last = temp;
        else{
            last.setNext(temp);
            last = temp;
        }
        size++;
    }

    public T dequeue(){
        if(isEmty())
            return null;

        T value = first.getValue();
        first = first.getNext();
        if(first == null)
            last = null;
        size--;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

        return value;
    }

    public int getSize() {
        return size;
    }


}
