package gown.ooal.ainz.testgithublndc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intentCreate = new Intent(this, TypeActivity.class);
        final Intent intentDiceList = new Intent(this, DiceListActivity.class);
        final Intent intentRoll = new Intent(this, RollActivity.class);

        final Button button_create = findViewById(R.id.button_m_create);
        final Button button_dice_list = findViewById(R.id.button_m_list);
        final Button button_roll = findViewById(R.id.button_m_roll);

        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCreate);
                //setContentView(R.layout.activity_type);
            }
        });

        button_dice_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentDiceList);
            }
        });

        button_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRoll);
            }
        });
    }
}
