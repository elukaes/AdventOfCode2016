package Day16.src;

public class Main {
    public static void main(String[] args) {
        String data = "01110110101001000";
        int lengthToFillUp = 35651584;// 272 for task 1, 35651584 for task 2
        while(data.length() < lengthToFillUp) {
            data = increaseLengthData(data);
        }
        System.out.println(findChecksum(data.substring(0, lengthToFillUp)));

    }

    public static String findChecksum(String data) {
        String checksum = data;
        while(checksum.length()%2 == 0) {
            checksum = divideChecksum(checksum);
        }
        return checksum;
    }

    public static String divideChecksum(String oldChecksum) {
        StringBuilder newChecksum = new StringBuilder();
        int index = 0;
        while(index < oldChecksum.length()) {
            String pair = oldChecksum.substring(index, index+2);
            if(pair.equals("00") || pair.equals("11")) {
                newChecksum.append("1");
            }
            else newChecksum.append("0");
            index += 2;
        }
        return newChecksum.toString();
    }

    public static String increaseLengthData(String oldData) {
        StringBuilder newData = new StringBuilder(oldData);
        newData.append("0");
        newData.append(replaceDigitsAndReverse(oldData));
        return newData.toString();
    }

    public static String replaceDigitsAndReverse(String rawData) {
        StringBuilder exchangedText = new StringBuilder();
        for(int i=0; i<rawData.length(); i++) {
            if(rawData.charAt(i) == '1') {
                exchangedText.append("0");
            }
            else exchangedText.append("1");
        }
        return exchangedText.reverse().toString();
    }
}
