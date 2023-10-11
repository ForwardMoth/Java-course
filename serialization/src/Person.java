package src;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private transient String occupation;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String setOccupation() {
        if (this.age >= 0 & this.age < 3) {
            return "сидит дома";
        } else if (this.age >= 3 & this.age < 7) {
            return "ходит в детский сад";
        } else if (this.age >= 7 & this.age < 18) {
            return "учится в школе";
        } else if (this.age >= 18 & this.age <= 23) {
            return "учится в институте";
        } else if (this.age > 24 & this.age < 65) {
            return "работает";
        } else {
            return "на пенсии";
        }
    }

    @Override
    public String toString() {
        return "{name: " + this.name + ", age: " + this.age + ", occupation: " + this.occupation + "}";
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.occupation = setOccupation();
    }
}

