package Day19.src;

public class Elf {
    private boolean isActive;
    private long amountOfGifts;

    public Elf() {
        isActive = true;
        amountOfGifts = 1l;
    }

    public void addGifts(long amount) {
        amountOfGifts += amount;
    }

    public void disableActive() {
        amountOfGifts = 0;
        isActive = false;
    }

    public long getAmountOfGifts() {
        return amountOfGifts;
    }

    public boolean getIsActive() {
        return isActive;
    }
}
