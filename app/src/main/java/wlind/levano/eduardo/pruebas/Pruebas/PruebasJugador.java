package wlind.levano.eduardo.pruebas.Pruebas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wlind.levano.eduardo.pruebas.API.JugadorClient;
import wlind.levano.eduardo.pruebas.API.models.J1Jugador;
import wlind.levano.eduardo.pruebas.R;


public class PruebasJugador extends AppCompatActivity {

    @BindView(R.id.txtvNombre)
    TextView mTextViewNombre;
    @BindView(R.id.txtvEmail)
    TextView mTextViewEmail;
    @BindView(R.id.txtvPassword)
    TextView mTextViewPassword;
    @BindView(R.id.txtvEdad)
    TextView mTextViewEdad;
    @BindView(R.id.txtvUbicacion)
    TextView mTextViewUbicacion;
    @BindView(R.id.txtvTelephone)
    TextView mTextViewTelephone;
    @BindView(R.id.txtvId)
    TextView mTextViewId;
    @BindView(R.id.txtListaDeJugadores)
    TextView mTextViewListaJugadores;
    
    //HTTP connection
    OkHttpClient.Builder okhttpClientBuilder;
    HttpLoggingInterceptor loggin;
    Retrofit.Builder mBuilder;
    Retrofit mRetrofit;
    JugadorClient mJugadorClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas_jugador);
        ButterKnife.bind(this);

        okhttpClientBuilder = new OkHttpClient.Builder();
        loggin = new HttpLoggingInterceptor();

        mBuilder = new Retrofit.Builder()
                .baseUrl("https://serene-brushlands-19371.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClientBuilder.build());

        mRetrofit = mBuilder.build();

        mJugadorClient = mRetrofit.create(JugadorClient.class);

    }


    @OnClick(R.id.buttonGET)
    public void onButtonGetTodosClick(){

        String id = mTextViewId.getText().toString();
        if(TodoEnOrden(this, id)){
            Call<J1Jugador> call = mJugadorClient.pedirJugador(id);
            call.enqueue(new Callback<J1Jugador>() {
                @Override
                public void onResponse(Call<J1Jugador> call, Response<J1Jugador> response) {
                    Toast.makeText(PruebasJugador.this, "Todo Bien", Toast.LENGTH_SHORT).show();
                    J1Jugador jugador = response.body();
                    mTextViewListaJugadores.setText("id:" + jugador.get_id() + " nombre:" +
                            jugador.getNombre() + " edad:" +jugador.getEdad() + " email: " + jugador.getEmail() +
                            " password: " + jugador.getPassword() + " ubicacion: " + jugador.getUbicacion() +
                            " telefono: " + jugador.getTelephone());

                }

                @Override
                public void onFailure(Call<J1Jugador> call, Throwable t) {
                    Toast.makeText(PruebasJugador.this, "Algo salió mal", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    @OnClick(R.id.buttonGETTodos)
    public void onButtonGetClick(){

        Call<List<J1Jugador>> call = mJugadorClient.pedirJugadores();
        call.enqueue(new Callback<List<J1Jugador>>() {
            @Override
            public void onResponse(Call<List<J1Jugador>> call, Response<List<J1Jugador>> response) {
                Toast.makeText(PruebasJugador.this, "Todo Bien", Toast.LENGTH_SHORT).show();
                List<J1Jugador> jugadores = response.body();
                String mensaje = "";
                for (J1Jugador jugador:jugadores) {
                    mensaje = mensaje + "  id:" + jugador.get_id() + " nombre:" +
                            jugador.getNombre() + " edad:" +jugador.getEdad() + " email: " + jugador.getEmail() +
                            " password: " + jugador.getPassword() + " ubicacion: " + jugador.getUbicacion() +
                            " telefono: " + jugador.getTelephone();
                }
                mTextViewListaJugadores.setText(mensaje);
            }

            @Override
            public void onFailure(Call<List<J1Jugador>> call, Throwable t) {

            }
        });

    }

    @OnClick(R.id.buttonPOST)
    public void onButtonPostClick(){

        String nombre = mTextViewNombre.getText().toString();
        String edad =  mTextViewEdad.getText().toString();
        String email = mTextViewEmail.getText().toString();
        String password = mTextViewPassword.getText().toString();
        String ubicacion = mTextViewUbicacion.getText().toString();
        String telephone = mTextViewTelephone.getText().toString();

        if(TodoEnOrden(this, nombre, edad, email, password, ubicacion,telephone)){

            J1Jugador jugador = new J1Jugador(nombre, Integer.parseInt(edad), email, password, ubicacion, telephone);

            Call<J1Jugador> call = mJugadorClient.crearJugador(jugador);
            call.enqueue(new Callback<J1Jugador>() {
                @Override
                public void onResponse(Call<J1Jugador> call, Response<J1Jugador> response) {
                    Toast.makeText(PruebasJugador.this, response.body().getNombre(), Toast.LENGTH_SHORT).show();
                    mTextViewId.setText(response.body().get_id());
                }

                @Override
                public void onFailure(Call<J1Jugador> call, Throwable t) {
                    Toast.makeText(PruebasJugador.this, "Fallo", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    @OnClick(R.id.buttonPATCH)
    public void onButtonPatchClick(){
        String nombre = mTextViewNombre.getText().toString();
        String edad =  mTextViewEdad.getText().toString();
        String email = mTextViewEmail.getText().toString();
        String password = mTextViewPassword.getText().toString();
        String ubicacion = mTextViewUbicacion.getText().toString();
        String telephone = mTextViewTelephone.getText().toString();
        String id = mTextViewId.getText().toString();

        if(TodoEnOrden(this, nombre, edad, email, password, ubicacion,telephone, id)){

            J1Jugador jugador = new J1Jugador(nombre, Integer.parseInt(edad), email, password, ubicacion, telephone);

            Call<J1Jugador> call = mJugadorClient.update(id, jugador);
            call.enqueue(new Callback<J1Jugador>() {
                @Override
                public void onResponse(Call<J1Jugador> call, Response<J1Jugador> response) {
                    Toast.makeText(PruebasJugador.this, response.body().getNombre(), Toast.LENGTH_SHORT).show();
                    mTextViewId.setText(response.body().get_id());
                }

                @Override
                public void onFailure(Call<J1Jugador> call, Throwable t) {
                    Toast.makeText(PruebasJugador.this, "Fallo", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public static boolean TodoEnOrden( Context context, String... cadenas){

        boolean a = true;
        for (String cadena:cadenas) {
            if(cadena.equals(null)|| cadena.equals("")){
                a = false;
                Toast.makeText(context, "Falta Completar Parametros Obligatorios", Toast.LENGTH_SHORT).show();
            }
        }

        return a;
    }

}
