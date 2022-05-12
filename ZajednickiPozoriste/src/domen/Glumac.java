/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author Luka
 */
public class Glumac implements IGeneralObjectDelete,IGeneralObjectInsert,IGeneralObjectSelect, IGeneralObjectUpdate{
    
    private int glumacID;
    private String ime;
    private String prezime;
    private String pol;
    private String adresa;
    private Date datumRodjenja;
    private String opis;
    private Popularnost popularnost;

    public Glumac() {
    }

    public Glumac(int glumacID, String ime, String prezime, String pol, String adresa, Date datumRodjenja, String opis, Popularnost popularnost) {
        this.glumacID = glumacID;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.adresa = adresa;
        this.datumRodjenja = datumRodjenja;
        this.opis = opis;
        this.popularnost = popularnost;
    }

    public int getGlumacID() {
        return glumacID;
    }

    public void setGlumacID(int glumacID) {
        this.glumacID = glumacID;
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

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Popularnost getPopularnost() {
        return popularnost;
    }

    public void setPopularnost(Popularnost popularnost) {
        this.popularnost = popularnost;
    }

    @Override
    public String toString() {
        return ime+" "+prezime; 
    }

    @Override
    public String getTableName() {
        return "glumac";
    }

    @Override
    public String getColumnNameForDelete() {
        return "glumacID";
    }

    @Override
    public String getDeletedValue() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.glumacID);
        return sb.toString();
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime,prezime,pol,adresa,datumRodjenja,opis,popularnostID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(this.ime).append("',")
                .append("'").append(this.prezime).append("',")
                .append("'").append(this.pol).append("',")
                .append("'").append(this.adresa).append("',")
                .append("'").append(new java.sql.Date(this.datumRodjenja.getTime())).append("',")
                .append("'").append(this.opis).append("',")
                .append(this.getPopularnost().getPopularnostID());
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        this.glumacID = id;
    }

    @Override
    public String getTableNameG() {
        return "glumac";
    }

    @Override
    public int getAttNum() {
        return 8;
    }

    @Override
    public void setGeneralObject(IGeneralObjectSelect obj) {
        obj = new Glumac();
    }

    @Override
    public String getColumnNameForUpdate() {
        return "ime,prezime,pol,adresa,datumRodjenja,opis,popularnostID";
    }

    @Override
    public String getUpdateValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(this.ime).append("',")
                .append("'").append(this.prezime).append("',")
                .append("'").append(this.pol).append("',")
                .append("'").append(this.adresa).append("',")
                .append("'").append(new java.sql.Date(this.datumRodjenja.getTime())).append("',")
                .append("'").append(this.opis).append("',")
                .append(this.getPopularnost().getPopularnostID());
        return sb.toString();
    }

    @Override
    public String getColumnNameForSet() {
        return "glumacID";
    }

    @Override
    public String getSetValue() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getGlumacID());
        return sb.toString();
    }  

    @Override
    public String getCriteriaRowName() {
        return "prezime"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCriteriaValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(this.prezime).append("'");
        return sb.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdRowName() {
        return "glumacID"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
       StringBuilder sb = new StringBuilder();
       sb.append(this.glumacID);
       return sb.toString();//To change body of generated methods, choose Tools | Templates.
    }
    
}
