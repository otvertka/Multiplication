package com.example.multiplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;

import static java.lang.reflect.Array.getInt;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    Random random = new Random();

    @BindView(R.id.tvNumber1)
    TextView tvNumber1;
    @BindView(R.id.tvNumber2)
    TextView tvNumber2;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.timerValue)
    TextView tvTimer;

    SharedPreferences sPref;
    byte keyLevel = 1;
    int maxA = 10, maxB = 10;

    int a, b, c, count; // множители(a,b), ответ, число знаков в ответе
    public byte star = 0;// счетчик для открытия звездочек
    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999};
    Vibrator v;
    StringBuffer sb;

    /** for timer**/
    long startTime = 0L, timeInMilliSeconds=0L;
    Handler handler = new Handler();

    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliSeconds = SystemClock.uptimeMillis() - startTime;
            int secs = (int) (timeInMilliSeconds/1000);
            int mins = secs/60;
            secs%=60;
            int milliSeconds = (int) (timeInMilliSeconds%1000);
            tvTimer.setText("" + mins + ":" + String.format("%02d", secs) + ":"
                                            + String.format("%03d", milliSeconds));
            handler.postDelayed(this, 0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Log.d(TAG, "HELLO!");
        sPref = PreferenceManager.getDefaultSharedPreferences(this);

        init();

        startTime = SystemClock.uptimeMillis();
        handler.postDelayed(updateTimerThread, 0);
    }

    @Override
    protected void onResume() {
        //Log.d(TAG, "" + sPref.getString("level", "1"));
        keyLevel = Byte.parseByte(sPref.getString("level", "1"));
        switch (keyLevel){
            case 1:
                maxA = 10;
                maxB = 10;
                break;
            case 2:
                maxA = 10;
                maxB = 100;
                break;
            case 3:
                maxA = 100;
                maxB = 100;
                break;
            case 4:
                maxA = 100;
                maxB = 1000;
                break;
            case 5:
                maxA = 1000;
                maxB = 1000;
                break;
        }
        init();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Settings");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    void init() {

        a = random.nextInt(maxA);
        tvNumber1.setText(String.valueOf(a));
        b = random.nextInt(maxB);
        tvNumber2.setText(String.valueOf(b));
        c = a * b;

        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        clear();

    }
    void clear(){

        //tvResult.setText("");
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
