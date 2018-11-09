package gown.ooal.ainz.testgithublndc;

import java.util.ArrayList;
import java.util.List;

public class DiceList {
    public final static List<Dice> dices = new ArrayList<>();

    public static List<Dice> getDices() {
        return dices;
    }
    public static void addDice(Dice dice) {
        dices.add(dice);
    }
    public static void removeDice(Dice dice) {
        dices.remove(dice);
    }
}
