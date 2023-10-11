package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Дмитрий", 5));
        people.add(new Person("Алексей", 29));
        people.add(new Person("Олег", 2));
        people.add(new Person("Евгений", 16));
        people.add(new Person("Александр", 68));

        PeopleSerializator peopleSerializator = new PeopleSerializator();
        peopleSerializator.serialize(people);
        List<Person> deserializedPeople = peopleSerializator.deserialize();
        for (Person person : deserializedPeople) {
            System.out.println(person);
        }
    }
}
