import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test working of ArrayList...");
        TestListCollections testArrayList = new TestListCollections(new ArrayList<>());
        testArrayList.timeWorkCollection();
        System.out.println("Test working of LinkedList...");
        TestListCollections testLinkedList = new TestListCollections(new LinkedList<>());
        testLinkedList.timeWorkCollection();
        System.out.println("Test working of TreeSet");
        TestSetCollections testTreeSet = new TestSetCollections(new TreeSet<>());
        testTreeSet.timeWorkCollection();
        System.out.println("Test working of HashSet");
        TestSetCollections testHashSet = new TestSetCollections(new HashSet<>());
        testHashSet.timeWorkCollection();
    }
}
