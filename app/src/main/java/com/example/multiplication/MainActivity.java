package com.example.multiplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;


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
    StringBuffer sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

    }

    void clear(){

        tvResult.setText("");
        tv.setText("");
        tv.setTextSize(100);
        count = 0;
        star = 0;

        for (int i = 0; ; i++){
            if (c <= sizeTable[i]) {
                tv.setText("" + tv.getText() + "•");
                count = i + 1;
                break;
            } else {
                tv.setText("" + tv.getText() + "•");
            }
        }
        sb = new StringBuffer(tv.getText());

    }
    void init() {

        a = random.nextInt(100);
        tvNumber1.setText(String.valueOf(a));
        b = random.nextInt(100);
        tvNumber2.setText(String.valueOf(b));
        c = a * b;

        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        clear();

    }

    void checkAnswer(byte x){

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
                v.vibrate(500);
                init();
            }
        }
    }

    @OnClick({R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDel})
    void onSaveClick(View view) {

        switch (view.getId()) {
            case R.id.btn0:
                checkAnswer((byte) 0);
                //view.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                break;
            case R.id.btn1:
                checkAnswer((byte) 1);
                break;
            case R.id.btn2:
                checkAnswer((byte) 2);
                break;
            case R.id.btn3:
                checkAnswer((byte) 3);
                break;
            case R.id.btn4:
                checkAnswer((byte) 4);
                break;
            case R.id.btn5:
                checkAnswer((byte) 5);
                break;
            case R.id.btn6:
                checkAnswer((byte) 6);
                break;
            case R.id.btn7:
                checkAnswer((byte) 7);
                break;
            case R.id.btn8:
                checkAnswer((byte) 8);
                break;
            case R.id.btn9:
                checkAnswer((byte) 9);
                break;
            case R.id.btnDel:
                deleteAnswer();
                break;
        }
    }

    void deleteAnswer(){

        if (star > 0) {
            star--;
            sb.replace(star, star + 1, "•");
            tv.setText(sb);
        }
    }

}
