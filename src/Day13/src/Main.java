package Day13.src;

import Day13.Coordinates;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(50, 50, 1350);
        BoardEnum[][] b = board.getBoard();
        for(int i=0; i<b.length; i++) {
            for(int j=0; j<b[i].length; j++) {
                System.out.print(b[i][j].getPlace()+",");
            }
            System.out.println();
        }
    }

    public static int findShortestPath(Board board) {
        int counterMovements = 0;
        int x = 1, y = 1;//start position
        while(x != 31 && y != 39) {
            
        }
        return counterMovements;
    }

    public static int atMost50Moves(Board board) {
        List<Coordinates> coordinates = new LinkedList<>();
        int counterPlaces = 0;
        int moves = 0;
        
        return counterPlaces;
    }
}
