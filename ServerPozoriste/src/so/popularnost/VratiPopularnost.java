/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.popularnost;

import domen.Popularnost;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class VratiPopularnost extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        ResultSet rs = databaseBroker.vratiSve((Popularnost) entity);
        ArrayList<Popularnost> popularnosti = new ArrayList<>();
        
        while(rs.next()){
            Popularnost pop = new Popularnost();
            pop.setPopularnostID(rs.getInt(1));
            pop.setTipPopularnosti(rs.getString(2));
            popularnosti.add(pop);
        }
        
        return popularnosti;
    }
    
}
