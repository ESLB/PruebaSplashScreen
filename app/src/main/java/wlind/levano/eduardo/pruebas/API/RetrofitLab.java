package wlind.levano.eduardo.pruebas.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitLab {

    private static RetrofitLab sRetrofitLab;
    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;


    private RetrofitLab(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.addInterceptor(loggingInterceptor);

        mOkHttpClient = okHttpBuilder.build();

        mRetrofit = new Retrofit.Builder().baseUrl("https://serene-brushlands-19371.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build();

    }

    public static RetrofitLab getRetrofitLab(){
     if(sRetrofitLab==null){
         sRetrofitLab = new RetrofitLab();
     }

     return sRetrofitLab;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
