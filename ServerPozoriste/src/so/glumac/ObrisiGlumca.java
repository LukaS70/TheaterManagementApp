/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.glumac;

import domen.Glumac;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class ObrisiGlumca extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return databaseBroker.obrisi((Glumac) entity);
    }
    
}
