package kairoscode.songfree;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    String tag = "Lifecycle";
    Boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag, "In the onCreate() event");

        // Cargo layout main
        setContentView(R.layout.activity_main);

        // Leo intent recibido
        Intent searchIntent = getIntent();
        login = searchIntent.getBooleanExtra("log",true);
        if (!login){
            Toast.makeText(this, "Login Error. Please, login again.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    public void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }
    public void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }
    public void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }
    public void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }



    // FUNCIONES -----------------------------------------------------------------------------------
    //Funcion de espera
 /*   public void waitTime(Integer time){
        new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

            }
        }.start();
    }*/
}