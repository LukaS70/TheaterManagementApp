/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Predstava;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luka
 */
public class ModelTabelePredstave extends AbstractTableModel{

    ArrayList<Predstava> lista;

    public ModelTabelePredstave() {
    }

    public ModelTabelePredstave(ArrayList<Predstava> lista) {
        this.lista = lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predstava p = lista.get(rowIndex);
        switch(columnIndex){
            case 0:return p.getNazivPredstave();
            case 1:return p.getTrajanjePredstave();
            case 2:return p.getOpisPredstave();
            case 3:return p.getReziser().toString();
            case 4:return p.getZanr().getNazivZanra();
            default:return "";
        }
    }
    
     public String getColumnName(int column) {
        switch(column){
            case 0:return "Naziv";
            case 1:return "Trajanje";
            case 2:return "Opis";
            case 3:return "Reziser";
            case 4:return "Zanr";
            default:return "";
        }
    }
     
     public Predstava dajPredstavu(int red) {
        if(red == -1){
            return null;
        }
        return lista.get(red);
    }
    
}
