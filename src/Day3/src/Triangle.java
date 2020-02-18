package Day3.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//I did not understand 2 task's part of this day

public class Triangle {
    public static void main(String[] args) throws IOException {
        int triangle = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day3\\input.txt"))) {
            while(true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] dividedLine = line.split("  ");
                int i = 0;
                for(String s: dividedLine) {
                    if(!s.equals("")) {
                        dividedLine[i] = s;
                        i++;
                    }
                }
                int a = Integer.parseInt(dividedLine[0].trim());
                int b = Integer.parseInt(dividedLine[1].trim());
                int c = Integer.parseInt(dividedLine[2].trim());
                if(isTrianglePossible(a, b, c)) {
                    triangle++;
                }
            }
        }
        System.out.format("Quantity of triangles(task 1): %d",triangle);
    }

    public static boolean isTrianglePossible(int a, int b, int c) {
        if(a+b > c && a+c > b && b+c > a) {
            return true;
        }
        return false;
    }

    public static boolean isSameNumbersOfHundredDigits(int a, int b, int c) {
        if (a / 100 == b / 100 && a / 100 == c / 100 && b / 100 == c / 100) {
            return true;
        }
        return false;
    }
}
