package wlind.levano.eduardo.pruebas.Pruebas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import wlind.levano.eduardo.pruebas.API.models.J1Jugador;
import wlind.levano.eduardo.pruebas.R;

public class AdapterJugadores extends RecyclerView.Adapter<AdapterJugadores.ViewHolderJugadores>{

    private ArrayList<J1Jugador> mJugadores;
    private Context mContex;

    public AdapterJugadores(ArrayList<J1Jugador> jugadores) {
        mJugadores = jugadores;
    }

    public AdapterJugadores(ArrayList<J1Jugador> jugadores, Context contex) {
        mJugadores = jugadores;
        mContex = contex;
    }

    @Override
    public ViewHolderJugadores onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_lista_jugador, null,false);

        return new ViewHolderJugadores(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderJugadores holder, int position) {
        holder.TVNombre.setText(mJugadores.get(position).getNombre());
        holder.TVEdad.setText(mJugadores.get(position).getEdad() + "");
        holder.TVEmail.setText(mJugadores.get(position).getEmail());
        holder.TVUbicacion.setText(mJugadores.get(position).getUbicacion());
        Picasso.with(mContex).load(mJugadores.get(position).getPerfilImagen()).into(holder.mImagen);
    }

    @Override
    public int getItemCount() {
        return mJugadores.size();
    }

    public class ViewHolderJugadores extends RecyclerView.ViewHolder {

        ImageView mImagen;
        TextView TVNombre;
        TextView TVEdad;
        TextView TVEmail;
        TextView TVUbicacion;


        public ViewHolderJugadores(View itemView) {
            super(itemView);
            mImagen = (ImageView) itemView.findViewById(R.id.RVImagen);
            TVNombre = (TextView) itemView.findViewById(R.id.RVNombre);
            TVEdad = (TextView) itemView.findViewById(R.id.RVEdad);
            TVEmail = (TextView) itemView.findViewById(R.id.RVEmail);
            TVUbicacion = (TextView) itemView.findViewById(R.id.RVUbicacion);
        }
    }
}
