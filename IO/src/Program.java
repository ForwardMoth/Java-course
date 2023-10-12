package src;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    private static String command;
    private static final Set<String> validCommands = new HashSet<String>() {{
        add("-create");
        add("-write");
        add("-delete");
        add("-read");
    }};
    private static String[] commandParams;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        command = scanner.nextLine();
        if (isValidCommand(command)){
            FileManager fileManager = new FileManager(commandParams[0], commandParams[1], formText());
            fileManager.run();
        } else {
            System.out.println("The command is invalid!");
        }
    }

    private static String formText(){
        if (isWrite()) {
            StringBuilder sb = new StringBuilder();
            for(int i=2;i<commandParams.length;i++) {
                sb.append(commandParams[i]);
                if (i != commandParams.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
        return "";
    }

    private static boolean isValidCommand(String command) {
        commandParams = command.split(" ");
        return commandParams.length > 1 & isCommand() & isValidLengthCommand();
    }

    private static boolean isValidLengthCommand() {
        return isWrite() ? commandParams.length > 2 : commandParams.length == 2;
    }

    private static boolean isWrite(){
        return commandParams[1].equals("-write");
    }

    private static boolean isCommand() {
        return validCommands.contains(commandParams[1]);
    }
}

