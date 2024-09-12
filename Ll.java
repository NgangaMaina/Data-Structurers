public class Ll {

    //LL starting point:
    Node head;

    //Create a constructor:
    class Node {
        Node next;int data;
        public Node (int userdata){this.data= userdata;}

    }

    //Add items:
     //1.) Adding at the start:
    /*
     * Create new node.
     * Store data iin the new node.
     * Add the new node to the LL.
     * Assign 'head' title to the new node.
     * Make sure the new node pointer, points to the previous 'head'.
     * */

    public  void insertStart(int userdata){
        Node newHead= new Node(userdata);
        newHead.next= head;
        head = newHead;

    }

    //Printing all items:
    public void print() {
        Node current= head; //Tells OS where to start.
        System.out.println("  ");

        //Loop through the LL and print data at the current Node and then move to the next Node.
        while (current !=null){
            System.out.println(current.data + " ");
            current= current.next;
        }



    }

    public static void main(String[] args) {
        Ll scores= new Ll();
        scores.insertStart(60);
        scores.insertStart(75);
        scores.insertStart(68);
        scores.insertStart(90);
        scores.insertStart(80);
        scores.print();
        scores.insertStart(40);
        scores.print();
    }

}
