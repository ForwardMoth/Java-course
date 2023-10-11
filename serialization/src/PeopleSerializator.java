package src;

import java.io.*;
import java.util.List;

public class PeopleSerializator {
    private final static String fileName = "people.bin";

    public void serialize(List<Person> people) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(people);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> deserialize() {
        List<Person> people;
        try {
            FileInputStream fis  = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            people = (List<Person>) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return people;
    }
}
