/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Proizvod;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovana
 */
public class DBBroker {

    private Connection connection;

    public void uspostavljanjeKonekcije() throws Exception {
        try {
            Class.forName(Util.getInstance().getDriver());
        } catch (IOException ex) {
            throw new Exception("Greska prilikom ucitavanja drajvera! " + ex.getMessage());
        }

        try {
            String url = Util.getInstance().getUrl();
            String user = Util.getInstance().getUser();
//            String password = Util.getInstance().getPassword();
            connection = DriverManager.getConnection(url, user, "");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new Exception("Nije uspostavljena konekcija sa bazom! " + ex.getMessage());
        }
    }

    public void raskidanjeKonekcije() throws Exception {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Konekcija uspesno raskinuta!");
            } catch (SQLException ex) {
                throw new Exception("Greska prilikom raskidanja konekcije! " + ex.getMessage());
            }
        } else {
            throw new Exception("Greska prilikom raskidanja konekcije. Konekcija nije ni bila uspostavljena!");
        }
    }

    public void potvrdjivanjeTransakcije() throws Exception {
        try {
            connection.commit();
            System.out.println("Transakcija potvrdjena!");
        } catch (SQLException ex) {
            throw new Exception("Greska prilikom potvrdjivanja transakcije! " + ex.getMessage());
        }
    }

    public void ponistavanjeTransakcije() throws Exception {
        try {
            connection.rollback();
            System.out.println("Transakcija uspesno ponistena!");
        } catch (SQLException ex) {
            throw new Exception("Transakcija nije uspesno ponistena! " + ex.getMessage());
        }
    }

    public void ubaciProizvod(Proizvod p) throws Exception {
        String upit = "INSERT INTO proizvod(proizvodID,naziv,cena) VALUES(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1, p.getProizvodID());
            ps.setString(2, p.getNaziv());
            ps.setDouble(3, p.getCena());

            ps.executeUpdate();
            ps.close();

            System.out.println("Uspesno ubacen novi proizvod!");
        } catch (SQLException ex) {
            throw new Exception("Proizvod nije uspesno ubacen! " + ex.getMessage());
        }

    }

    public List<Proizvod> vratiSveProizvode() throws Exception {
        List<Proizvod> proizvodi = new LinkedList<>();

        String upit = "SELECT * FROM proizvod";

        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {
                Proizvod p = new Proizvod(rs.getInt("proizvodID"), rs.getString("naziv"), rs.getDouble("cena"));
                proizvodi.add(p);
            }
            rs.close();
            s.close();
            System.out.println(proizvodi);
            return proizvodi;
        } catch (SQLException ex) {
            throw new Exception("Nisu uspesno izlistani proizvodi! " + ex.getMessage());
        }
    }

}
