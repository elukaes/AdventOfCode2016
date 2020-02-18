package Day10.src;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private int number;
    private List<Integer> values;

    public Output(int number) {
        this.number = number;
        values = new ArrayList<>();
    }

    public void addValue(int value) {
        values.add(value);
    }

    public void removeValue(int value) {
        values.remove(value);
    }

    public List<Integer> getValues() {
        return values;
    }

    public int getValue(int index) {
        return values.get(index);
    }

    public int getNumber() {
        return number;
    }
}
