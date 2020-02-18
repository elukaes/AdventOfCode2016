package Day14.src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class OneTimePad {
    private static String[] arrayHashMD5 = new String[30000];
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "ngcjuoqr";
        for(int i=0; i<arrayHashMD5.length; i++) { //task 2
            String hashMD5 = createHashMD5((input+i).getBytes());
            for(int j=0; j<2016; j++) {
                hashMD5 = createHashMD5(hashMD5.getBytes());
            }
            arrayHashMD5[i] = hashMD5;
        }
        System.out.println(findIndexProduces64thOneTimePadKey(input));
    }

    public static int findIndexProduces64thOneTimePadKey(String input) throws NoSuchAlgorithmException {
        int[] keyIndexes = new int[64];
        int index = 0, indexOfArray = 0;
        while(indexOfArray < 64) {
            //String hashMD5 = createHashMD5((input+index).getBytes()); //task 1
            String hashMD5 = arrayHashMD5[index]; //task2
            for(int i=0; i<hashMD5.length()-2; i++) {
                if(isTheSameCharacters(hashMD5.substring(i, i+3).toCharArray())) {
                    if(isIndexKey(input, index, hashMD5.charAt(i))) {
                        keyIndexes[indexOfArray] = index;
                        indexOfArray++;
                        System.out.println(index);
                    }
                    break;
                }
            }
            index++;
        }
        return keyIndexes[63];
    }

    public static boolean isTheSameCharacters(char[] letters) {
        for(int i=0; i<letters.length-1; i++) {
            if(letters[i] != letters[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIndexKey(String input, int index, char findingLetter) throws NoSuchAlgorithmException {
        for(int i=1; i<=1000; i++) {
            //String hashMD5 = createHashMD5((input+(index+i)).getBytes()); //task 1
            String hashMD5 = arrayHashMD5[index+i]; //task2
            for(int j=0; j<hashMD5.length()-4; j++) {
                if(hashMD5.charAt(j) == findingLetter) {
                    if(isTheSameCharacters(hashMD5.substring(j, j+5).toCharArray())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static String createHashMD5(byte[] text) throws NoSuchAlgorithmException {
        return String.format("%1$032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(text)));
    }
}