package annisatahira.app.portalti16.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import annisatahira.app.portalti16.entity.Mahasiswa;

/**
 * Created by annisatahira on 09/01/19.
 */

@Database(entities = {Mahasiswa.class}, version = 1, exportSchema = false)
public abstract class MahasiswaDatabase extends RoomDatabase {
    public abstract MahasiswaDao mahasiswaDao();
}
