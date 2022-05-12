/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predstava;

import domen.Glumac;
import domen.Glumac_Predstava;
import domen.Predstava;
import domen.Reziser;
import domen.Zanr;
import java.sql.ResultSet;
import java.util.ArrayList;
import logika.Kontroler;
import so.AbstractGenericOperation;

/**
 *
 * @author Luka
 */
public class NadjiPredstavu extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
        
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        ResultSet rs = databaseBroker.pretrazi((Predstava) entity);
        ArrayList<Predstava> predstave = new ArrayList<>();
        
        ResultSet rs2 = databaseBroker.vratiSve(new Glumac_Predstava());
        ArrayList<Glumac_Predstava> gplista = new ArrayList<>();
        
        ArrayList<Glumac> glumciZaPred = new ArrayList<>();
        
        while (rs2.next()) {            
            Glumac_Predstava gp = new Glumac_Predstava();
            gp.setGlumacID(rs2.getInt(1));
            gp.setPredstavaID(rs2.getInt(2));
            
            gplista.add(gp);
        }
        
        while(rs.next()){
            Predstava p = new Predstava();
            p.setPredstavaID(rs.getInt(1));
            p.setNazivPredstave(rs.getString(2));
            p.setTrajanjePredstave(rs.getInt(3));
            p.setOpisPredstave(rs.getString(4));
            
            Reziser rez = new Reziser();
            ArrayList<Reziser> reziseri = Kontroler.getInstanca().vratiListuRezisera(rez);
            for(Reziser r:reziseri){
                if(r.getReziserID()==rs.getInt(5)){
                    rez = r;
                }
            }
            p.setReziser(rez);
            
            Zanr zanr = new Zanr();
            ArrayList<Zanr> zanrovi = Kontroler.getInstanca().vratiListuZanrova(zanr);
            for(Zanr z:zanrovi){
                if(z.getZanrID()==rs.getInt(6)){
                    zanr = z;
                }
            }
            p.setZanr(zanr);
            
            ArrayList<Glumac> glumci = Kontroler.getInstanca().vratiGlumce(new Glumac());
            for (Glumac g : glumci) {
                for (Glumac_Predstava gp : gplista) {
                    if(gp.getGlumacID() == g.getGlumacID() && gp.getPredstavaID() == p.getPredstavaID()){
                        glumciZaPred.add(g);
                    }
                }
            }
            
            p.setGlumci(glumciZaPred);
            
            predstave.add(p);
        }
        
        //glumci??????
        
        return predstave;
    }
    
}
