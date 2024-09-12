import java.util.Iterator;

public class Queues <T> implements Iterable<T> {
    private java.util.LinkedList <T> list = new java.util.LinkedList <T> ();
    public Queues(){}

    public Queues(T firstElem){
        offer(firstElem);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException();
        }
        return list.peekFirst();
    }

    public T poll(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        return list.removeFirst();
    }

    public void offer(T elem){
        list.addLast(elem);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
    //Add main method for implementation:
}
