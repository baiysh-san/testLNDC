package gown.ooal.ainz.testgithublndc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice implements Serializable {
    private String name;
    private List<Integer> sides;
    private int randomSide;

    public Dice(String name, int sidesNumber) {
        this.name = name;
        sides = new ArrayList<>();
        createSides(sidesNumber);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void createSides(int sidesNumber) {
        for (int i = 1; i <= sidesNumber; i++) {
            sides.add(i);
        }
    }
    public int getRandomSide() {
        Random random = new Random();
        randomSide = sides.get(random.nextInt(sides.size()));
        return randomSide;
    }
    public List<Integer> getSides() {
        return sides;
    }


}
