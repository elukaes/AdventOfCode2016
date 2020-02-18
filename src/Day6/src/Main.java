package Day6.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] inputLines;
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day6\\input.txt"))) {
            inputLines = fileToArray(bufferedReader);
        }
        System.out.println(findMessage(inputLines));
    }

    private static String[] fileToArray(BufferedReader bufferedReader) {
        Object[] obj = bufferedReader.lines().toArray();
        String[] array = new String[obj.length];
        for(int i=0; i<obj.length; i++) {
            array[i] = (String)obj[i];
        }
        return array;
    }

    public static String findMessage(String[] inputLines) {
        StringBuilder message = new StringBuilder();
        for(int i=0; i<inputLines[0].length(); i++) {
            StringBuilder column = new StringBuilder();
            for (String s : inputLines) {
                column.append(s.charAt(i));
            }
            message.append(findLetterInColumn(column.toString()));
        }
        return message.toString();
    }

    public static char findLetterInColumn(String line) {
        int[] counter = new int[122-97+1];
        for(int i=0; i<line.length(); i++) {
            counter[line.toLowerCase().charAt(i)-97]++;
        }
        return (char) (findIndex(counter)+97);
    }
    // in task 1 we must find the index with the highest value; in task 2 with the lowest value(but at least 1)
    public static int findIndex(int[] counter) {
        int index = 0;
        for(int i=1; i<counter.length; i++) {
            if(counter[i] < counter[index] && counter[i] > 0) {
                index = i;
            }
        }
        return index;
    }

}
