import java.util.Random;

public abstract class TestCollections {
    protected final int N = 800000;
    protected static Random rand = new Random();
    protected double addElementsDuration;
    protected double findElementDuration;
    protected double removeElementsDuration;

    public void timeWorkCollection() {
        System.out.println("Operations of insert: " + format(addElementsDuration));
        System.out.println("Operations of finding: " + format(findElementDuration));
        System.out.println("Operations of remove: " + format(removeElementsDuration));
    }

    protected void learnOperations(){
        addElements();
        findElement();
        removeElements();
    }

    protected double calculateDuration(double startTime) {
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    protected void addElements(){}
    protected void findElement(){}
    protected void removeElements(){}

    private String format(double value){
        return String.format("%.2fms",value);
    }
}
