/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.DBBroker;
import domen.Proizvod;
import java.util.List;

/**
 *
 * @author Jovana
 */
public class Kontroler {
    //necemo da dopustimo da nam Forma direktno komunicira sa DBBrokerom -> Kontroler

    //pravimo instancu DBBrokera u konstruktoru Kontrolera
    private DBBroker broker;

    public Kontroler() {
        broker = new DBBroker();
    }

    public void kreirajProizvod(Proizvod p) throws Exception {
        try {
            broker.uspostavljanjeKonekcije();
        } catch (Exception ex) {
            throw new Exception("Konekcija nije uspesno uspostavljena! " + ex.getMessage());
        }
        try {
            broker.ubaciProizvod(p);
            broker.potvrdjivanjeTransakcije();

        } catch (Exception ex) {
            broker.ponistavanjeTransakcije();
            throw new Exception("Proizvod nije uspesno ubacen! " + ex.getMessage());
        } finally {
            broker.raskidanjeKonekcije();
        }
    }

    public List<Proizvod> vratiSveProizvode() throws Exception {
        List<Proizvod> proizvodi = null;
        try {
            broker.uspostavljanjeKonekcije();
        } catch (Exception ex) {
            throw new Exception("Konekcija nije uspesno uspostavljena! " + ex.getMessage());
        }
        try {
            broker.vratiSveProizvode();
            broker.potvrdjivanjeTransakcije();

        } catch (Exception ex) {
            broker.ponistavanjeTransakcije();
            throw new Exception("Proizvodi nisu uspesno izlistani! " + ex.getMessage());
        } finally {
            broker.raskidanjeKonekcije();
        }
        return proizvodi;
    }
    
    public void sacuvajProizvode(List<Proizvod> proizvodi) throws Exception{
        try {
            broker.uspostavljanjeKonekcije();
        } catch (Exception ex) {
            throw new Exception("Konekcija nije uspesno uspostavljena! " + ex.getMessage());
        }
        try {
            for (Proizvod p : proizvodi) {
                broker.ubaciProizvod(p);
            }
            broker.potvrdjivanjeTransakcije();

        } catch (Exception ex) {
            broker.ponistavanjeTransakcije();
            throw new Exception("Proizvodi nisu uspesno sacuvani! " + ex.getMessage());
        } finally {
            broker.raskidanjeKonekcije();
        }
    }
}
