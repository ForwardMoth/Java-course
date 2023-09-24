import java.util.List;
import java.util.Random;

public class TestListCollections {
    private final int[] indexes = {40000,40000,40000,40000,40000,40000,40000 };
    private final int findElement = 99999999;
    private final int N = 80000;
    private double addElementsDuration;
    private double findElementDuration;
    private double removeElementsDuration;
    private static Random rand = new Random();
    private List<Integer> list;

    TestListCollections(List<Integer> list) {
        this.list = list;
        learnOperations();
    }

    protected void learnOperations(){
        addElements();
        findElement();
        removeElements();
    }

    private void addElements(){
        double startTime = System.nanoTime();
        int specialInsert = 15000;
        for(int i=0;i<N;i++) {
            if (i == specialInsert)
                list.add(findElement);
            else
                list.add(rand.nextInt(N));
        }
        this.addElementsDuration = calculateDuration(startTime);
    }

    private void findElement() {
        double startTime = System.nanoTime();
        for(int i=0;i<N;i++)
            if (this.list.get(i) == findElement)
                break;
        this.findElementDuration = calculateDuration(startTime);
    }

    private void removeElements(){
        double startTime = System.nanoTime();
        for(int i : indexes)
            this.list.remove(i);
        this.removeElementsDuration = calculateDuration(startTime);
    }

    private double calculateDuration(double startTime) {
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    private String format(double value){
        return String.format("%.2fms",value);
    }

    public void timeWorkCollection() {
        System.out.println("Operations of insert: " + format(addElementsDuration));
        System.out.println("Operations of finding: " + format(findElementDuration));
        System.out.println("Operations of remove: " + format(removeElementsDuration));
    }
}
