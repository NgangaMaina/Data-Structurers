import java.util.Iterator;

public class StackDll<T> implements Iterable <T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    //Creating an empty stack:
    public StackDll(){}

    //Creating a Stack with an initial element:
    public StackDll(T firstElem){
        push(firstElem);
    }

    //Returning the number of elements in the Stack:
    public int size (){
        return list.size();
    }

    //Checking if the Stack is empty:
    public boolean isEmpty(){
        return size() == 0;
    }

    //Push an element onto the Stack:
    public void push(T elem){
        list.addLast(elem);
    }

    //Pop an element off the stack
    //Throws an error if the STack is empty.
    public T pop(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        }
        return list.removeLast();
    }

    //peek the top of the stack without removing an element
    //Throws an exception if the stack is empty
    public T peek(){
        if (isEmpty()){
            throw new java.util.EmptyStackException();
        }
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public static void main(String[] args) {
        StackDll<Integer> stack = new StackDll<>(10);
        stack.push(20);
        stack.push(50);
        stack.push(75);

        //Printing the STack's size:
        System.out.println("Stack size: " +stack.size());
        System.out.println(" ");
        //Peeking the top element:
        System.out.println("Top element: " +stack.peek());
        System.out.println(" ");
        //Pop elements off the stack and print them:
            while(!stack.isEmpty()){
            System.out.println("Popped: " +stack.pop());
        }
         System.out.println(" ");
        //Check if the stack is empty:
        System.out.println("Is the stack empty? " +stack.isEmpty());
        System.out.println(" ");
        //Attempting to pop from an empty stack:
        try{
            stack.pop();
        }catch(java.util.EmptyStackException e){
            System.out.println("Exception caught: " +e.getMessage());
        }

        //Pushing more elements to illustrate iteration:
        stack.push(90);
        stack.push(60);
        stack.push(85);

        // Iterate through the stack and print each element
        System.out.println("Stack elements (iterated):");
        for (Integer elem : stack) {
            System.out.println(elem);
        }
    }
}
