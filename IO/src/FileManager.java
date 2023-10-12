package src;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private String fileName;
    private String command;
    private String text;

    public FileManager(String fileName, String command, String text){
        this.fileName = fileName;
        this.command = command;
        this.text = text;
    }

    public void run() throws IOException {
        switch (command) {
            case "-create":
                createFile();
                break;
        }
    }


    private void createFile() throws IOException{
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File is created!");
        }
    }
}
