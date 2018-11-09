package gown.ooal.ainz.testgithublndc;

import android.app.Application;

public class Startup extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DiceList.addDice(new Dice("d6", 6));
        DiceList.addDice(new Dice("d2", 2));
    }
}
