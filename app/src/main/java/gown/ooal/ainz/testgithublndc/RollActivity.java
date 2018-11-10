package gown.ooal.ainz.testgithublndc;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RollActivity extends AppCompatActivity {

    private Spinner diceSpinner;
    private Button addButton;
    private Button rollButton;
    private ArrayList<Dice> rollDices;
    private EditText amountEditText;
    private GridView gridView;
    private CustomGridViewAdapter customGridViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rollDices = new ArrayList<>();
        setContentView(R.layout.activity_roll);
        Intent intent = getIntent();


        diceSpinner = findViewById(R.id.spinner_r_choose);
        ArrayList<String> diceNames = new ArrayList<>();
        for (Dice dice: DiceList.getDices()) {
            diceNames.add(dice.getName());
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diceNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceSpinner.setAdapter(adapter);
        addButton = findViewById(R.id.button_r_add);
        rollButton = findViewById(R.id.button_r_roll);
        amountEditText = findViewById(R.id.editText_r_amount);

        gridView = findViewById(R.id.gridView1);
        customGridViewAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, rollDices);
        gridView.setAdapter(customGridViewAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDiceName = diceSpinner.getSelectedItem().toString();
                Dice selectedDice = DiceList.getByName(selectedDiceName);
                int amount = 0;
                if (!amountEditText.getText().toString().equals("")) {
                    amount = Integer.parseInt(amountEditText.getText().toString());
                }
                for (int i = 0; i < amount; i++) {
                    rollDices.add(selectedDice);
                }

            }
        });
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RollActivity.this, RandomActivity.class);
                i.putExtra("roll_dices", rollDices);
                startActivity(i);
            }
        });

    }

}
