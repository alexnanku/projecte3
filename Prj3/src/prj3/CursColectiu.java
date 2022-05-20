package prj3;

import java.time.LocalDate;

public class CursColectiu extends Curs {
    
    private int aforament;
    private double preuColectiu;

    public CursColectiu(int aforament, double preuColectiu, int id_curs, String nom_curs, LocalDate data_inici, int nom_monitor, String descripcio) {
        super(id_curs, nom_curs, data_inici, nom_monitor, descripcio);
        this.aforament = aforament;
        this.preuColectiu = preuColectiu;
    }

    public int getAforament() {
        return aforament;
    }

    public void setAforament(int aforament) {
        this.aforament = aforament;
    }

    public double getPreuColectiu() {
        return preuColectiu;
    }

    public void setPreuColectiu(int preuColectiu) {
        this.preuColectiu = preuColectiu;
    }

    @Override
    public String toString() {
        return super.toString() + "aforament: " + aforament + ", preuColectiu=" + preuColectiu + '}';
    }
    
    
}
