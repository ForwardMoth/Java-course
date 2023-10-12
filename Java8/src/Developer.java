package src;

import java.security.PublicKey;
import java.util.List;

public class Developer {
    private String name;
    private List<String> languages;

    public Developer(String name, List<String> languages){
        this.name = name;
        this.languages = languages;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public String getName() {
        return name;
    }
}
