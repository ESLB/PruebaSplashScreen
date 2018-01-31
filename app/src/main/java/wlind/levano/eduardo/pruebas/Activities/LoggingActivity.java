package wlind.levano.eduardo.pruebas.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wlind.levano.eduardo.pruebas.API.JugadorClient;
import wlind.levano.eduardo.pruebas.API.RetrofitLab;
import wlind.levano.eduardo.pruebas.API.models.J1Jugador;
import wlind.levano.eduardo.pruebas.Pruebas.Jugadores;
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
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);
        ButterKnife.bind(this);

        mButton_crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoggingActivity.this, PruebasJugador.class));
            }
        });

        mSharedPreferences = getSharedPreferences("GOL", Context.MODE_PRIVATE);


    }

    @OnClick(R.id.button_SharedPreferences)
    public void buttonSharePreferences(){
        mEditor = mSharedPreferences.edit();
        info = mETInfo.getText().toString();
        password = mETPassword.getText().toString();
        if(TodoEnOrden(this, info, password))
        {
            mEditor.putString("info", info);
            mEditor.putString("password", password);
            mEditor.putBoolean("isLoginKey", true);
            mEditor.apply();

            String info2 = mSharedPreferences.getString("info", "nada");
            String password2 = mSharedPreferences.getString("password", "nada");

            mTVPruebasLogin.setText(info2 + " " + password2);
        }
    }

    @OnClick(R.id.button_iniciar_sesion)
    public void onButtonGetClick() {

        info = mETInfo.getText().toString();
        password = mETPassword.getText().toString();



        if(TodoEnOrden(this, info, password)){

            J1Jugador jugador = new J1Jugador();
            jugador.setEmail(info);
            jugador.setTelephone(info);
            jugador.setPassword(password);

            RetrofitLab retrofitLab = RetrofitLab.getRetrofitLab();
            JugadorClient mJugadorClient = retrofitLab.getRetrofit().create(JugadorClient.class);

            Call<J1Jugador> call = mJugadorClient.autenticar(jugador);
            call.enqueue(new Callback<J1Jugador>() {
                @Override
                public void onResponse(Call<J1Jugador> call, Response<J1Jugador> response) {
                    if(response.body()!=null){
                        mEditor = mSharedPreferences.edit();
                        mEditor.putBoolean("isLoginKey", true);
                        mEditor.apply();
                        //mTVPruebasLogin.setText(response.body().getNombre());
                        Toast.makeText(LoggingActivity.this, "Bienvenido " + response.body().getNombre(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoggingActivity.this, DrawerActivity.class));
                        finish();
                    }else{
                        Toast.makeText(LoggingActivity.this, "Datos incorrectos" + response.body().getNombre(), Toast.LENGTH_SHORT).show();
                        mTVPruebasLogin.setText("No autorizado");
                    }
                }

                @Override
                public void onFailure(Call<J1Jugador> call, Throwable t) {
                    mTVPruebasLogin.setText("Algo salió mal");
                }
            });
            //mTVPruebasLogin.setText(info + password);
        } else{
            startActivity(new Intent(LoggingActivity.this, DrawerActivity.class));
        }

    }



    @OnClick(R.id.button_recyclerView)
    public void onBTRecyclerClick(){
        startActivity(new Intent(LoggingActivity.this, Jugadores.class));
    }

    @OnClick(R.id.button_pruebas)
    public void onBTPruebas(){
        startActivity(new Intent(LoggingActivity.this, DrawerActivity.class
        ));
    }


}
