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
    private Thread t;
    private boolean stop;
    private boolean start = false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        setContentView(R.layout.activity_test_count);
        Button button = findViewById(R.id.button_start);
        Button button1 = findViewById(R.id.button_stop);
        textView = findViewById(R.id.text_test);
        textView.setText("24");
        t = new Thread() {

            @Override
            public void run(){
                if(stop == true){
                    return;
                }
                while(!isInterrupted()){

                    try {
                        Thread.sleep(100);  //1000ms = 1 sec

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Random random = new Random();
                                count = random.nextInt(24 - 1 + 1) + 1;
                                textView.setText(String.valueOf(count));
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start == true) {

                } else {
                    t.start();
                    start = true;
                }

                //startCountAnimation();

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop = true;
                t.interrupt();

                //startCountAnimation();

            }
        });





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
