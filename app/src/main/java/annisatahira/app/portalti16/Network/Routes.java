package annisatahira.app.portalti16.Network;

import java.sql.Struct;

import annisatahira.app.portalti16.entity.DaftarMahasiswa;
import annisatahira.app.portalti16.entity.Mahasiswa;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by annisatahira on 26/11/18.
 */

public interface Routes {

    /**
     * Mendefinisikan root dari web services yang disediakan
     * Jika dideskripsikan berarti:
     * https://ti16.herokuapp.com/list.php
     * */

    @GET("list.php")
    Call<DaftarMahasiswa> getMahasiswa();

    @POST("add.php")
    @FormUrlEncoded
    Call<Mahasiswa> postMahasiswa(
            @Field("nama") String nama,
            @Field("nim") String nim
            );
}
