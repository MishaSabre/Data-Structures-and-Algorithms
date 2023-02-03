import org.w3c.dom.Node;

import java.util.*;

public class TreeX {

    static class NodeX {
        int value;

        NodeX left,right;

        NodeX( int value, NodeX left, NodeX right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }
    }

    public NodeX head = null;
    Random rnd = new Random();


    TreeX( int value){
        this.head = new NodeX(value, null,null);
    }


    private NodeX addRecursive(NodeX current, int value) {
        if (current == null) {
            return new NodeX(value, null,null);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }
    public void add(int value) {
        head = addRecursive(head, value);
    }

    public void delete(int value) {
        head = deleteRecursive(head, value);
    }

    private NodeX deleteRecursive(NodeX current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(NodeX root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }


    private boolean containsNodeRecursive(NodeX current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(head, value);
    }

    public NodeX getHead() {
        return head;
    }

    //последовательный
    public void traverseInOrder(NodeX node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print("(" + node.value + ") ");
            traverseInOrder(node.right);
        }
    }

    //нисходящий
    public void traversePreOrder(NodeX node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    //восходящий
    public void traversePostOrder(NodeX node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }


    static int counter = 0;

    public void createIdeal(int input, NodeX atd){

        counter = input;


        if (counter > 1 ) counter = counter - 2;

        if(counter >= 2) {
            atd.left = new NodeX(rnd.nextInt(100), null, null);
            atd.right = new NodeX(rnd.nextInt(100), null, null);
            createIdeal(counter, atd.right);
            createIdeal(counter, atd.left);

        }
        else if (counter == 1){
            atd.left = new NodeX(rnd.nextInt(100), null, null);
            counter--;

        }



    }

    public void doIdeal(int input){

        head = new NodeX(rnd.nextInt(100), null, null);
        createIdeal(input + 1,head);
        traverseInOrder(head);
        counter = 0;
    }

    public NodeX createUnBorn(NodeX current, int input){
        if (current == null) {
            return new NodeX(input, null,null);
        }

        current.right = addRecursive(current.right, input);
        return current;
    }

    public void doUnBorn(int[] ints){
        head = null;
        for (int i : ints) head = addRecursive(head, i);

    }

    public boolean isEmpty(){
        return head == null;
    }
}
