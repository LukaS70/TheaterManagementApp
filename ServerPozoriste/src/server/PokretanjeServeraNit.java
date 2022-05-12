/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forme.formaServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luka
 */
public class PokretanjeServeraNit extends Thread{
    
    formaServer forma;
    Socket s = new Socket();
    
    public PokretanjeServeraNit(formaServer forma) {
        this.forma = forma;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            forma.pokrenut();
            System.out.println("Server je pokrenut");
            NitZaZatvaranje nz = new NitZaZatvaranje(ss, this);
            nz.start();
            while(!isInterrupted()) {
                s = ss.accept();
                System.out.println("Klijent se nakacio");
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                okz.start();
            }
        } catch (IOException ex) {
            forma.zaustavljen();
            try {
                s.close();
            } catch (IOException ex1) {
                
            }
            
            System.out.println("Server je zaustavljen");
        }
    }
}
