package Day9.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputText;
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day9\\input.txt"))) {
                inputText = bufferedReader.readLine();
        }
        System.out.println(parseTextTask1(inputText).length());
    }

    public static String parseTextTask1(String inputText) {
        StringBuilder decompressedText = new StringBuilder();
        for(int i=0; i<inputText.length(); i++) {
            if(inputText.charAt(i) == '(') {
                char endParenthesis = ' ';
                int j = i;
                while(endParenthesis != ')') {
                    endParenthesis = inputText.charAt(j);
                    j++;
                }
                String[] decompressedData = inputText.substring(i+1, j-1).split("x");
                for(int k=0; k<Integer.parseInt(decompressedData[1]); k++) {
                    decompressedText.append(inputText, j, j+Integer.parseInt(decompressedData[0]));
                }
                i = j+Integer.parseInt(decompressedData[0])-1;
            }
            else decompressedText.append(inputText.charAt(i));
        }
        return decompressedText.toString();
    }
}
