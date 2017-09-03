package com.example.multiplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Random random = new Random();

    TextView tvNumber1;
    TextView tvNumber2;
    TextView tvResult;

    Button btn;

    int a, b, c;

    boolean proverka = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber1 = (TextView)findViewById(R.id.tvNumber1);
        tvNumber2 = (TextView)findViewById(R.id.tvNumber2);
        tvResult = (TextView)findViewById(R.id.tvResult);

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if (!proverka){
            a = random.nextInt(100) + 1;
            tvNumber1.setText(String.valueOf(a));
            b = random.nextInt(100) + 1;
            tvNumber2.setText(String.valueOf(b));
            c = a * b;
            tvResult.setText("Ответ...");
            proverka = true;
        } else {
            tvResult.setText(String.valueOf(c));
            proverka = false;
        }
    }
}
