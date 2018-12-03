package annisatahira.app.portalti16;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import annisatahira.app.portalti16.Network.Network;
import annisatahira.app.portalti16.Network.Routes;
import annisatahira.app.portalti16.adapter.MahasiswaAdapter;
import annisatahira.app.portalti16.entity.DaftarMahasiswa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.widget.Toast;

import static android.R.attr.tag;

/**
 * Created by annisatahira on 26/11/18.
 */

public class MainActivity extends AppCompatActivity{

    private RecyclerView lstMahasiswa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting recyclerviewnya dari id lst_mahasiswa yang ada di activity_main
        lstMahasiswa = (RecyclerView) findViewById(R.id.lst_mahasiswa);
        //set layout manager untuk lstMahasiswa
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstMahasiswa.setLayoutManager(linearLayoutManager);

        requestDaftarMahasiswa();
    }

    @Override
    protected void onStart() {
        super.onStart();
        requestDaftarMahasiswa();
    }

    private void requestDaftarMahasiswa() {

        Routes services = Network.request().create(Routes.class);

        services.getMahasiswa().enqueue(new Callback<DaftarMahasiswa>() {
            @Override
            public void onResponse(Call<DaftarMahasiswa> call, Response<DaftarMahasiswa> response) {
                if (response.isSuccessful()) {
                    //casting data yang didapatkan, menjadi daftar Mahasiswa
                    DaftarMahasiswa mahasiswas = response.body();

                    //get title
                   // Log.d( tag:"TI16", mahasiswas.getTitle());

                    //tampilkan daftar mahasiswa di recylerview
                    MahasiswaAdapter adapter = new MahasiswaAdapter(mahasiswas.getData());

                    lstMahasiswa.setAdapter(adapter);
                } else {
                    //ketika data tidak berhasil di load
                    onMahasiswaError();
                }
            }

            @Override
            public void onFailure(Call<DaftarMahasiswa> call, Throwable t) {

                onMahasiswaError();

            }
        });

    }

    private void onMahasiswaError() {
        Toast.makeText(
                MainActivity.this,
                "Gagal. Silahkan periksa koneksi internet anda.",
                Toast.LENGTH_LONG).show();
    }

}
