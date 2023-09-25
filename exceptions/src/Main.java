package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ArrayException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            for(int i=0;i<12;i++) {
                if (arrayList.size() > 10)
                    throw new ArrayException();
                arrayList.add(i);
            }
        }catch (ArrayException e) {
            System.out.println(e.getMessage());
        }
    }
}
