package Day1.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Path {

    public static void main(String[] args) throws IOException {
        Movement movement = new Movement();
        Movement movement1 = new Movement();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day1\\input.txt"))) {
            readInput(bufferedReader, movement);
        }
        System.out.println("End location = ["+movement.getPositionX()+", "+movement.getPositionY()+"]");
        System.out.println("The shortest length of path = "+countPath(movement));
        System.out.println("First location visit twice = ["+movement.getFirstXVisitTwice()+", "+movement.getFirstYVisitTwice()+"]");
        System.out.println("The shortest length of path to first location visit twice = "+countPathToFirstLocationVisitTwice(movement));
    }

    public static void readInput(BufferedReader bufferedReader, Movement movement) throws IOException {
        while(true) {
            String line = bufferedReader.readLine();
            if(line == null) {
                break;
            }
            String[] dividedLine = line.split(", ");
            for(String s: dividedLine) {
                movement.move(s.charAt(0), Integer.valueOf(s.substring(1)));
            }
        }
    }

    public static int countPath(Movement movement) {
        return Math.abs(movement.getPositionX()) + Math.abs(movement.getPositionY());
    }

    public static int countPathToFirstLocationVisitTwice(Movement movement) {
        return Math.abs(movement.getFirstXVisitTwice()) + Math.abs(movement.getFirstYVisitTwice());
    }
}
