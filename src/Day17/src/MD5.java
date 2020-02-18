package Day17.src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class MD5 {
    private static StringBuilder hashCode = new StringBuilder("ihgpwlah");

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Set<String> set = new HashSet<>();
        Grid grid = new Grid(4);
        while(!grid.isFoundRoom()) {
            grid.position(hashCode.toString().substring(8));
            char move = grid.parseHash(transmit4Characters());
            boolean addMove = true;
            if(move != ' ') {
                for(int i=0; i<set.size(); i++) {
                    if(set.contains(hashCode.toString())) {
                        addMove = false;
                        break;
                    }
                }
                if(addMove) {
                    addMoveToHashCode(move);
                }
            }
            else {
                set.add(hashCode.toString());
                deleteLastMove();
            }
        }
        System.out.println("Result: "+(hashCode.toString().substring(8)));
    }

    public static String transmit4Characters() throws NoSuchAlgorithmException {
        String hashMD5 = String.format("%1$032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(hashCode.toString().getBytes())));
        return hashMD5.substring(0, 4);
    }

    public static void addMoveToHashCode(char move) {
        hashCode.append(move);
    }

    public static void deleteLastMove() {
        hashCode.deleteCharAt(hashCode.length()-1);
    }
}