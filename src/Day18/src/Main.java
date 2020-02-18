package Day18.src;

public class Main {
    public static void main(String[] args) {
        String input = ".^^.^^^..^.^..^.^^.^^^^.^^.^^...^..^...^^^..^^...^..^^^^^^..^.^^^..^.^^^^.^^^.^...^^^.^^.^^^.^.^^.^.";
        int height = 400000;
        Floor floor = new Floor(height, input.length(), input);
        for(int i=1; i<height; i++) {
            floor.addNewRow(i);
        }
        System.out.println(floor.countSafeTile());
    }
}
