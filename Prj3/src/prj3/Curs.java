package prj3;

import java.time.LocalDate;

public class Curs {
    
    private int id_curs;
    private String nom_curs;
    private LocalDate data_inici;
    private int nom_monitor;
    private String descripcio;

    public Curs(int id_curs, String nom_curs, LocalDate data_inici, int nom_monitor, String descripcio) {
        this.id_curs = id_curs;
        this.nom_curs = nom_curs;
        this.data_inici = data_inici;
        this.nom_monitor = nom_monitor;
        this.descripcio = descripcio;
    }

    public int getId_curs() {
        return id_curs;
    }

    public void setId_curs(int id_curs) {
        this.id_curs = id_curs;
    }

    public String getNom_curs() {
        return nom_curs;
    }

    public void setNom_curs(String nom_curs) {
        this.nom_curs = nom_curs;
    }

    public LocalDate getData_inici() {
        return data_inici;
    }

    public void setData_inici(LocalDate data_inici) {
        this.data_inici = data_inici;
    }

    public int getNom_monitor() {
        return nom_monitor;
    }

    public void setNom_monitor(int nom_monitor) {
        this.nom_monitor = nom_monitor;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Curs{" + "id_curs=" + id_curs + ", nom_curs=" + nom_curs + ", data_inici=" + data_inici + ", nom_monitor=" + nom_monitor + ", descripcio=" + descripcio + '}';
    } 
}
