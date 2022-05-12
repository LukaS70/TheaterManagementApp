/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Luka
 */
public class KomunikacijaSaServerom {
    
    private static KomunikacijaSaServerom instanca;
    Socket s;

    private KomunikacijaSaServerom() {
    }
    
    public static KomunikacijaSaServerom getInstanca() {
        if(instanca == null){
            instanca = new KomunikacijaSaServerom();
        }
        return instanca;
    }
    
    public void poveziSeNaServer(String adresa, int port) {
        try {
            s = new Socket(adresa, port);
        } catch (IOException ex) {
            //Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Postoji problem sa serverom", "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void posaljiZahtev(KlijentskiZahtev kz){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            //Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Postoji problem sa serverom", "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
    }
    
    public ServerskiOdgovor primiOdgovor(){
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
        } catch (IOException ex) {
            //Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Postoji problem sa serverom", "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Postoji problem sa serverom", "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            
        }
        return so;
    }
}
