package kairoscode.songfree;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String tag = "Lifecycle";
    Boolean login = false;
    Map<String,String> users = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag, "In the onCreate() event");
        // Carga de usuarios iniciales
        loadData();
        // Cargo layout login
        setContentView(R.layout.activity_login);
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


    // CODIGO ELEMENTOS LAYOUT ---------------------------------------------------------------------
    // Boton datos login
    public void btnLogin(View view){
        EditText etuser = (EditText)findViewById(R.id.editText);
        EditText etpass = (EditText)findViewById(R.id.editText2);

        String user = etuser.getText().toString();
        String pass = etpass.getText().toString();

        if(checkLogin(user, pass)){
            login = true;
            Toast.makeText(this, "Right data.", Toast.LENGTH_SHORT).show();
            goTOSearchActivity();
        }else{
            Toast.makeText(this, "Wrong data.", Toast.LENGTH_SHORT).show();
        }
    }
    // Boton ir a register
    public void toRegister(View view){
        setContentView(R.layout.activity_register);
    }
    // Boton datos register
    public void btnRegister(View view){
        EditText etuser = (EditText)findViewById(R.id.editText);
        EditText etpass = (EditText)findViewById(R.id.editText2);

        String user = etuser.getText().toString();
        String pass = etpass.getText().toString();

        if(addNewUser(user, pass)){
            Toast.makeText(this, "User added.", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_login);
        }else{
            Toast.makeText(this, "User already exist.", Toast.LENGTH_SHORT).show();
        }
    }

    // FUNCIONES -----------------------------------------------------------------------------------
    // Carga de datos iniciales
    private void loadData(){
        users.put("c", "123");
    }

    // Comprueba datos login
    private Boolean checkLogin(String user, String pass){
        Boolean log = false;

        if(users.containsKey(user) && (users.get(user).equals(pass))){
            log = true;
        }
        return log;
    }

    // Registro nuevo usuario
    private Boolean addNewUser(String user, String pass){
        Boolean res = false;
        if (!users.containsKey(user)){
            res = true;
            users.put(user, pass);
        }
        return res;
    }

    // Funcion ir a actividad Search Activity
    public void goTOSearchActivity(){
        Intent mainIntent;
        mainIntent = new Intent(getApplicationContext(), SearchActivity.class);

        mainIntent.putExtra("log", login);

        startActivity(mainIntent);
    }

    //Funcion de espera
/*    public void waitTime(Integer time){
        new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

            }
        }.start();
    }*/


}
