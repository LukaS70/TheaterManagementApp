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
public class Glumac_Predstava implements IGeneralObjectSelect,IGeneralObjectInsert,IGeneralObjectDelete{
    private int glumacID;
    private int predstavaID;

    public Glumac_Predstava() {
    }

    public Glumac_Predstava(int glumacID, int predstavaID) {
        this.glumacID = glumacID;
        this.predstavaID = predstavaID;
    }

    public int getGlumacID() {
        return glumacID;
    }

    public void setGlumacID(int glumacID) {
        this.glumacID = glumacID;
    }

    public int getPredstavaID() {
        return predstavaID;
    }

    public void setPredstavaID(int predstavaID) {
        this.predstavaID = predstavaID;
    }

    @Override
    public String getTableNameG() {
        return "glumac_predstava";
    }

    @Override
    public int getAttNum() {
        return 2;
    }

    @Override
    public void setGeneralObject(IGeneralObjectSelect obj) {
        obj = new Glumac_Predstava(); 
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
        return "predstavaID"; 
    }

    @Override
    public String getId() {
       StringBuilder sb = new StringBuilder();
       sb.append(this.predstavaID);
       return sb.toString(); 
    }

    @Override
    public String getTableName() {
        return "glumac_predstava";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "glumacID,predstavaID"; 
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(this.glumacID).append("',")
                .append("'").append(this.predstavaID).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        this.glumacID = id;
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
    
}
