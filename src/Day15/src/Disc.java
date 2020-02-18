package Day15.src;

public class Disc {
    private final int AMOUNT_POS;
    private long actPos;

    public Disc(int amountOfPos, long actPos) {
        AMOUNT_POS = amountOfPos;
        this.actPos = actPos;
    }

    public void goForward(long amountSteps) {
        actPos = (actPos + amountSteps) % AMOUNT_POS;
    }

    public long getActPos() {
        return actPos;
    }

    public int getAMOUNT_POS() {
        return AMOUNT_POS;
    }
}
