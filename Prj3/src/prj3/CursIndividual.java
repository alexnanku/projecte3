package prj3;

import java.time.LocalDate;

public class CursIndividual extends Curs {
    
    private int preuHora;

    public CursIndividual(int preuHora, int id_curs, String nom_curs, LocalDate data_inici, int nom_monitor, String descripcio) {
        super(id_curs, nom_curs, data_inici, nom_monitor, descripcio);
        this.preuHora = preuHora;
    }

    public int getPreuHora() {
        return preuHora;
    }

    public void setPreuHora(int preuHora) {
        this.preuHora = preuHora;
    }

    @Override
    public String toString() {
        return super.toString() + "preuHora=" + preuHora + '}';
    }
}
