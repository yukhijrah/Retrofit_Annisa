package annisatahira.app.portalti16;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import annisatahira.app.portalti16.adapter.MahasiswaAdapter;
import annisatahira.app.portalti16.data.MahasiswaRepository;
import annisatahira.app.portalti16.entity.Mahasiswa;

/**
 * Created by annisatahira on 09/01/19.
 */

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView lstFavorite;

    private MahasiswaAdapter adapter;
    private MahasiswaRepository mhsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        lstFavorite = (RecyclerView) findViewById(R.id.lst_favorite);
        lstFavorite.setLayoutManager(new LinearLayoutManager(this));

        mhsRepository = new MahasiswaRepository(this);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                List<Mahasiswa> mahasiswas = mhsRepository.getMahasiswas();

                if (mahasiswas.size() > 0) {
                    adapter = new MahasiswaAdapter(mahasiswas);
                    lstFavorite.setAdapter(adapter);
                } else {
                    Toast.makeText(FavoriteActivity.this,
                            "Tidak ada item favorite.",
                            Toast.LENGTH_LONG).show();
                }
                return null;
            }
        }.execute();
    }
}