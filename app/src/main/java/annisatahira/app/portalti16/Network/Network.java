package annisatahira.app.portalti16.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by annisatahira on 26/11/18.
 */

public class Network {

    public static Retrofit request(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                //ini main url dari web service yang tersedia
                .baseUrl("https://35.186.145.167:1337/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
