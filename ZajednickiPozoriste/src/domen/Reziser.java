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
public class Reziser implements IGeneralObjectSelect{
    
    private int reziserID;
    private String imeRezisera;
    private String prezimeRezisera;

    public Reziser() {
    }

    public Reziser(int reziserID, String imeRezisera, String prezimeRezisera) {
        this.reziserID = reziserID;
        this.imeRezisera = imeRezisera;
        this.prezimeRezisera = prezimeRezisera;
    }

    public int getReziserID() {
        return reziserID;
    }

    public void setReziserID(int reziserID) {
        this.reziserID = reziserID;
    }

    public String getImeRezisera() {
        return imeRezisera;
    }

    public void setImeRezisera(String imeRezisera) {
        this.imeRezisera = imeRezisera;
    }

    public String getPrezimeRezisera() {
        return prezimeRezisera;
    }

    public void setPrezimeRezisera(String prezimeRezisera) {
        this.prezimeRezisera = prezimeRezisera;
    }

    @Override
    public String toString() {
        return imeRezisera+" "+prezimeRezisera; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableNameG() {
        return "reziser";
    }

    @Override
    public int getAttNum() {
        return 3;
    }

    @Override
    public void setGeneralObject(IGeneralObjectSelect obj) {
        obj = new Reziser();
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
