package Day12.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Character, Integer> register = new HashMap<>();
    public static void main(String[] args) throws IOException {
        List<String> inputFile = new LinkedList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day12\\input.txt"))) {
            while (true) {
                String line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }
                inputFile.add(line);
            }
            createRegisters(4);
            parseFile(inputFile);
            System.out.println(register);
        }

    }

    public static void parseFile(List<String> inputFile) {
        for(int i=0; i<inputFile.size(); i++) {
            String[] dividedText = inputFile.get(i).split(" ");
            switch (dividedText[0].charAt(0)) {
                case 'c':
                    copyValue(dividedText[1], dividedText[2]);
                    break;
                case 'i':
                    incrementValue(dividedText[1]);
                    break;
                case 'd':
                    decrementValue(dividedText[1]);
                    break;
                case 'j':
                    i = i + jump(dividedText[1], dividedText[2]);
                    break;
            }
        }
    }

    public static void copyValue(String value, String name) {
        char nameRegister = name.charAt(0);
        try {
            register.replace(nameRegister, Integer.valueOf(value));
        }
        catch (NumberFormatException e) {
            register.replace(nameRegister, register.get(value.charAt(0)));
        }
    }

    public static void incrementValue(String name) {
        char nameRegister = name.charAt(0);
        register.replace(nameRegister, register.get(nameRegister)+1);
    }

    public static void decrementValue(String name) {
        char nameRegister = name.charAt(0);
        register.replace(nameRegister, register.get(nameRegister)-1);
    }

    public static int jump(String value, String jump) {
        int shift = 0, realValue;
        try {
            realValue = Integer.valueOf(value);
        }
        catch (NumberFormatException e) {
            realValue = register.get(value.charAt(0));
        }
        if(realValue != 0) {
            shift = Integer.valueOf(jump) - 1;
        }
        return shift;
    }

    private static void createRegisters(int size) {
        for(int i=0; i<size; i++) {
            if(97+i == 99) {
                register.put((char) (97+i), 1);
            }
            else register.put((char) (97+i), 0);
        }
    }

    public static Map<Character, Integer> getRegister() {
        return register;
    }
}
