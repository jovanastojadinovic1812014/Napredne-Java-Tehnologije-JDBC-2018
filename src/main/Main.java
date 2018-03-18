/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domen.Proizvod;
import java.util.LinkedList;
import java.util.List;
import logic.Kontroler;

/**
 *
 * @author Jovana
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Kontroler k = new Kontroler();
        Proizvod p = new Proizvod(144, "laptop", 100000);
        Proizvod p1 = new Proizvod(15, "laptop", 110000);
        Proizvod p2 = new Proizvod(16, "laptop", 120000);
        List<Proizvod> proizvodi = new LinkedList<>();
        proizvodi.add(p);
        proizvodi.add(p1);
        proizvodi.add(p2);

        k.sacuvajProizvode(proizvodi);
    }
}
