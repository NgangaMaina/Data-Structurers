public class Node {
    Node left, right; //Reference to  the left and right children of the current node.
    int data; //Value stored in the node.

    public Node(int data) {
        this.data = data; //Initializing the node with a given data.
    }

    //Adding a node to the tree:
    public void add(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.add(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.add(value);
            }
        }
    }

    //Finding an element in the tree:
    public boolean search(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.search(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.search(value);
            }
        }
    }

    public void in_order_print() {
        if (left != null) {
            left.in_order_print(); //calling the in_order_print method on the left child after checking if it exists.
        }
        System.out.println(data);// Printing data of the current node.
        if (right != null) {
            right.in_order_print();// calling the in_order_print method on the right child after checking if it exists.
        }
    }

    public void post_order() {

        if (left != null) {
            left.post_order();
        }
        if (right != null) {
            right.post_order();
        }
        System.out.println(data);
    }

    public int findMin() {
        if (left == null) {
            return data; // This is the minimum value if the left node does not exist
        } else {
            return left.findMin();
        }
    }

    public int height() {
        return height(this);
    }

    //Helper method for height calculation:
    private int height(Node node){
        if (node == null){ //Empty subtree
            return -1;
        }
        int lefth = height(node.left); //Calculating height of the left subtree.
        int righth = height(node.right); //Calculating the height of the right subtree.

        //Comparing the heights of the left nd right subtrees.
        if (lefth > righth){
            return lefth + 1;
        }else{
            return righth + 1;
        }

    }

    public static void main(String[] args) {
        Node our_tree = new Node (10);

        our_tree.add(8);
        our_tree.add(4);
        our_tree.add(2);
        our_tree.add(6);
        our_tree.add(10);
        our_tree.add(9);
        our_tree.add(12);

        System.out.println("In Order");
        our_tree.in_order_print();

        System.out.println("Post Order");
        our_tree.post_order();

        System.out.println("Minimum Value: " + our_tree.findMin());

        System.out.println("Tree Height: " + our_tree.height());
    }

}

