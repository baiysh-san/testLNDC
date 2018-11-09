package gown.ooal.ainz.testgithublndc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypeActivity extends AppCompatActivity {
    private Button numericButton;
    private Intent createNumericIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        numericButton = findViewById(R.id.button_t_numeric);
        createNumericIntent = new Intent(this, CreateNumericActivity.class);
        numericButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createNumericIntent);
            }
        });

    }
}
