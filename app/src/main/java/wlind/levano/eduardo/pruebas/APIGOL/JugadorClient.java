package wlind.levano.eduardo.pruebas.APIGOL;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import wlind.levano.eduardo.pruebas.APIGOL.models.Jugador;

public interface JugadorClient {

    @GET("jugadores")
    Call<List<Jugador>> pedirJugadores();

    @GET("jugadores/{id}")
    Call<Jugador> pedirJugador(@Path("id") String id);

    @POST("jugadores")
    Call<Jugador> crearJugador(@Body Jugador jugador);

    @PATCH("jugadores/{id}")
    Call<Jugador> update(@Path("id") String id, @Body Jugador jugador);

    @DELETE("jugadores/{id}")
    Call<Jugador> eliminar(@Path("id") String id);

    @POST("login")
    Call<Jugador> autenticar(@Body Jugador jugador);

}
