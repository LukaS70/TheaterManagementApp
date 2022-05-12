/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zanr;

import domen.Zanr;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class VratiListuZanrova extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
        
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        ResultSet rs = databaseBroker.vratiSve((Zanr) entity);
        ArrayList<Zanr> zanrovi = new ArrayList<>();
        
        while(rs.next()){
            Zanr z = new Zanr();
            z.setZanrID(rs.getInt(1));
            z.setNazivZanra(rs.getString(2));
            z.setOpisZanra(rs.getString(3));
            zanrovi.add(z);
        }
        
        return zanrovi;
    }
    
}
