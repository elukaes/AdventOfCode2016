package Day21.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static ScramblePassword passwordToScramble = new ScramblePassword("abcdefgh");
    private static UnscramblePassword passwordToUnscramble = new UnscramblePassword("gbhcefad");

    public static void main(String[] args) throws IOException {
        List<String> input = new LinkedList<>();
        //System.out.println(passwordToScramble.toString()+",  "+passwordToUnscramble.toString());
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "C:\\\\Users\\\\ja\\\\Desktop\\\\Programowanie\\\\Java\\\\AdventOfCode2016\\\\src\\\\Day21\\\\input.txt"))) {
            int id = 1;
            while(true) {
                String line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }
                input.add(line);
                //parseCommand(line);
                //System.out.println(id+"  "+passwordToScramble.toString()+",  "+passwordToUnscramble.toString());
                //id++;
            }
        }
        Collections.reverse(input);
        for(String str: input) {
            parseCommand(str);
        }
        System.out.println(passwordToScramble.toString());
        System.out.println(passwordToUnscramble.toString());
    }

    public static void parseCommand(String text) {
        String[] dividedText = text.split(" ");
        switch (dividedText[0]+" "+dividedText[1]) {
            case "swap position": {
                passwordToScramble.swapPosition(stringToInt(dividedText[2]), stringToInt(dividedText[5]));
                passwordToUnscramble.swapPosition(stringToInt(dividedText[2]), stringToInt(dividedText[5]));
                break;
            }
            case "swap letter": {
                passwordToScramble.swapLetters(dividedText[2].charAt(0), dividedText[5].charAt(0));
                passwordToUnscramble.swapLetters(dividedText[2].charAt(0), dividedText[5].charAt(0));
                break;
            }
            case "rotate left": {
                passwordToScramble.rotatePassword(1, stringToInt(dividedText[2]));
                passwordToUnscramble.rotatePassword(2, stringToInt(dividedText[2]));
                break;
            }
            case "rotate right": {
                passwordToScramble.rotatePassword(2, stringToInt(dividedText[2]));
                passwordToUnscramble.rotatePassword(1, stringToInt(dividedText[2]));
                break;
            }
            case "rotate based": {
                passwordToScramble.rotatePassword(dividedText[6].charAt(0));
                passwordToUnscramble.rotatePassword(dividedText[6].charAt(0));
                break;
            }
            case "reverse positions": {
                passwordToScramble.reverseSubstring(stringToInt(dividedText[2]), stringToInt(dividedText[4]));
                passwordToUnscramble.reverseSubstring(stringToInt(dividedText[2]), stringToInt(dividedText[4]));
                break;
            }
            case "move position": {
                passwordToScramble.movePosition(stringToInt(dividedText[2]), stringToInt(dividedText[5]));
                passwordToUnscramble.movePosition(stringToInt(dividedText[5]), stringToInt(dividedText[2]));
                break;
            }
        }
    }

    private static int stringToInt(String text) {
        return Integer.parseInt(text);
    }
}