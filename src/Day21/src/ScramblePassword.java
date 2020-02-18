package Day21.src;

public class ScramblePassword {
    protected StringBuilder password;

    public ScramblePassword(String password) {
        this.password = new StringBuilder(password);
    }

    public void swapPosition(int index1, int index2) {
        char tmpLetter = password.charAt(index1);
        password.setCharAt(index1, password.charAt(index2));
        password.setCharAt(index2, tmpLetter);
    }

    public void swapLetters(char letter1, char letter2) {
        StringBuilder tmpPassword = new StringBuilder();
        for(int i=0; i<password.length(); i++) {
            if(password.charAt(i) == letter1) {
                tmpPassword.append(letter2);
                continue;
            }
            if(password.charAt(i) == letter2) {
                tmpPassword.append(letter1);
                continue;
            }
            tmpPassword.append(password.charAt(i));
        }
        password = tmpPassword;
    }

    public void rotatePassword(int program, int shift) {//1 - left, 2 - right
        StringBuilder tmpPassword = new StringBuilder();
        if(shift >= password.length()) {
            shift %= password.length();
        }
        if(program == 1) {
            for(int i=0; i<password.length(); i++) {
                tmpPassword.append(password.charAt((i+shift) % password.length()));
            }
        }
        else {
            for (int i = password.length(); i < password.length() * 2; i++) {
                tmpPassword.append(password.charAt((i-shift) % password.length()));
            }
        }
        password = tmpPassword;
    }

    public void rotatePassword(char letter) {//based on the letter
        int shift = password.indexOf(String.valueOf(letter));
        if(shift >= 4) {
            shift+=2;
        }
        else shift++;
        rotatePassword(2, shift);
    }

    public void reverseSubstring(int begin, int end) {
        password.replace(begin, end+1, new StringBuilder(password.substring(begin, end+1)).reverse().toString());
    }

    public void movePosition(int oldIndex, int newIndex) {
        char letter = password.charAt(oldIndex);
        password.deleteCharAt(oldIndex);
        password.insert(newIndex, letter);
    }

    public String toString() {
        return password.toString();
    }
}