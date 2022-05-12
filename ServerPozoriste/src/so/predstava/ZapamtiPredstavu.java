/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predstava;

import domen.Glumac;
import domen.Glumac_Predstava;
import domen.Predstava;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class ZapamtiPredstavu extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
       
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        Predstava p = (Predstava) databaseBroker.izmeni((Predstava) entity);
        Glumac_Predstava gpq = new Glumac_Predstava();
        gpq.setPredstavaID(p.getPredstavaID());
        ResultSet rs2 = databaseBroker.ucitaj(gpq);
        
        while (rs2.next()) {            
            Glumac_Predstava gp = new Glumac_Predstava();
            gp.setGlumacID(rs2.getInt(1));
            gp.setPredstavaID(rs2.getInt(2));
            
            if(gp.getPredstavaID()==p.getPredstavaID()){
                databaseBroker.obrisi(gp);
            }
        }
        
        for(Glumac g : p.getGlumci()) {
            Glumac_Predstava gp = new Glumac_Predstava(g.getGlumacID(), p.getPredstavaID());
            databaseBroker.ubaciGP(gp);    
        }
        
        return p;
    }
    
}
