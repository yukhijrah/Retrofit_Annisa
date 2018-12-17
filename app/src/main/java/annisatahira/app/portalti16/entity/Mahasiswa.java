package annisatahira.app.portalti16.entity;

import java.io.Serializable;

/**
 * Created by annisatahira on 26/11/18.
 */

public class Mahasiswa implements Serializable{

    private String name;
    private String nim;
    private int id;

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public int getId() {
        return id;
    }
}
