package Day7.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static List<String> hypernetSSL = new LinkedList<>();
    private static List<String> supernetSSL = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        int counterTLS = 0;
        int counterSSL = 0;
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day7\\input.txt"))) {
            while(true) {
                String line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }
                if (isIPSupportTLS(line)) {
                    counterTLS++;
                }
                if (isIPSupportSSL(line)) {
                    counterSSL++;
                }
            }
        }
        System.out.println("TLS: "+counterTLS);
        System.out.println("SSL: "+counterSSL);
    }

    public static boolean isIPSupportTLS(String text) {
        boolean goodIP = false;
        List<String> dividedText = divideText(text);
        for(int i=0; i<dividedText.size(); i++) {
            if(i%2 == 1) {
                if(!checkText(dividedText.get(i), true, 4, 3)) {
                    return false;
                }
            }
            else if(!goodIP) {
                goodIP = checkText(dividedText.get(i), false, 4, 3);
            }
        }
        return goodIP;
    }

    public static boolean isIPSupportSSL(String text) {
        List<String> dividedText = divideText(text);
        while((!supernetSSL.isEmpty()) || (!hypernetSSL.isEmpty())) {
            if (!supernetSSL.isEmpty()) {
                supernetSSL.remove(0);
            }
            if (!hypernetSSL.isEmpty()) {
                hypernetSSL.remove(0);
            }
        }

        for(int i=0; i<dividedText.size(); i++) {
            if(i%2 == 1) {
                checkText(dividedText.get(i), false, 3, 1);
            }
            else checkText(dividedText.get(i), false, 3, 2);
        }
        for(int i=0; i<hypernetSSL.size(); i++) {
            for(int j=0; j<supernetSSL.size(); j++) {
                if(hypernetSSL.get(i).charAt(0) == supernetSSL.get(j).charAt(1) && hypernetSSL.get(i).charAt(1) == supernetSSL.get(j).charAt(0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkText(String text, boolean result, int lengthText, int nbList) {
        for (int i=0; i<=text.length()-lengthText; i++) {
            String textLengthCharacters = text.substring(i, i+lengthText);
            if (textLengthCharacters.equals(new StringBuilder(textLengthCharacters).reverse().toString())) {
                if (!isLettersInRowAreTheSame(textLengthCharacters)) {
                    if(nbList == 1) {
                        hypernetSSL.add(textLengthCharacters);
                    }
                    else if(nbList == 2) {
                        supernetSSL.add(textLengthCharacters);
                    }
                    else return !result;
                }
            }
        }
        return result;
    }

    public static boolean isLettersInRowAreTheSame(String text) {
        char[] letters = text.toCharArray();
        int counterLetters = 0;
        for(int i=1; i<letters.length; i++) {
            if(letters[0] == letters[i]) {
                counterLetters++;
            }
        }
        if(counterLetters == letters.length-1) {
            return true;
        }
        return false;
    }

    public static List<String> divideText(String text) {
        List<String> dividedText = new LinkedList<>();
        String[] firstDivided = text.split("\\[");
        dividedText.add(firstDivided[0]);
        for(int i=1; i<firstDivided.length; i++) {
            String[] tmp = firstDivided[i].split("]");
            dividedText.add(tmp[0]);
            dividedText.add(tmp[1]);
        }
        return dividedText;
    }

}
