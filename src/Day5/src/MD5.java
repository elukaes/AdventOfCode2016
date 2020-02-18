package Day5.src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String text = "ojvtpuvg";
        //System.out.println(findPassword(text, 1, 8));
        System.out.println(findPassword(text, 2, 8));
    }

    public static String findPassword(String text, int task, int length) throws NoSuchAlgorithmException {
        StringBuilder password = new StringBuilder();
        String[] passwordTask2 = new String[length];
        BigInteger index = new BigInteger(String.valueOf(0));
        int counterLetters = 0;
        while(counterLetters < length) {
            byte[] bytesOfText = (text+index).getBytes();
            String hashMD5 = String.format("%1$032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(bytesOfText)));
            if(hashMD5.substring(0, 5).equals("00000")) {
                char decASCII = hashMD5.charAt(5);
                if(task == 1) {
                    password.append(decASCII);
                    counterLetters++;
                }
                else if(decASCII-48 < length && passwordTask2[decASCII-48] == null) {
                    passwordTask2[decASCII-48] = String.valueOf(hashMD5.charAt(6));
                    counterLetters++;
                }

            }
            index = index.add(BigInteger.valueOf(1));
        }
        if(task == 2) {
            for(String c: passwordTask2) {
                password.append(c);
            }
        }
        return password.toString();
    }
}
