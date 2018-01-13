package wlind.levano.eduardo.pruebas.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import wlind.levano.eduardo.pruebas.API.models.J1Jugador;

public interface JugadorClient {

    @GET("jugadores")
    Call<List<J1Jugador>> pedirJugadores();

    @GET("jugadores/{id}")
    Call<J1Jugador> pedirJugador(@Path("id") String id);

    @POST("jugadores")
    Call<J1Jugador> crearJugador(@Body J1Jugador jugador);

    @PATCH("jugadores/{id}")
    Call<J1Jugador> update(@Path("id") String id, @Body J1Jugador jugador);

    @DELETE("jugadores/{id}")
    Call<J1Jugador> eliminar(@Path("id") String id);

    @POST("login")
    Call<J1Jugador> autenticar(@Body J1Jugador jugador);

}
