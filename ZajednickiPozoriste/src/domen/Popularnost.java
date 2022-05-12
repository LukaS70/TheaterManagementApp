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
public class Popularnost implements IGeneralObjectSelect{
    
    private int popularnostID;
    private String tipPopularnosti;

    public Popularnost() {
    }

    public Popularnost(int popularnostID, String tipPopularnosti) {
        this.popularnostID = popularnostID;
        this.tipPopularnosti = tipPopularnosti;
    }

    public int getPopularnostID() {
        return popularnostID;
    }

    public void setPopularnostID(int popularnostID) {
        this.popularnostID = popularnostID;
    }

    public String getTipPopularnosti() {
        return tipPopularnosti;
    }

    public void setTipPopularnosti(String tipPopularnosti) {
        this.tipPopularnosti = tipPopularnosti;
    }

    @Override
    public String getTableNameG() {
        return "popularnost";
    }

    @Override
    public int getAttNum() {
        return 2;
    }

    @Override
    public void setGeneralObject(IGeneralObjectSelect obj) {
        obj = new Popularnost();
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
        return tipPopularnosti;
    }

    
}
