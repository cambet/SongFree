package kairoscode.songfree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String tag = "Lifecycle";

    Map<String,String> users = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "In the onCreate() event");
        Toast.makeText(this, "In the onCreate()", Toast.LENGTH_SHORT).show();
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




    public void btnClicked(View view) {
        chargeData();
        readUsers();
    }

    private void readUsers(){
        Toast.makeText(this, "User: carlos -> Pass: " + users.get("carlos"), Toast.LENGTH_SHORT).show();
    }

    private void chargeData(){
        users.put("carlos","carlos");
    }

}
