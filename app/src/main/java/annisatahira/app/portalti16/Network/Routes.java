package annisatahira.app.portalti16.Network;

import java.sql.Struct;

import annisatahira.app.portalti16.entity.DaftarMahasiswa;
import annisatahira.app.portalti16.entity.Mahasiswa;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by annisatahira on 26/11/18.
 */

public interface Routes {

    /**
     * Mendefinisikan root dari web services yang disediakan
     * Jika dideskripsikan berarti:
     * https://ti16.herokuapp.com/list.php
     * */

    @GET("dev/list_mahasiswa")
    Call<DaftarMahasiswa> getMahasiswa();

    @POST("dev/insert_mahasiswa")
    @FormUrlEncoded
    Call<Mahasiswa> postMahasiswa(
            @Field("name") String name,
            @Field("nim") String nim
            );

    @DELETE("mahasiswatest/{mhsId}")
    Call<Mahasiswa> deleteMahasiswa(
            @Path("mhsId") String mhsId
    );
}
