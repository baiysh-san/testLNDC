package gown.ooal.ainz.testgithublndc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class RandomActivity extends AppCompatActivity {
    ArrayList<Dice> rollDices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            rollDices = (ArrayList<Dice>)extras.get("roll_dices");
        }
        for (Dice dice:
             rollDices) {
            System.out.println("Dice: " + dice.getName() + " " + dice.getRandomSide());
        }
    }
}
