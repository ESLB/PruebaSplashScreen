package wlind.levano.eduardo.pruebas.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wlind.levano.eduardo.pruebas.Pruebas.PruebasJugador;
import wlind.levano.eduardo.pruebas.R;

import static wlind.levano.eduardo.pruebas.Pruebas.PruebasJugador.TodoEnOrden;

// Todo Ya hemos implementado las 5 pantallas (un ejemplo_splash screen en una de ellas) Falta Poner Toolbar
//Lidiar con el inicio de sesion (no volver a iniciar sesión una vez hecho
//El DrawPanel
//Nada más por ahora
//Fecha: 03/09/2017
public class LoggingActivity extends AppCompatActivity {

    @BindView(R.id.button_crear_una_cuenta)
    Button mButton_crear_cuenta;
    @BindView(R.id.etInfo)
    EditText mETInfo;
    @BindView(R.id.etPassword)
    EditText mETPassword;
    @BindView(R.id.txtvPruebasLogin)
    TextView mTVPruebasLogin;

    private String info, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);
        ButterKnife.bind(this);

        /*mButton_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoggingActivity.this, InicioActivity.class));
            }
        });*/

        mButton_crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoggingActivity.this, PruebasJugador.class));
            }
        });

    }

    @OnClick(R.id.button_iniciar_sesion)
    public void onButtonGetClick() {

        info = mETInfo.getText().toString();
        password = mETPassword.getText().toString();
        if(TodoEnOrden(this, info, password)){
            mTVPruebasLogin.setText(info + password);
        }

    }




}
