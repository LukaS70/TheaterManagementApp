/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.glumac;

import domen.Glumac;
import domen.Popularnost;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import logika.Kontroler;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class UcitajGlumca extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
        
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        ResultSet rs = databaseBroker.ucitaj((Glumac) entity);
        Glumac g = new Glumac();
        
        while(rs.next()){
           // Glumac g = new Glumac();
            g.setGlumacID(rs.getInt(1));
            g.setIme(rs.getString(2));
            g.setPrezime(rs.getString(3));
            g.setPol(rs.getString(4));
            g.setAdresa(rs.getString(5));
            g.setDatumRodjenja(new Date(rs.getDate(6).getTime()));
            g.setOpis(rs.getString(7));
            
            Popularnost pop = new Popularnost();
            ArrayList<Popularnost> popularnosti = Kontroler.getInstanca().vratiPopularnost(pop);
            for(Popularnost p:popularnosti){
                if(p.getPopularnostID()==rs.getInt(8)){
                    pop = p;
                }
            }
            g.setPopularnost(pop);
            
            
        }
        
        return g;
    
    }
    
}
