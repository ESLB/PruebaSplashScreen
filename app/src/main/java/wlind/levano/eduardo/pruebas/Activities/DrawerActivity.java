package wlind.levano.eduardo.pruebas.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import wlind.levano.eduardo.pruebas.Fragments.FragmentBusquedaInicio;
import wlind.levano.eduardo.pruebas.Fragments.FragmentContenedor;
import wlind.levano.eduardo.pruebas.Fragments.FragmentMiPerfil;
import wlind.levano.eduardo.pruebas.Fragments.FragmentMisEquipos;
import wlind.levano.eduardo.pruebas.Fragments.FragmentMisSolicitudes;
import wlind.levano.eduardo.pruebas.Fragments.FragmentPartidosProgramados;
import wlind.levano.eduardo.pruebas.Pruebas.FragmentGreen;
import wlind.levano.eduardo.pruebas.Pruebas.FragmentRed;
import wlind.levano.eduardo.pruebas.R;
import wlind.levano.eduardo.pruebas.Utilidades;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentBusquedaInicio.OnFragmentInteractionListener,
        FragmentMisEquipos.OnFragmentInteractionListener, FragmentMiPerfil.OnFragmentInteractionListener,
        FragmentMisSolicitudes.OnFragmentInteractionListener, FragmentPartidosProgramados.OnFragmentInteractionListener,
        FragmentContenedor.OnFragmentInteractionListener, FragmentGreen.OnFragmentInteractionListener,
        FragmentRed.OnFragmentInteractionListener{

    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

                                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                                    setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

       /* mImageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(getApplicationContext()).load("https://static.vix.com/es/sites/default/files/styles/large/public/btg/curiosidades.batanga.com/files/11-jugadores-de-futbol-mas-inteligentes-y-aplicados-de-lo-que-creias-7.jpg?itok=mUN4wpmf")
                .into(mImageView);*/
        //Picasso.with(mContex).load(mJugadores.get(position).getPerfilImagen()).into(holder.mImagen);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(Utilidades.ValidaPantalla){

            Fragment fragment = new FragmentBusquedaInicio();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment ).commit();
            Utilidades.ValidaPantalla = false;
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

                                @Override
                                public void onBackPressed() {
                                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                                        drawer.closeDrawer(GravityCompat.START);
                                    } else {
                                        super.onBackPressed();
                                    }
                                }

                                @Override
                                public boolean onCreateOptionsMenu(Menu menu) {
                                    // Inflate the menu; this adds items to the action bar if it is present.
                                    getMenuInflater().inflate(R.menu.drawer, menu);
                                    return true;
                                }

                                @Override
                                public boolean onOptionsItemSelected(MenuItem item) {
                                    // Handle action bar item clicks here. The action bar will
                                    // automatically handle clicks on the Home/Up button, so long
                                    // as you specify a parent activity in AndroidManifest.xml.
                                    int id = item.getItemId();

                                    //noinspection SimplifiableIfStatement
                                    if (id == R.id.action_settings) {
                                        return true;
                                    }

                                    return super.onOptionsItemSelected(item);
                                }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        boolean isfragmentSeleccionado = false;

        if (id == R.id.misEquipos) {
            fragment = new FragmentContenedor();
            isfragmentSeleccionado = true;
        } else if (id == R.id.misSolicitudes) {
            fragment= new FragmentMisSolicitudes();
            isfragmentSeleccionado = true;
        } else if (id == R.id.inicio) {
            fragment = new FragmentBusquedaInicio();
            isfragmentSeleccionado = true;
        } else if (id == R.id.miPerfil){
            fragment = new FragmentMiPerfil();
            isfragmentSeleccionado = true;
        } else if(id == R.id.partidosProgramados){
            fragment = new FragmentPartidosProgramados();
            isfragmentSeleccionado = true;
        }

        if(isfragmentSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
