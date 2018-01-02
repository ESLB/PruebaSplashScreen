package wlind.levano.eduardo.pruebas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSharedPreferences("GOL", 0).getBoolean("isLoginKey", false)){
            startActivity(new Intent(SplashScreen.this, InicioActivity.class));
        }else {
            startActivity(new Intent(SplashScreen.this, LoggingActivity.class));
        }

        finish();
    }

}
