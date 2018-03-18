/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana
 */
public class Racun {

    private int racunID;
    private Date datum;
    private List<StavkaRacuna> stavke;

    public Racun() {
    }

    public Racun(int racunID, Date datum, List<StavkaRacuna> stavke) {
        this.racunID = racunID;
        this.datum = datum;
        this.stavke = stavke;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Racun{" + "racunID=" + racunID + ", datum=" + datum + ", stavke=" + stavke + '}';
    }

}
