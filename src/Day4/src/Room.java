package Day4.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class Room {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("(.+-)(\\d+)\\[([a-z]+)]");
        long sumIDRealRooms = 0;
        int searchRoom = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day4\\input.txt"))) {
            while(true) {
                String line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }
                Matcher matcher = pattern.matcher(line);
                matcher.matches();
                if(isRealRoom(lettersCounter(matcher.group(1).toLowerCase().replace("-", "")), matcher.group(3))) {
                    sumIDRealRooms += Long.parseLong(matcher.group(2));
                    String decryptName = decryptNameRoom(matcher.group(1), Integer.parseInt(matcher.group(2)));
                    if(decryptName.contains("northpole")) {
                        searchRoom = Integer.parseInt(matcher.group(2));
                    }
                }
            }
        }
        System.out.format("ID sum of real rooms: %d\nID room where North Pole objects are stored: %d", sumIDRealRooms, searchRoom);
    }

    public static Map<Character, Integer> lettersCounter(String s) {
        Map<Character, Integer> letters = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char key = s.charAt(i);
            if(letters.containsKey(key)) {
                letters.put(key, letters.get(key) + 1);
                continue;
            }
            letters.put(key, 1);
        }
        return sortMap(letters);
    }

    public static boolean isRealRoom(Map<Character, Integer> name, String checkSum) {
        if(checkSum.equals(mapToString(name))) {
            return true;
        }
        return false;
    }

    public static String decryptNameRoom(String encryptName, int IDRoom) {
        StringBuilder decryptName = new StringBuilder();
        int shift = IDRoom % 26;
        for(int i=0; i<encryptName.length()-1; i++) { //last dash is bypassed
            if(encryptName.charAt(i) == '-') {
                decryptName.append(" ");
                continue;
            }
            int decryptLetter = encryptName.charAt(i) + shift;
            decryptName.append((decryptLetter > 122) ? (char)(decryptLetter - 26) : (char)decryptLetter);
        }
        return decryptName.toString();
    }

    private static Map<Character, Integer> sortMap(Map<Character, Integer> unsortedMap) {
        Map<Character, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        return sortedMap;
    }

    private static String mapToString(Map<Character, Integer> map) {
        return map.keySet().toString().replace(", ", "").replace("[", "").replace("]", "");
    }
}
