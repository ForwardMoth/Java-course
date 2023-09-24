import java.util.HashMap;

public class LearningHashMap {
    private final static int N = 10;

    public static void main(String args[]) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0;i<N;i++)
            hashMap.put(Integer.toString(i+10),i);

        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet())
            System.out.println(entry.getKey() + "/" + entry.getValue());

        HashMap<Integer,String> hashMap1 = new HashMap<>();

        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet())
            hashMap1.put(entry.getValue(), entry.getKey());

        for (HashMap.Entry<Integer, String> entry : hashMap1.entrySet())
            System.out.println(entry.getKey() + "/" + entry.getValue());
    }
}
