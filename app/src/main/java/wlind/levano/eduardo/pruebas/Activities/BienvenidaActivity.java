package wlind.levano.eduardo.pruebas.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wlind.levano.eduardo.pruebas.R;

public class BienvenidaActivity extends AppCompatActivity {

    @BindView(R.id.IVImagenJugador)
    ImageView mImagenJugador;
    @BindView(R.id.TVNombreJugador)
    TextView mNombreJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.buttonLogOut)
    public void buttonLogOut(){

    }







}
