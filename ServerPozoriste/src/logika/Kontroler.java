/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Glumac;
import domen.Korisnik;
import domen.Popularnost;
import domen.Predstava;
import domen.Reziser;
import domen.Zanr;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractGenericOperation;
import so.glumac.KreirajGlumca;
import so.glumac.NadjiGlumca;
import so.glumac.ObrisiGlumca;
import so.glumac.UcitajGlumca;
import so.glumac.VratiGlumce;
import so.glumac.ZapamtiGlumca;
import so.korisnik.VratiKorisnika;
import so.popularnost.VratiPopularnost;
import so.predstava.KreirajPredstavu;
import so.predstava.NadjiPredstavu;
import so.predstava.ObrisiPredstavu;
import so.predstava.UcitajPredstavu;
import so.predstava.VratiPredstave;
import so.predstava.ZapamtiPredstavu;
import so.reziser.VratiListuRezisera;
import so.zanr.VratiListuZanrova;

/**
 *
 * @author Luka
 */
public class Kontroler {
    
    private static Kontroler instanca;

    private Kontroler() {
        
    }
    
    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }
    
    public Glumac kreirajGlumca(Glumac entity) throws Exception {
        AbstractGenericOperation kreirajGlumca = new KreirajGlumca();
        return (Glumac) kreirajGlumca.execute(entity);
    }
    
    public Predstava kreirajPredstavu(Predstava entity) throws Exception {
        AbstractGenericOperation kreirajPredstavu = new KreirajPredstavu();
        return (Predstava) kreirajPredstavu.execute(entity);
    }
    
    public Glumac zapamtiGlumca(Glumac entity) throws Exception {
        AbstractGenericOperation zapamtiGlumca = new ZapamtiGlumca();
        return (Glumac) zapamtiGlumca.execute(entity);
    }
    
    public Predstava zapamtiPredstavu(Predstava entity) throws Exception {
        AbstractGenericOperation zapamtiPredstavu = new ZapamtiPredstavu();
        return (Predstava) zapamtiPredstavu.execute(entity);
    }
    
    public Glumac obrisiGlumca(Glumac entity) throws Exception {
        AbstractGenericOperation obrisiGlumca = new ObrisiGlumca();
        return (Glumac) obrisiGlumca.execute(entity);
    }
    
    public Predstava obrisiPredstavu(Predstava entity) throws Exception {
        AbstractGenericOperation obrisiPredstavu = new ObrisiPredstavu();
        return (Predstava) obrisiPredstavu.execute(entity);
    }
    
    public ArrayList<Popularnost> vratiPopularnost(Popularnost entity) throws Exception {
        AbstractGenericOperation vratiPopularnost = new VratiPopularnost();
        return (ArrayList<Popularnost>) vratiPopularnost.execute(entity);
    }
    
    public ArrayList<Zanr> vratiListuZanrova(Zanr entity) throws Exception {
        AbstractGenericOperation vratiListuZanrova = new VratiListuZanrova();
        return (ArrayList<Zanr>) vratiListuZanrova.execute(entity);
    }
    
    public ArrayList<Reziser> vratiListuRezisera(Reziser entity) throws Exception {
        AbstractGenericOperation vratiListuRezisera = new VratiListuRezisera();
        return (ArrayList<Reziser>) vratiListuRezisera.execute(entity);
    }
    
    public ArrayList<Glumac> vratiGlumce(Glumac entity) throws Exception {
        AbstractGenericOperation vratiGlumce = new VratiGlumce();
        return (ArrayList<Glumac>) vratiGlumce.execute(entity);
    }
    
    public ArrayList<Predstava> vratiPredstave(Predstava entity) throws Exception {
        AbstractGenericOperation vratiPredstave = new VratiPredstave();
        return (ArrayList<Predstava>) vratiPredstave.execute(entity);
    }
    
    public ArrayList<Glumac> nadjiGlumca(Glumac entity) throws Exception {
        AbstractGenericOperation nadjiGlumca = new NadjiGlumca();
        return (ArrayList<Glumac>) nadjiGlumca.execute(entity);
    }
    
    public ArrayList<Predstava> nadjiPredstavu(Predstava entity) throws Exception {
        AbstractGenericOperation nadjiPredstavu = new NadjiPredstavu();
        return (ArrayList<Predstava>) nadjiPredstavu.execute(entity);
    }
    
    public Glumac ucitajGlumca(Glumac entity) throws Exception {
        AbstractGenericOperation ucitajGlumca = new UcitajGlumca();
        return (Glumac) ucitajGlumca.execute(entity);
    }
    
    public Predstava ucitajPredstavu(Predstava entity) throws Exception {
        AbstractGenericOperation ucitajPredstavu = new UcitajPredstavu();
        return (Predstava) ucitajPredstavu.execute(entity);
    }
    
    public Korisnik vratiKorisnika(Korisnik entity) throws Exception {
        AbstractGenericOperation vratiKorisnika = new VratiKorisnika();
        return (Korisnik) vratiKorisnika.execute(entity);
    }
}
