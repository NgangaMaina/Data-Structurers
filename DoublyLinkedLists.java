import java.util.Iterator;

public class DoublyLinkedLists<T> implements Iterable <T> {
    private int size = 0; //size of the linked list
    private Node <T> head = null;
    private Node <T> tail = null;
    //Internal node class to represent data:
    private class Node <T>{
        T data;
        Node <T> prev, next;
        public Node(T data, Node<T> prev, Node <T> next){
            this.data = data;
            this.prev =prev;
            this.next = next;
        }

        public String toString(){
            return data.toString();
        }
    }

    //Empty the linked list in O(n):
    public void clear(){
        Node <T> trav = head;
        while(trav != null){
            Node <T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav =null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void add(T elem){
        addLast(elem);
    }

    public void addFirst(T elem){
        if (isEmpty()){
            head = tail = new Node <T> (elem, null, null);
        }
        else{
            head.prev = new Node<T> (elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(T elem){
        if (isEmpty()){
            head = tail = new Node <T> (elem, null, null);
        }
        else{
            tail.next = new Node<T> (elem, null, head);
            tail = tail.next;
        }
        size++;
    }
    public T peekFirst(){
        if(isEmpty()) throw  new RuntimeException("Empty list");
        return head.data;
    }
    public T peekLast(){
        if(isEmpty()) throw  new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst(){
        //Can't remove from an empty list.
           if(isEmpty()) throw new RuntimeException("Empty List");

           //Extract the data at the head and move
           //The head pointer forwards one node
        T data = head.data;
        head = head.next;
        --size;
        //If the list is empty, set the tail to null as well
        if (isEmpty()) tail = null;
        //Do memory clean of the previous node
          else head.prev = null;

        //Return the data that was at the first node that we just removed
        return data;
    }

    public T removeLast(){
        //Can't remove from an empty list.
        if(isEmpty()) throw new RuntimeException("Empty List");

        //Extract the data at the tail and move
        //The tail pointer backwards one node
        T data = tail.data;
        tail = tail.prev;
        --size;
        //If the list is empty, set the head to null as well
        if (isEmpty()) head = null;
            //Do memory clean of the previous node
        else tail.next = null;

        //Return the data that was at the first node that we just removed
        return data;
    }

    //Removing an arbitrary node from the linked list O(1)
    private T remove(Node <T> node){
        //If the node to remove is somewhere eitgher at the head or the tail handle those independently
        if(node.prev == null) return  removeFirst();
        if(node.next == null) return  removeLast();

        //Make the pointers of the adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next =node.next;

        //Temporarily store the number we want to  return
        T data = node.data;

        //memory cleanup
        node.data = null;
        node = node.prev = node.next = null;
        --size;
        return data;
    }

    //Removing a node at a particular index:
    public T removeAt(int index) {
        //Make sure the index provided is valid
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        int i;
        Node<T> trav;

        //Search from the front of the list
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++)
                trav = trav.next;
            //Search from the back of the list
        }else
            for(i = size-1, trav = tail; i != index; i--)
                trav = trav.prev;
            return remove(trav);
    }

    //Removing a particular value int he list
    public boolean remove(Object obj){
        Node <T> trav = head;
        //support searching for null
        if(obj == null){
            for(trav = head; trav != null; trav = trav.next){
                if (trav.data == null){
                    remove(trav);
                    return true;
                }
            }
            //Search for non-null object
        } else{
            for(trav = head; trav != null; trav = trav.next){
                if(obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    //Finding the index of a particular value in the linked list O(n)
    public int indexOf(Object obj){
        int index = 0;
        Node <T> trav = head;
        //support searching for null
        if (obj == null){
            for(trav = head; trav != null; trav = trav.next, index++)
                if(trav.data == null)
                    return index;
            //Search for non-null  object
        }else
            for (trav = head; trav != null; trav = trav.next, index++)
                if(obj.equals(trav.data))
                    return index;
            return -1;
    }

    //Check if a value is contained in the linked list
       public boolean contains(Object obj){
        return indexOf(obj) != -1;
       }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>(){
            private Node <T> trav = head;
            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }
    @Override public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node <T> trav = head;
        while (trav != null){
            sb.append (trav.data + ",");
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();

    }
        public static void main(String[] args) {
            DoublyLinkedLists<Integer> list = new DoublyLinkedLists<>();

           /* // Add elements to the list
            list.add(10);
            list.add(20);
            list.add(30);
            System.out.println("After adding elements: " + list);*/

          // Add element to the beginning
            list.addFirst(5);
            System.out.println("After adding 5 to the beginning: " + list);

            /*// Add element to the end
            list.addLast(40);
            System.out.println("After adding 40 to the end: " + list);*/

              /* // Remove the first element
            list.removeFirst();
            System.out.println("After removing the first element: " + list);

            // Remove the last element
            list.removeLast();
            System.out.println("After removing the last element: " + list);

            // Remove element at index 1
            list.removeAt(1);
            System.out.println("After removing element at index 1: " + list);

           // Check if the list contains a value
            System.out.println("List contains 20: " + list.contains(20));
            System.out.println("List contains 10: " + list.contains(10));

            // Iterate over the list
            System.out.print("Iterating over the list: ");
            for (int elem : list) {
                System.out.print(elem + " ");
            }
            System.out.println();

            // Clear the list
            list.clear();
            System.out.println("After clearing the list: " + list);*/
        }
    }


