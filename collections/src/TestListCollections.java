import java.util.List;

public class TestListCollections extends TestCollections{
    private final int[] indexes = { 40000,40000,40000,40000,40000,40000,40000 };
    private final int findElement = 99999999;
    private List<Integer> list;

    TestListCollections(List<Integer> list) {
        this.list = list;
        learnOperations();
    }

    @Override
    protected void addElements(){
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

    @Override
    protected void findElement() {
        double startTime = System.nanoTime();
        for(int i=0;i<N;i++)
            if (this.list.get(i) == findElement)
                break;
        this.findElementDuration = calculateDuration(startTime);
    }

    @Override
    protected void removeElements(){
        double startTime = System.nanoTime();
        for(int i : indexes)
            this.list.remove(i);
        this.removeElementsDuration = calculateDuration(startTime);
    }
}
