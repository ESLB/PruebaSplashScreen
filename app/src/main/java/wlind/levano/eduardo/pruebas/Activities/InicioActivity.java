package wlind.levano.eduardo.pruebas.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wlind.levano.eduardo.pruebas.R;

public class InicioActivity extends AppCompatActivity {

    ImageButton mImageButton_crear_equipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ButterKnife.bind(this);
        mImageButton_crear_equipo = (ImageButton) findViewById(R.id.button_crear_equipo);
        mImageButton_crear_equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InicioActivity.this, CreaEquipo.class));
            }
        });
    }


    @OnClick(R.id.button_logOut)
    public void buttonLogOut(){
        Toast.makeText(this, "Llegamos aquí", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getSharedPreferences("GOL", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("isLoginKey");
        editor.apply();
        startActivity(new Intent(InicioActivity.this, LoggingActivity.class));
    }


}
