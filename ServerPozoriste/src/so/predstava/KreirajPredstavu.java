/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predstava;

import domen.Glumac;
import domen.Glumac_Predstava;
import domen.Predstava;
import java.util.ArrayList;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class KreirajPredstavu extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        
        Predstava p = (Predstava) databaseBroker.ubaci((Predstava) entity);
        for(Glumac g : p.getGlumci()) {
            Glumac_Predstava gp = new Glumac_Predstava(g.getGlumacID(), p.getPredstavaID());
            databaseBroker.ubaciGP(gp);    
        }
       
        return p;
        
    }
    
}
