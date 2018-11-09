package gown.ooal.ainz.testgithublndc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.parseInt;

public class CreateNumericActivity extends AppCompatActivity {
    private Intent intentMain;
    private EditText nameEditText;
    private EditText sidesNumber;
    private Button saveButton;
    private Button removeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_numeric);
        intentMain = new Intent(this, MainActivity.class);
        nameEditText = findViewById(R.id.editText_cn_name);
        sidesNumber = findViewById(R.id.editText_cn_sides);
        saveButton = findViewById(R.id.btn_cn_save);
        removeButton = findViewById(R.id.btn_cn_remove);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sides = Integer.parseInt(sidesNumber.getText().toString());
                Dice dice = new Dice(nameEditText.getText().toString(), sides);
                DiceList.addDice(dice);
                startActivity(intentMain);
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentMain);
            }
        });

    }
}
