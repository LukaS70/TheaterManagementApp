/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.reziser;

import domen.Reziser;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class VratiListuRezisera extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
        
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        ResultSet rs = databaseBroker.vratiSve((Reziser) entity);
        ArrayList<Reziser> reziseri = new ArrayList<>();
        
        while(rs.next()){
            Reziser rez = new Reziser();
            rez.setReziserID(rs.getInt(1));
            rez.setImeRezisera(rs.getString(2));
            rez.setPrezimeRezisera(rs.getString(3));
            reziseri.add(rez);
        }
        
        return reziseri;
    }
    
}
