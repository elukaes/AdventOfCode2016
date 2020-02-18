package Day21.src;

public class UnscramblePassword extends ScramblePassword {

    public UnscramblePassword(String password) {
        super(password);
    }

    @Override
    public void rotatePassword(char letter) {//based on the letter
        int index = password.indexOf(String.valueOf(letter));
        int shift = 0;
        if(index == 0) {
            shift = 1;
        }
        else if(index%2 == 1) {
            shift = (index+1)/2;
        }
        else shift = index/2 + 5;
        rotatePassword(1, shift);
    }
}
