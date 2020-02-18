package Day19.src;

import java.util.HashMap;
import java.util.Map;

public class WhiteElephant {
    public static void main(String[] args) {
        long amountOfElves = 3014603l;
        Map<Long, Elf> elvesMap = new HashMap<>();
        for(long i=1l; i<=amountOfElves; i++) {
            elvesMap.put(i, new Elf());
        }
        long winElf;
        long index = 1l;
        long lastActive = 0l;
        while(true) {
            if(elvesMap.get(index).getIsActive()) {
                if (lastActive != 0) {
                    elvesMap.get(lastActive).addGifts(elvesMap.get(index).getAmountOfGifts());
                    elvesMap.get(index).disableActive();
                    lastActive = 0l;
                } else lastActive = index;
            }
            if(elvesMap.get(index).getAmountOfGifts() == amountOfElves) {
                winElf = index;
                break;
            }
            index++;
            if(index == amountOfElves+1) {
                index = 1l;
            }
        }
        System.out.println(winElf);
    }
}
