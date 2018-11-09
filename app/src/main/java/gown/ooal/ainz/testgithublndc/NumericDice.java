package gown.ooal.ainz.testgithublndc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public int getRandomSide() {
        Random random = new Random();
        int randomSide = sides.get(random.nextInt(sides.size()));
        return randomSide;
    }
    public List<Integer> getSides() {
        return sides;
    }
}
