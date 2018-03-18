/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Jovana
 */
public class StavkaRacuna {

    private Racun racun;
    private int rb;
    private Proizvod proizvod;
    private int kolicina;

    public StavkaRacuna() {
    }

    public StavkaRacuna(Racun racun, int rb, Proizvod proizvod, int kolicina) {
        this.racun = racun;
        this.rb = rb;
        this.proizvod = proizvod;
        this.kolicina = kolicina;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @Override
    public String toString() {
        return "StavkaRacuna{" + "racun=" + racun + ", rb=" + rb + ", proizvod=" + proizvod + ", kolicina=" + kolicina + '}';
    }

}
