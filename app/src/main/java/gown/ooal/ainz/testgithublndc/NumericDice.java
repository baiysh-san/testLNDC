package gown.ooal.ainz.testgithublndc;

import java.util.ArrayList;
import java.util.List;

public class NumericDice extends Dice {

    private List<Integer> sides;

    public NumericDice(int sidesNumber) {
        sides = new ArrayList<>();
        createSides(sidesNumber);
    }
    private void createSides(int sidesNumber) {
        for (int i = 1; i <= sidesNumber; i++) {
            sides.add(i);
        }
    }

    public List<Integer> getSides() {
        return sides;
    }
}
