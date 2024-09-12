import java.util.EmptyStackException;
public class Stacks {
    private static class Node{
        private int data;
        private Stacks.Node next;


    private Node(int data) {
        this.data=data;
        this.next=null;

      }

    }
    private static Node top;

    // Method 1: A method to check if the stack is empty:
    public boolean isEmpty(){
        if(top==null){
            System.out.println("Nothing is inn the Stack.");
            return true;
        }
        else{
            return false;
        }
    }
// Method 2: Peaking to  see the current node at the top of the Stack:
    public int peek(){
        if (top==null){
            throw new EmptyStackException();
        }
        else{
            return top.data;
        }
    }

    // Method 3: Adding a node at the top of  the stack:
    public void push(int data){
        Node newNode=new Node(data);
        newNode.next=top;
        top=newNode;
    }

    //Method 4: Delete and return the deleted value:
    public int pop(){
        if (top==null){
            throw new EmptyStackException();
        }
        int data =top.data;
        top=top.next;
        return data;

    }
    public Node clear(){
        return top=null;
    }

    public static void main(String[] args) {
        Stacks plates = new Stacks();
        plates.push(90);
        plates.push(85);
        plates.push(60);
        plates.push(55);
        plates.push(70);

        System.out.println("The top element of this stack is " +plates.peek());
        System.out.println("The deleted value is " +plates.pop());
        System.out.println("Clearing the stack now! " + plates.clear());


    }

}




