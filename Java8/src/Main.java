package src;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));
        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);
        List<Developer> developers = developerStream.toList();
        List<String> uniqueLanguages = developers.stream()
                .flatMap(developer -> developer.getLanguages().stream())
                .toList();
        List<String> filteredLanguages = uniqueLanguages.stream()
                .filter(lang -> uniqueLanguages.stream().filter(c -> c.equals(lang)).count() == 1)
                .toList();
        developers.stream()
                .filter(developer -> developer.getLanguages().stream().anyMatch(lang -> filteredLanguages.contains(lang)))
                .forEach(dev -> System.out.println(dev.getName()));
    }
}



