/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.ArrayList;

/**
 *
 * @author Luka
 */
public class Predstava implements IGeneralObjectDelete,IGeneralObjectInsert,IGeneralObjectSelect,IGeneralObjectUpdate{
    
    private int predstavaID;
    private String nazivPredstave;
    private int trajanjePredstave;
    private String opisPredstave;
    private Reziser reziser;
    private Zanr zanr;
    private ArrayList<Glumac> glumci;

    public Predstava() {
    }

    public Predstava(int predstavaID, String nazivPredstave, int trajanjePredstave, String opisPredstave, Reziser reziser, Zanr zanr, ArrayList<Glumac> glumci) {
        this.predstavaID = predstavaID;
        this.nazivPredstave = nazivPredstave;
        this.trajanjePredstave = trajanjePredstave;
        this.opisPredstave = opisPredstave;
        this.reziser = reziser;
        this.zanr = zanr;
        this.glumci = glumci;
    }

    public int getPredstavaID() {
        return predstavaID;
    }

    public void setPredstavaID(int predstavaID) {
        this.predstavaID = predstavaID;
    }

    public String getNazivPredstave() {
        return nazivPredstave;
    }

    public void setNazivPredstave(String nazivPredstave) {
        this.nazivPredstave = nazivPredstave;
    }

    public int getTrajanjePredstave() {
        return trajanjePredstave;
    }

    public void setTrajanjePredstave(int trajanjePredstave) {
        this.trajanjePredstave = trajanjePredstave;
    }

    public String getOpisPredstave() {
        return opisPredstave;
    }

    public void setOpisPredstave(String opisPredstave) {
        this.opisPredstave = opisPredstave;
    }

    public Reziser getReziser() {
        return reziser;
    }

    public void setReziser(Reziser reziser) {
        this.reziser = reziser;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public ArrayList<Glumac> getGlumci() {
        return glumci;
    }

    public void setGlumci(ArrayList<Glumac> glumci) {
        this.glumci = glumci;
    }

    @Override
    public String getTableName() {
        return "predstava";
    }

    @Override
    public String getColumnNameForDelete() {
        return "predstavaID";
    }

    @Override
    public String getDeletedValue() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.predstavaID);
        return sb.toString();
    }

    @Override
    public String getColumnNamesForInsert() {
        return "nazivPredstave,trajanjePredstave,opisPredstave,reziserID,zanrID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(this.nazivPredstave).append("',")
                .append(this.trajanjePredstave).append(",")
                .append("'").append(this.opisPredstave).append("',")
                .append(this.getReziser().getReziserID()).append(",")
                .append(this.getZanr().getZanrID());
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        this.predstavaID = id;
    }

    @Override
    public String getTableNameG() {
        return "predstava";
    }

    @Override
    public int getAttNum() {
        return 6;
    }

    @Override
    public void setGeneralObject(IGeneralObjectSelect obj) {
        obj = new Predstava();
    }

    @Override
    public String getColumnNameForUpdate() {
        return "nazivPredstave,trajanjePredstave,opisPredstave,reziserID,zanrID";
    }

    @Override
    public String getUpdateValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(this.nazivPredstave).append("',")
                .append(this.trajanjePredstave).append(",")
                .append("'").append(this.opisPredstave).append("',")
                .append(this.getReziser().getReziserID()).append(",")
                .append(this.getZanr().getZanrID());
        return sb.toString();
    }

    @Override
    public String getColumnNameForSet() {
        return "predstavaID";
    }

    @Override
    public String getSetValue() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getPredstavaID());
        return sb.toString();
    }

    @Override
    public String getCriteriaRowName() {
        return "nazivPredstave";
    }

    @Override
    public String getCriteriaValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(this.nazivPredstave).append("'");
        return sb.toString();
    }

    @Override
    public String getIdRowName() {
        return "predstavaID";
    }

    @Override
    public String getId() {
       StringBuilder sb = new StringBuilder();
       sb.append(this.predstavaID);
       return sb.toString();//To change body of generated methods, choose Tools | Templates.
    }

}
