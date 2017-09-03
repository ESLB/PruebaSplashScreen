package wlind.levano.eduardo.pruebas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class InicioActivity extends AppCompatActivity {

    ImageButton mImageButton_crear_equipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        mImageButton_crear_equipo = (ImageButton) findViewById(R.id.button_crear_equipo);

        mImageButton_crear_equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InicioActivity.this, CreaEquipo.class));
            }
        });



    }

}
