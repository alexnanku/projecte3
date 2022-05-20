package prj3;

import java.time.LocalDate;

public class CursCompetitiu extends Curs {

    private String nivell;
    private int preuCompeticio;

    public CursCompetitiu(String nivell, int preuCompeticio, int id_curs, String nom_curs, LocalDate data_inici, int nom_monitor, String descripcio) {
        super(id_curs, nom_curs, data_inici, nom_monitor, descripcio);
        this.nivell = nivell;
        this.preuCompeticio = preuCompeticio;
    }

    public String getNivell() {
        return nivell;
    }

    public void setNivell(String nivell) {
        this.nivell = nivell;
    }

    public int getPreuCompeticio() {
        return preuCompeticio;
    }

    public void setPreuCompeticio(int preuCompeticio) {
        this.preuCompeticio = preuCompeticio;
    }

    @Override
    public String toString() {
        return super.toString() + "nivell=" + nivell + ", preuCompeticio=" + preuCompeticio + '}';
    }
    
    

}
