package gown.ooal.ainz.testgithublndc;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TestCountActivity extends AppCompatActivity {
    private TextView textView;
    private int count = 1;
    private boolean randBool;
    private Button startButton;
    private Button stopButton;
    private boolean startWasClicked;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randBool = false;
        startWasClicked = false;
        Intent intent = getIntent();
        setContentView(R.layout.activity_test_count);
        startButton = findViewById(R.id.button_start);
        stopButton = findViewById(R.id.button_stop);
        textView = findViewById(R.id.text_test);
        textView.setText("24");
        final Thread thread = new Thread() {
            @Override
            public void run() {
               try {
                   while (!isInterrupted()) {
                       Thread.sleep(100);
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               Random random = new Random();
                               count = random.nextInt(24 - 1 + 1) + 1;
                               textView.setText(String.valueOf(count));
                           }
                       });
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        };
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!startWasClicked) {
                    thread.start();
                    startWasClicked = true;
                } else {

                }
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startWasClicked) {
                    thread.interrupt();
                }
            }
        });


    }
    public void  rollingLoop() {
        while (randBool) {
            Random random = new Random();
            count = random.nextInt(24 - 1 + 1) + 1;
            textView.setText(String.valueOf(count));
        }
    }
    private void startCountAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(1, 6);

        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }
}
