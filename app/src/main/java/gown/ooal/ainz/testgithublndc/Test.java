package gown.ooal.ainz.testgithublndc;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Dice dice = new Dice("tree", 3);
        List<Integer> diceSides = dice.getSides();
        for (int side: diceSides) {
            System.out.println(side);
        }
        System.out.println(dice.getRandomSide());

    }
}
