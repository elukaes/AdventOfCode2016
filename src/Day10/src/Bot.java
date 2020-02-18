package Day10.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bot {
    private int number;
    private List<Integer> values;

    public Bot(int number) {
        this.number = number;
        values = new ArrayList<>();
    }

    public void addValue(int value) {
        values.add(value);
    }

    public void removeValue(int value) {
        for(int i=0; i<values.size(); i++) {
            if(values.get(i) == value) {
                values.remove(i);
            }
        }
    }

    public int findHighestValue() {
        return Collections.max(values);
    }

    public int findLowestValue() {
        return Collections.min(values);
    }

    public int getAmountOfValues() {
        return values.size();
    }

    public List<Integer> getValues() {
        return values;
    }

    public int getNumber() {
        return number;
    }
}
