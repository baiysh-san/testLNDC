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
    private SensorManager mSensorManager;
    private float mAccel; // acceleration apart from gravity
    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity
    private Spinner diceSpinner;
    private Button addButton;
    private Button rollButton;
    private ArrayList<Dice> rollDices;
    private EditText amountEditText;
    private GridView gridView;
    private CustomGridViewAdapter customGridViewAdapter;


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rollDices = new ArrayList<>();
        setContentView(R.layout.activity_roll);
        Intent intent = getIntent();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

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
    private final SensorEventListener mSensorListener = new SensorEventListener() {

        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter
            if (mAccel > 12) {
                Toast toast = Toast.makeText(getApplicationContext(), "Device has shaken.", Toast.LENGTH_LONG);
                toast.show();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
}
