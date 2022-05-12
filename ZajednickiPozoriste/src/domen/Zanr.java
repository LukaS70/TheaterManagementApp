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
public class Zanr implements IGeneralObjectSelect{
    
    private int zanrID;
    private String nazivZanra;
    private String opisZanra;

    public Zanr() {
    }

    public Zanr(int zanrID, String nazivZanra, String opisZanra) {
        this.zanrID = zanrID;
        this.nazivZanra = nazivZanra;
        this.opisZanra = opisZanra;
    }

    public int getZanrID() {
        return zanrID;
    }

    public void setZanrID(int zanrID) {
        this.zanrID = zanrID;
    }

    public String getNazivZanra() {
        return nazivZanra;
    }

    public void setNazivZanra(String nazivZanra) {
        this.nazivZanra = nazivZanra;
    }

    public String getOpisZanra() {
        return opisZanra;
    }

    public void setOpisZanra(String opisZanra) {
        this.opisZanra = opisZanra;
    }

    @Override
    public String getTableNameG() {
        return "zanr";
    }

    @Override
    public int getAttNum() {
        return 3;
    }

    @Override
    public void setGeneralObject(IGeneralObjectSelect obj) {
        obj = new Zanr();
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

    @Override
    public String toString() {
        return nazivZanra;
    }
    
}
