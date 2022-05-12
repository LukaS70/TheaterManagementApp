/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Glumac;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luka
 */
public class ModelTabeleGlumci extends AbstractTableModel{

    ArrayList<Glumac> lista;

    public ModelTabeleGlumci(ArrayList<Glumac> lista) {
        this.lista = lista;
    }

    public ModelTabeleGlumci() {
        lista = new ArrayList<>();
    }
    
    
    
    @Override
    public int getRowCount() {
       return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Glumac g = lista.get(rowIndex);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String datum = df.format(g.getDatumRodjenja());
        switch(columnIndex){
            case 0:return g.getIme();
            case 1:return g.getPrezime();
            case 2:return g.getPol();
            case 3:return g.getAdresa();
            case 4:return datum;
            case 5:return g.getOpis();
            case 6:return g.getPopularnost().getTipPopularnosti();
            default:return "";
        }
    }
    
     public String getColumnName(int column) {
        switch(column){
            case 0:return "Ime";
            case 1:return "Prezime";
            case 2:return "Pol";
            case 3:return "Adresa";
            case 4:return "Datum rodjenja";
            case 5:return "Opis";
            case 6:return "Popularnost";
            default:return "";
        }
    }
     
    public Glumac dajGlumca(int red) {
        if(red == -1){
            return null;
        }
        return lista.get(red);
    }
    
    public void dodajUTabelu(Glumac g){
//        if(lista.contains(g)){
//            return;
//        }
        for (Glumac glum : lista) {
            if(glum.getGlumacID() == g.getGlumacID()){
                return;
            }
        }
        lista.add(g);
        fireTableDataChanged();
    }
    
    public void izbaciIzTabele(Glumac g){
        lista.remove(g);
        fireTableDataChanged();
    }
    
    public ArrayList<Glumac> vratiGlumceIzTabele(){
        return lista;
    }
}
