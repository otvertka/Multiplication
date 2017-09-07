package com.example.multiplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Random random = new Random();

    @BindView(R.id.tvNumber1)
    TextView tvNumber1;
    @BindView(R.id.tvNumber2)
    TextView tvNumber2;
    @BindView(R.id.tvResult)
    TextView tvResult;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.editText)
    EditText editText;

    /*@BindView(R.id.btn0)
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
    Button btn9;*/

    int a, b, c;

    boolean proverka = false; // показать/скрыть ответ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9})
    void onSaveClick(View view) {

        switch (view.getId()) {
            case R.id.btn0:
                tv.setText("" + tv.getText() + 0);
                break;
            case R.id.btn1:
                tv.setText("" + tv.getText() + 1);
                break;
            case R.id.btn2:
                tv.setText("" + tv.getText() + 2);
                break;
            case R.id.btn3:
                tv.setText("" + tv.getText() + 3);
                break;
            case R.id.btn4:
                tv.setText("" + tv.getText() + 4);
                break;
            case R.id.btn5:
                tv.setText("" + tv.getText() + 5);
                break;
            case R.id.btn6:
                tv.setText("" + tv.getText() + 6);
                break;
            case R.id.btn7:
                tv.setText("" + tv.getText() + 7);
                break;
            case R.id.btn8:
                tv.setText("" + tv.getText() + 8);
                break;
            case R.id.btn9:
                //Toast.makeText(getApplicationContext(), "Press :" + 9, Toast.LENGTH_SHORT).show();
                tv.setText("" + tv.getText() + 9);
                break;
        }
        if(tv.getText().equals(String.valueOf(c))){
            Toast.makeText(getApplicationContext(), "УРАААА" , Toast.LENGTH_SHORT).show();
        }
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
            editText.setText(String.valueOf(c));
            proverka = false;
        }
    }
}
