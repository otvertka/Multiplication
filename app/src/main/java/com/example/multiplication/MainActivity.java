package com.example.multiplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity{

    Random random = new Random();

    @BindView(R.id.tvNumber1)
    TextView tvNumber1;
    @BindView(R.id.tvNumber2)
    TextView tvNumber2;
    @BindView(R.id.tvResult)
    TextView tvResult;

    @BindView(R.id.btn0)
    Button btn0;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;

    int a, b, c;

    boolean proverka = false; // показать/скрыть ответ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button)
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
