import java.util.Set;

public class TestSetCollections extends TestCollections{
    private final int[] elements = {16436, 123, 211, 23123, 21, 1, 100000, 700000, 50000, 1232};
    private Set<Integer> set;
    TestSetCollections(Set<Integer> set){
        this.set = set;
        learnOperations();
    }

    @Override
    protected void addElements(){
        double startTime = System.nanoTime();
        for(int i=0;i<N;i++)
            this.set.add(i);
        this.addElementsDuration = calculateDuration(startTime);
    }

    @Override
    protected void findElement() {
        double startTime = System.nanoTime();
        for (int i : elements)
            this.set.contains(i);
        this.findElementDuration = calculateDuration(startTime);
    }

    @Override
    protected void removeElements(){
        double startTime = System.nanoTime();
        for (int i : elements)
            this.set.remove(i);
        this.removeElementsDuration = calculateDuration(startTime);
    }
}
