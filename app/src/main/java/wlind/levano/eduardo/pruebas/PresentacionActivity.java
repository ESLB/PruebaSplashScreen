package wlind.levano.eduardo.pruebas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
// Todo Ya hemos implementado las 5 pantallas (un splash screen en una de ellas) Falta Poner Toolbar
//Lidiar con el inicio de sesion (no volver a iniciar sesión una vez hecho
//El DrawPanel
//Nada más por ahora
//Fecha: 03/09/2017
public class PresentacionActivity extends AppCompatActivity {

    Button mButton_iniciar_sesion;
    Button mButton_crear_cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton_iniciar_sesion = (Button) findViewById(R.id.button_iniciar_sesion);
        mButton_crear_cuenta = (Button) findViewById(R.id.button_crear_una_cuenta);

        mButton_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PresentacionActivity.this, InicioActivity.class));
            }
        });

        mButton_crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PresentacionActivity.this, RegistroActivity.class));
            }
        });

    }
}
