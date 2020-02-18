package Day8.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LittleScreen screen = new LittleScreen(6, 50);
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day8\\input.txt"))) {
            while(true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                parseFile(line, screen);
            }
        }
        System.out.println(screen.countLitPixels());
        for(int i=0; i<screen.getRows(); i++) {
            for(int j=0; j<screen.getColumns(); j++) {
                System.out.print(screen.getValueOfCell(i, j));
            }
            System.out.println();
        }
    }

    public static void parseFile(String line, LittleScreen screen) {
        String[] dividedLine = line.split(" ");
        if(dividedLine[0].equals("rect")) {
            String[] splitColumnAndRow = dividedLine[1].split("x");
            screen.createRectangle(Integer.parseInt(splitColumnAndRow[0]), Integer.parseInt(splitColumnAndRow[1]));
        }
        else if(dividedLine[1].equals("column")) {
            screen.rotateColumn(Integer.parseInt(dividedLine[2].substring(2)), Integer.parseInt(dividedLine[4]));
        }
        else screen.rotateRow(Integer.parseInt(dividedLine[2].substring(2)), Integer.parseInt(dividedLine[4]));
    }
}
