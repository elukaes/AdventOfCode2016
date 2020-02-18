package Day2.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Character> code;
        /*Keypad keypad = new Keypad(3, 1, 1);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day2\\input.txt"))) {
            code = getCode(bufferedReader, keypad);
        }*/

        Keypad2 keypad2 = new Keypad2(5, 2, 0);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day2\\input.txt"))) {
            code = getCode(bufferedReader, keypad2);
        }
        System.out.println(code);
    }
    // get code to open the door
    public static List getCode(BufferedReader bufferedReader, Keypad keypad) throws IOException {
        List<Character> code = new ArrayList<>();
        while(true) {
            String line = bufferedReader.readLine();
            if(line == null) {
                break;
            }
            for(int i=0; i<line.length(); i++) {
                keypad.move(line.charAt(i));
            }
            code.add(keypad.getActDigit());
        }
        return code;
    }

}