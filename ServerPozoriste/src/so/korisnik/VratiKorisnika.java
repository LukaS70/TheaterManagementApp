/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import domen.Korisnik;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class VratiKorisnika extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
        
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        ResultSet rs = databaseBroker.vratiSve((Korisnik) entity);
        Korisnik kor = (Korisnik)entity;
        ArrayList<Korisnik> korisnici = new ArrayList<>();

        while (rs.next()) {
            Korisnik korisnik = new Korisnik();
            korisnik.setKorisnikID(rs.getInt(1));
            korisnik.setIme(rs.getString(2));
            korisnik.setPrezime(rs.getString(3));
            korisnik.setKorisnickoIme(rs.getString(4));
            korisnik.setSifra(rs.getString(5));

            korisnici.add(korisnik);
        }
        for(Korisnik k: korisnici){
            if(k.getKorisnickoIme().equals(kor.getKorisnickoIme()) && k.getSifra().equals(kor.getSifra()))
                return k;
        }
        return null;
    }
}
