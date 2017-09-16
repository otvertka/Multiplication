package com.example.multiplication;

import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.x;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.media.RingtoneManager.TYPE_RINGTONE;


public class MainActivity extends AppCompatActivity {

    Random random = new Random();

    @BindView(R.id.tvNumber1)
    TextView tvNumber1;
    @BindView(R.id.tvNumber2)
    TextView tvNumber2;
    @BindView(R.id.tvResult)
    TextView tvResult;
    @BindView(R.id.tv)
    TextView tv;

    int a, b, c, count;
    public byte star = 0;// счетчик для открытия звездочек
    final static int[] sizeTable = {9, 99, 999, 9999, 99999};
    Vibrator v;



    boolean proverka = false; // показать/скрыть ответ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

    }

    void init() {

        tvResult.setText("");
        tv.setText("");
        count = 0;
        star = 0;

        a = random.nextInt(100) + 1;
        tvNumber1.setText(String.valueOf(a));
        b = random.nextInt(100) + 1;
        tvNumber2.setText(String.valueOf(b));
        c = a * b;
        tvResult.setText("Ответ...");
        //count = countDigits(c);
        for (int i = 0; ; i++){
            if (c <= sizeTable[i]) {
                tv.setText("" + tv.getText() + "•");
                count = i + 1;
                break;
            } else {
                tv.setText("" + tv.getText() + "•");
            }
        }
    }

    static int countDigits(int x){
        for (int i = 0; ; i++){
            if (x <= sizeTable[i])
                return i + 1;
        }
    }

    void checkAnswer(byte x){

        StringBuffer sb = new StringBuffer(tv.getText());
        sb.replace(star, star+1, String.valueOf(x));
        star++;
        tv.setText(sb);
        if (star >= count){
            if(tv.getText().equals(String.valueOf(c))){

                /*try {
                    Uri notify = RingtoneManager.getDefaultUri(RingtoneManager.ID_COLUMN_INDEX);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notify);
                    r.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }*/



                /*MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.combo);
                mp.start();*/
                init();
            } else {
                v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(500);
                //Toast.makeText(getApplicationContext(), "НЕ правильно!!!", Toast.LENGTH_SHORT).show();
                init();
            }
        }
    }

    @OnClick({R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9})
    void onSaveClick(View view) {

        switch (view.getId()) {
            case R.id.btn0:
                checkAnswer((byte) 0);
                //view.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                //tv.setText("" + tv.getText().toString().sububSequence() + 0);
                break;
            case R.id.btn1:
                checkAnswer((byte) 1);
                //tv.setText("" + tv.getText() + 1);
                break;
            case R.id.btn2:
                checkAnswer((byte) 2);
                //tv.setText("" + tv.getText() + 2);
                break;
            case R.id.btn3:
                checkAnswer((byte) 3);
                //tv.setText("" + tv.getText() + 3);
                break;
            case R.id.btn4:
                checkAnswer((byte) 4);
                //tv.setText("" + tv.getText() + 4);
                break;
            case R.id.btn5:
                checkAnswer((byte) 5);
                //tv.setText("" + tv.getText() + 5);
                break;
            case R.id.btn6:
                checkAnswer((byte) 6);
                //tv.setText("" + tv.getText() + 6);
                break;
            case R.id.btn7:
                checkAnswer((byte) 7);
                //tv.setText("" + tv.getText() + 7);
                break;
            case R.id.btn8:
                checkAnswer((byte) 8);
                //tv.setText("" + tv.getText() + 8);
                break;
            case R.id.btn9:
                checkAnswer((byte) 9);
                //Toast.makeText(getApplicationContext(), "Press :" + 9, Toast.LENGTH_SHORT).show();
                //tv.setText("" + tv.getText() + 9);
                break;
        }
    }

    /*@OnClick(R.id.button)
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
    }*/
}
