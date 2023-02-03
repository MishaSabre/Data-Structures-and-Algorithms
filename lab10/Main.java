import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        TreeX tree = new TreeX(11);

        /*
        tree.add(41);
        tree.add(66);
        tree.add(85);
        tree.add(98);
        tree.add(28);
        tree.add(61);
        tree.add(25);
        tree.add(12);
        tree.add(77);
        tree.add(31);
        tree.delete(31);

        tree.traverseInOrder(tree.head);

        System.out.println(tree.containsNode(77));

        int[] temp = {16, 23, 54, 18, 46, 74, 58};

        tree.doUnBorn(temp);
        tree.traverseInOrder(tree.head);
        */
        int[] abc = {8,4,11,2,6,9,10};
        AvlTree<Integer> tree1 = new AvlTree<>();

        for(int i = 0; i < abc.length; i++){
            tree1.insert(abc[i]);
        }

        tree1.inOrder();
        System.out.println();
        tree1.postOrder();
        System.out.println();
        tree1.preOrder();

        System.out.println();
        


    }
}