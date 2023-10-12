package src;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    private static String command;
    private static Set<String> validCommands = new HashSet<String>() {{
        add("-create");
        add("-write");
        add("-delete");
        add("-read");
    }};
    private static String[] commandParams;

    private static String fileName;
    private static String action;
    private static String text;


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        command = scanner.nextLine();
        if (isValidCommand(command)){
            FileManager fileManager = new FileManager(fileName, action, text);
            fileManager.run();
            System.out.println("good");
        } else {
            System.out.println("The command is invalid!");
        }
    }

    private static boolean isValidCommand(String command) {
        commandParams = command.split(" ");
        if (commandParams.length > 1 & commandParams.length < 4)
            fileName = commandParams[0];
            action = commandParams[1];
            if (isCommand())
                return isValidLengthCommand();
        return false;
    }

    private static boolean isValidLengthCommand() {
        if (action.equals("write"))
            if (commandParams.length == 3) {
                text = commandParams[2];
                return true;
            }
        return  commandParams.length == 2;
    }

    private static boolean isCommand() {
        return validCommands.contains(action);
    }
}


// create file:  /home/artem/Projects/Java/Java-course/IO/test.txt -create
