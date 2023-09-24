import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test working of ArrayList...");
        TestListCollections testArrayList = new TestListCollections(new ArrayList<>());
        testArrayList.timeWorkCollection();
        System.out.println("Test working of LinkedList...");
        TestListCollections testLinkedList = new TestListCollections(new LinkedList<>());
        testLinkedList.timeWorkCollection();
    }
}
