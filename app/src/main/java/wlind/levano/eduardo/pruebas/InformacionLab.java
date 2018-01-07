package wlind.levano.eduardo.pruebas;

import java.util.ArrayList;

import wlind.levano.eduardo.pruebas.APIGOL.EquipoClient;
import wlind.levano.eduardo.pruebas.APIGOL.RetoClient;
import wlind.levano.eduardo.pruebas.APIGOL.RetrofitLab;
import wlind.levano.eduardo.pruebas.APIGOL.SolicitudClient;
import wlind.levano.eduardo.pruebas.APIGOL.models.Equipo;
import wlind.levano.eduardo.pruebas.APIGOL.models.Jugador;
import wlind.levano.eduardo.pruebas.APIGOL.models.Reto;
import wlind.levano.eduardo.pruebas.APIGOL.models.Solicitud;

public class InformacionLab {

    private static InformacionLab sInformacionLab;
    private static Jugador mJugador;

    private ArrayList<Equipo> mEquipos = new ArrayList<Equipo>();
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

    public static InformacionLab getInformacionLab(Jugador jugador){
        if(sInformacionLab == null){
            mJugador = jugador;
            sInformacionLab = new InformacionLab();
        }
        return sInformacionLab;
    }



}
