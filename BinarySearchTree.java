import static java.awt.geom.Path2D.contains;

public class BinarySearchTree <T extends Comparable <T>> {
    private int nodeCount = 0; //Tracks the number of nodes in this BST.
    private Node root = null; //The BST is a rooted tree, so we maintain a handle on the root node.

    //Internal Node containing node references and the actual node data:
    private class Node{
        T data;
        Node left, right;
        public Node(Node left, Node right, T elem){
            this .data = elem;
            this.left = left;
            this.right = right;
        }
    }
    //Check if the binary tree is empty:
    public boolean isEmpty(){
     return size() == 0;
    }

    //Getting the number of nodes in the tree:
    public int size(){
        return nodeCount;
    }

    //Add an element to the tree and return true if we successfully perform an insertion.
    public boolean add(T elem){
        //Checking if the value already exists in the tree and ignoring it if so:
        if(contains(elem)){
            return false;
            //Otherwise add the element to the tree:
        }else{
            root = add(root, elem);
            nodeCount++;
            return true;
        }

    }

    //A private method to recursively add an element to the tree
    private Node add(Node node, T elem){
        //Base case: Found a leaf Node:
        if(node == null){
            node = new Node(null, null, elem);
        }else{
            if(elem.compareTo(node.data) < 0){
                node.left = add(node.left, elem);
            }else{
                node.right = add(node.right, elem);
            }
        }
        return node;
    }

    //Remove a value from the binary tree if it exists:
    public boolean remove(T elem){
        if(contains(elem)){
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem){
        if(node == null){return null;}
        int cmp = elem.compareTo(node.data);
        if (cmp < 0){
            node.left = remove (node.left, elem);
        }else if(cmp > 0){
            node.right = remove(node.right, elem);

            //This is the case with only a right subtree or none at all
            //In this case just swap the node we wish to remove with its right child.
        }else{
            if(node.left == null){
                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;

                //This is the case with only a left subtree or none at all
                //In this case just swap the node we wish to remove with its left child.
            }else if(node.right == null){
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
                /*When removing a node from a binary tree with two links, the successor can either be
            the largest child from the left or the smallest child from the right. In this case we'll
            look into the smallest child from the right and so go to the furthest left node in the right
            subtree.
             */
            }else{
                Node tmp = digLeft(node.right);
                node.data = tmp.data;
                node.right = remove(node.right, tmp.data);
            }
        }
        return node;
    }

    private Node digLeft(Node node){
        Node cur = node;
        while(cur.left != null){
            cur = cur.left;
            return cur;
        }
        return cur;
    }

    private boolean contains(T elem){
        return contains(root, elem);
    }
    private boolean contains(Node node, T elem){
        if (node == null) return false;
        int cmp = elem.compareTo(node.data);
        if (cmp < 0) return contains (node.left, elem);
        else if(cmp > 0) return contains(node.right, elem);
        else return true;
    }

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
