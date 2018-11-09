package gown.ooal.ainz.testgithublndc;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Dice dice = new NumericDice(3);
        List<Integer> diceSides = ((NumericDice) dice).getSides();
        for (int side: diceSides) {
            System.out.println(side);
        }
        System.out.println(((NumericDice) dice).getRandomSide());
        //test
    }
}
