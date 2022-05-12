/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Glumac;
import domen.Korisnik;
import domen.Popularnost;
import domen.Predstava;
import domen.Reziser;
import domen.Zanr;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Luka
 */
public class ObradaKlijentskihZahteva extends Thread{
    
    Socket socket;
    boolean kraj =false;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!kraj) {   
            
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            
            switch (kz.getOperacija()){
                
                case Operacije.VRATI_KORISNIKE:
                    Korisnik prosledjeni = (Korisnik) kz.getParametar();
                    Korisnik provereni = null;
                     {
                        try {
                            provereni = Kontroler.getInstanca().vratiKorisnika(prosledjeni);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(provereni);
                    break;
                
                case Operacije.VRATI_GLUMCE:
                    Glumac g = new Glumac();
                    ArrayList<Glumac> glumci = new ArrayList<>();
                    {
                        try {
                            glumci = Kontroler.getInstanca().vratiGlumce(g);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(glumci);
                    break;
                
                case Operacije.VRATI_POPULARNOST:
                    Popularnost p = new Popularnost();
                    ArrayList<Popularnost> popularnost = new ArrayList<>();    
                    {
                        try {
                            popularnost = Kontroler.getInstanca().vratiPopularnost(p);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    for(Popularnost pop : popularnost){
                        System.out.println(pop.getTipPopularnosti());
                    }
                    so.setOdgovor(popularnost);
                    break;
                    
                case Operacije.KREIRAJ_GLUMCA:
                    Glumac gZaCuvanje = (Glumac) kz.getParametar();
                    Glumac gSacuvan = new Glumac();
                    
                    {
                        try {
                            gSacuvan = Kontroler.getInstanca().kreirajGlumca(gZaCuvanje);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(gSacuvan);
                    break;
                
                case Operacije.ZAPAMTI_GLUMCA:
                    Glumac gZaIzmenu = (Glumac) kz.getParametar();
                    Glumac gIzmenjen = new Glumac();
                    
                    {
                        try {
                            gIzmenjen = Kontroler.getInstanca().zapamtiGlumca(gZaIzmenu);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(gIzmenjen);
                    break;
                    
                case Operacije.NADJI_GLUMCA:
                    String prezime = (String) kz.getParametar();
                    Glumac g1 = new Glumac();
                    g1.setPrezime(prezime);
                    ArrayList<Glumac> glumci1 = new ArrayList<>();
                    {
                        try {
                            glumci1 = Kontroler.getInstanca().nadjiGlumca(g1);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(glumci1);
                    break;
                    
                case Operacije.UCITAJ_GLUMCA:
                    Glumac gZaUcitavanje = (Glumac) kz.getParametar();
                    Glumac gUcitan = new Glumac();
                    {
                        try {
                            gUcitan = Kontroler.getInstanca().ucitajGlumca(gZaUcitavanje);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(gUcitan);
                    break;
                    
                case Operacije.OBRISI_GLUMCA:
                    Glumac gZaBrisanje = (Glumac) kz.getParametar();
                    Glumac gObrisan = new Glumac();
                    {
                        try {
                            gObrisan = Kontroler.getInstanca().obrisiGlumca(gZaBrisanje);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(gObrisan);
                    break;
                    
                case Operacije.VRATI_PREDSTAVE:
                    Predstava pred = new Predstava();
                    ArrayList<Predstava> predstave = new ArrayList<>();
                    {
                        try {
                            predstave = Kontroler.getInstanca().vratiPredstave(pred);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(predstave);
                    break;
                    
                case Operacije.VRATI_LISTU_ZANROVA:
                    Zanr z = new Zanr();
                    ArrayList<Zanr> zanrovi = new ArrayList<>();
                    {
                        try {
                            zanrovi = Kontroler.getInstanca().vratiListuZanrova(z);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(zanrovi);
                    break;
                    
                case Operacije.VRATI_LISTU_REZISERA:
                    Reziser r = new Reziser();
                    ArrayList<Reziser> reziseri = new ArrayList<>();
                    {
                        try {
                            reziseri = Kontroler.getInstanca().vratiListuRezisera(r);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(reziseri);
                    break;
                    
                case Operacije.KREIRAJ_PREDSTAVU:
                    Predstava pZaCuvanje = (Predstava) kz.getParametar();
                    Predstava pSacuvana = new Predstava();
                    
                    {
                        try {
                            pSacuvana = Kontroler.getInstanca().kreirajPredstavu(pZaCuvanje);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(pSacuvana);
                    break;
                
                case Operacije.ZAPAMTI_PREDSTAVU:
                    Predstava pZaIzmenu = (Predstava) kz.getParametar();
                    Predstava pIzmenjena = new Predstava();
                    
                    {
                        try {
                            pIzmenjena = Kontroler.getInstanca().zapamtiPredstavu(pZaIzmenu);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(pIzmenjena);
                    break;
                    
                case Operacije.NADJI_PREDSTAVU:
                    String naziv = (String) kz.getParametar();
                    Predstava p1 = new Predstava();
                    p1.setNazivPredstave(naziv);
                    ArrayList<Predstava> predstave1 = new ArrayList<>();
                    {
                        try {
                            predstave1 = Kontroler.getInstanca().nadjiPredstavu(p1);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(predstave1);
                    break;
                    
                case Operacije.UCITAJ_PREDSTAVU:
                    Predstava pZaUcitavanje = (Predstava) kz.getParametar();
                    Predstava pUcitana = new Predstava();
                    {
                        try {
                            pUcitana = Kontroler.getInstanca().ucitajPredstavu(pZaUcitavanje);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(pUcitana);
                    break;
                    
                case Operacije.OBRISI_PREDSTAVU:
                    Predstava pZaBrisanje = (Predstava) kz.getParametar();
                    Predstava pObrisana = new Predstava();
                    {
                        try {
                            pObrisana = Kontroler.getInstanca().obrisiPredstavu(pZaBrisanje);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    so.setOdgovor(pObrisana);
                    break;
            }
            
            posaljiOdgovor(so);
        }
    }
    
    private KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            kraj = true;
            //Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Klijent se otkacio");
        } catch (ClassNotFoundException ex) {
            kraj = true;
            //Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Klijent se otkacio");
        }
        return kz;
    }

    public void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            //Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
