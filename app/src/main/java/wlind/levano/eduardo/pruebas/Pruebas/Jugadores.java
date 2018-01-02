package wlind.levano.eduardo.pruebas.Pruebas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wlind.levano.eduardo.pruebas.APIGOL.JugadorClient;
import wlind.levano.eduardo.pruebas.APIGOL.RetrofitLab;
import wlind.levano.eduardo.pruebas.APIGOL.models.Jugador;
import wlind.levano.eduardo.pruebas.R;

public class Jugadores extends AppCompatActivity{

    private ArrayList<Jugador> mJugadores = new ArrayList<Jugador>();
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        RetrofitLab retrofitLab = RetrofitLab.getRetrofitLab();
        final JugadorClient mJugadorClient = retrofitLab.getRetrofit().create(JugadorClient.class);

        Call<List<Jugador>> call = mJugadorClient.pedirJugadores();

        mRecyclerView = (RecyclerView) findViewById(R.id.RVJugadores);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        final AdapterJugadores adapterJugadores = new AdapterJugadores(mJugadores, this);
        mRecyclerView.setAdapter(adapterJugadores);

        call.enqueue(new Callback<List<Jugador>>() {
            @Override
            public void onResponse(Call<List<Jugador>> call, Response<List<Jugador>> response) {
                List<Jugador> jugadores = response.body();
                mJugadores.addAll(jugadores);
                Toast.makeText(Jugadores.this, response.body().get(0).getEdad().toString(), Toast.LENGTH_SHORT).show();
                adapterJugadores.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Jugador>> call, Throwable t) {
                Toast.makeText(Jugadores.this, "Problemas para contactar la BD", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
