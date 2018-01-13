package wlind.levano.eduardo.pruebas;

import java.util.ArrayList;

import wlind.levano.eduardo.pruebas.API.EquipoClient;
import wlind.levano.eduardo.pruebas.API.RetoClient;
import wlind.levano.eduardo.pruebas.API.RetrofitLab;
import wlind.levano.eduardo.pruebas.API.SolicitudClient;
import wlind.levano.eduardo.pruebas.API.models.E1Equipo;
import wlind.levano.eduardo.pruebas.API.models.J1Jugador;
import wlind.levano.eduardo.pruebas.API.models.Solicitud;

public class InformacionLab {

    private static InformacionLab sInformacionLab;
    private static J1Jugador mJugador;

    private ArrayList<E1Equipo> mE1Equipos = new ArrayList<E1Equipo>();
    private ArrayList<Solicitud> mSolicitudes = new ArrayList<Solicitud>();

    //Cosas por hacer:
    //Desde aquí pedir toda la información importante para el usuario
    //Todavía no guardaremos nada en SQLite
    private InformacionLab(){

        RetrofitLab retrofitLab = RetrofitLab.getRetrofitLab();
        EquipoClient mEquipoC = retrofitLab.getRetrofit().create(EquipoClient.class);
        RetoClient mRetoC = retrofitLab.getRetrofit().create(RetoClient.class);
        SolicitudClient mSolicitudC = retrofitLab.getRetrofit().create(SolicitudClient.class);;

        String Hola = "";
        String cadenas[] = Hola.split(",");

    }

    public static InformacionLab getInformacionLab(J1Jugador jugador){
        if(sInformacionLab == null){
            mJugador = jugador;
            sInformacionLab = new InformacionLab();
        }
        return sInformacionLab;
    }



}
