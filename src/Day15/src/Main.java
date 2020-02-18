package Day15.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Disc> discList = new LinkedList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day15\\input.txt"))) {
            while(true) {
                String line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }
                String[] splitLine = line.split(" ");
                discList.add(new Disc(Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[11].replace(".", ""))));
            }
        }
        long time = 0l;
        boolean capsuleFallsThroughSlot = false;
        while(!capsuleFallsThroughSlot) {
            List<Disc> tmpDisc = new LinkedList<>(discList);
            for(int i=1; i<=discList.size(); i++) {
                //tmpDisc.add(new Disc(discList.get(i-1).getAMOUNT_POS(), discList.get(i-1).getActPos()));
                if(isCapsuleFallsThroughSlot(tmpDisc.get(i-1), time+i)) {
                    capsuleFallsThroughSlot = true;
                }
                else {
                    capsuleFallsThroughSlot = false;
                    break;
                }
            }
            time++;
        }
        System.out.println(time-1);
    }

    public static boolean isCapsuleFallsThroughSlot(Disc disc, long time) {
        disc.goForward(time);
        if(disc.getActPos() == 0) {
            return true;
        }
        return false;
    }
}
