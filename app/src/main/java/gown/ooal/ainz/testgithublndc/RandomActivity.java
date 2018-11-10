package gown.ooal.ainz.testgithublndc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class RandomActivity extends AppCompatActivity {
    ArrayList<Dice> rollDices;
    private GridView gridView;
    private SecondGridViewAdapter customGridViewAdapter;
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
        gridView = findViewById(R.id.gridView2);
        customGridViewAdapter = new SecondGridViewAdapter(this, R.layout.row2_grid, rollDices);
        gridView.setAdapter(customGridViewAdapter);
    }
}
