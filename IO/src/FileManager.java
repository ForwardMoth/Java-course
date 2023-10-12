package src;

import java.io.*;

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
            case "-delete":
                deleteFile();
                break;
            case "-write":
                writeFile();
                break;
            case "-read":
                readFile();
                break;
        }
    }


    private void createFile() throws IOException{
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File is created!");
        }
    }

    private void deleteFile(){
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File is deleted");
        }
    }

    private void writeFile() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(text);
        bw.close();
        System.out.println("Text is written in file");
    }

    private void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null)
            System.out.println(line);
    }
}
