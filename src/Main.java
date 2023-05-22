import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer, String> mbt = new MyBinaryTree();
        Random rand = new Random();
        mbt.insert(1, "Maria");
        mbt.insert(11, "Mari");
        mbt.insert(5, "Marina");
        mbt.insert(10, "Don-Karlen");
        mbt.insert(13, "Don");
        System.out.println();
        for (var entry : mbt) {
            System.out.println("Key is " + entry.getKey() + " and value is " + entry.getValue());
        }

        System.out.println("\nDeleted element is "+mbt.remove(10));
        System.out.println();
        for (var entry : mbt) {
            System.out.println("Key is " + entry.getKey() + " and value is " + entry.getValue());
        }
        System.out.println("\nSize is " + mbt.getSize());
        System.out.println("\nValue of key 13 is "+ mbt.get(13));

    }

}
