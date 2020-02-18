package Day20.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FirewallRules {
    private static List<Long> lessValueIP = new LinkedList<>();
    private static List<Long> moreValueIP = new LinkedList<>();
    private static long maxBlockedIP = 0l;
    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day20\\input.txt"))) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] dividedLine = line.split("-");
                lessValueIP.add(Long.parseLong(dividedLine[0]));
                moreValueIP.add(Long.parseLong(dividedLine[1]));
            }
        }
        int loops = 0;
        while(maxBlockedIP < 4294967295l) {
            while(isBlacklistHasNextValue());
            if(maxBlockedIP < 4294967295l) {
                System.out.println(++maxBlockedIP);
                loops++;
            }
        }
        System.out.println(loops);
    }

    private static boolean isBlacklistHasNextValue() {
        for(int i=0; i<lessValueIP.size(); i++) {
            if(lessValueIP.get(i) <= maxBlockedIP+1 && moreValueIP.get(i) > maxBlockedIP) { //at least one more than max blocked IP
                maxBlockedIP = moreValueIP.get(i);
                lessValueIP.remove(i);
                moreValueIP.remove(i);
                return true;
            }
        }
        return false;
    }
}
