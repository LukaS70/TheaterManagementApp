/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Luka
 */
public class Korisnik implements IGeneralObjectSelect{
    
    private int korisnikID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String ime, String prezime, String korisnickoIme, String sifra) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String getTableNameG() {
        return "korisnik";
    }

    @Override
    public int getAttNum() {
        return 5;
    }

    @Override
    public void setGeneralObject(IGeneralObjectSelect obj) {
        obj = new Korisnik();
    }

    @Override
    public String getCriteriaRowName() {
        return "";
    }

    @Override
    public String getCriteriaValue() {
        return "";
    }

    @Override
    public String getIdRowName() {
        return "";
    }

    @Override
    public String getId() {
        return "";
    }

}
