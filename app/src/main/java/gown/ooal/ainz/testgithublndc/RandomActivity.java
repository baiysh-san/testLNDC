package gown.ooal.ainz.testgithublndc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class RandomActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    private float mAccel; // acceleration apart from gravity
    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity
    ArrayList<Dice> rollDices;
    private GridView gridView;
    private SecondGridViewAdapter customGridViewAdapter;

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
        setContentView(R.layout.activity_random);
        Bundle extras = getIntent().getExtras();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
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
        gridView.setVisibility(View.INVISIBLE);
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
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                gridView.setVisibility(View.VISIBLE);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
}
