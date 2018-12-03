package annisatahira.app.portalti16.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by annisatahira on 26/11/18.
 */

public class Network {

    public static Retrofit request(){
        return new Retrofit.Builder()
                //ini main url dari web service yang tersedia
                .baseUrl("https://ti16.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
