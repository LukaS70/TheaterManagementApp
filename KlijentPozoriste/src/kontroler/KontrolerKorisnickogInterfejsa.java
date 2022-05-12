/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Glumac;
import domen.Korisnik;
import domen.Popularnost;
import domen.Predstava;
import domen.Reziser;
import domen.Zanr;
import forme.formaGlumci;
import forme.formaIzmeniGlumca;
import forme.formaIzmeniPredstavu;
import forme.formaLogin;
import forme.formaMain;
import forme.formaObrisiGlumca;
import forme.formaObrisiPredstavu;
import forme.formaPredstave;
import forme.formaUbaciPredstavu;
import forme.formaUbaciiGlumca;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import konstante.Operacije;
import static kontroler.KontrolerKorisnickogInterfejsa.formaIzmeniGlumca;
import static kontroler.KontrolerKorisnickogInterfejsa.formaObrisiGlumca;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Luka
 */
public class KontrolerKorisnickogInterfejsa {
    
    public static formaLogin formaLogin;
    public static formaMain formaMain;
    public static formaGlumci formaGlumci;
    public static formaPredstave formaPredstave;
    public static formaUbaciiGlumca formaUbaciGlumca;
    public static formaUbaciPredstavu formaUbaciPredstavu;
    public static formaIzmeniGlumca formaIzmeniGlumca;
    public static formaIzmeniPredstavu formaIzmeniPredstavu;
    public static formaObrisiGlumca formaObrisiGlumca;
    public static formaObrisiPredstavu formaObrisiPredstavu;
    public static Korisnik ulogovaniKorisnik;
   
    private static KontrolerKorisnickogInterfejsa instanca;

    private KontrolerKorisnickogInterfejsa() {
        
    }
    
    public static KontrolerKorisnickogInterfejsa getInstanca() {
        if (instanca == null) {
            instanca = new KontrolerKorisnickogInterfejsa();
        }
        return instanca;
    }

    public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
                                    try {
						KontrolerKorisnickogInterfejsa.formaLogin=new formaLogin();
						KontrolerKorisnickogInterfejsa.formaLogin.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
    }

    public void login(String korisnickoIme, String sifra) {
        
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnickoIme);
        korisnik.setSifra(sifra);
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_KORISNIKE);
        kz.setParametar(korisnik);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        ulogovaniKorisnik = (Korisnik) so.getOdgovor();
        
        if(ulogovaniKorisnik == null){
            JOptionPane.showMessageDialog(formaLogin, "Uneli ste pogresno ime i sifru", "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(formaLogin, "Dobrodosli "+ulogovaniKorisnik.toString(), "", JOptionPane.INFORMATION_MESSAGE);
            pokreniMainFormu();
        }
    }

    public void pokreniMainFormu(){
        formaLogin.dispose();
        formaMain = new formaMain(ulogovaniKorisnik);
        formaMain.setLocationRelativeTo(formaLogin);
        formaMain.setVisible(true);
    }
    
    public ArrayList<Glumac> vratiGlumce(){
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_GLUMCE);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        ArrayList<Glumac> glumci = (ArrayList<Glumac>) so.getOdgovor();
        return glumci;
    }
    
    public void pokreniGlumce() {
        
        ArrayList<Glumac> glumci = vratiGlumce();
        formaMain.dispose();
        formaGlumci = new formaGlumci(glumci);
        formaGlumci.setLocationRelativeTo(formaMain);
        formaGlumci.setVisible(true);
        
    }

    public void pokreniFormuZaUbaciGlumca() {
       // formaGlumci.dispose();
        formaUbaciGlumca = new formaUbaciiGlumca();
        formaUbaciGlumca.setLocationRelativeTo(formaGlumci);
        formaUbaciGlumca.setVisible(true);
    }

    public ArrayList<Popularnost> vratiPopularnost() {
        ArrayList<Popularnost> lista = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_POPULARNOST);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        lista = (ArrayList<Popularnost>) so.getOdgovor();
        return lista;
    }

    public void ubaciGlumca(String ime, String prezime, String pol, String adresa, String datumRodjenja, String opis, Popularnost popularnost) {
        if(ime.isEmpty() || prezime.isEmpty() || pol.isEmpty() || adresa.isEmpty() || datumRodjenja.isEmpty() || opis.isEmpty() || popularnost == null){
            JOptionPane.showMessageDialog(formaUbaciGlumca, "Sva polja moraju biti popunjena!", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Date datum = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        try {
            datum = sdf.parse(datumRodjenja);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(formaUbaciGlumca, "Datum mora biti u formatu dd.MM.yyyy", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        ime = srediString(ime);
        prezime = srediString(prezime);
        adresa = srediString(adresa);
        opis = srediString(opis);
        
        Glumac g = new Glumac();
        g.setIme(ime);
        g.setPrezime(prezime);
        g.setAdresa(adresa);
        g.setPol(pol);
        g.setDatumRodjenja(datum);
        g.setOpis(opis);
        g.setPopularnost(popularnost);
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.KREIRAJ_GLUMCA);
        kz.setParametar(g);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Glumac ubacenGlumac = (Glumac) so.getOdgovor();
        
        if(ubacenGlumac.getGlumacID() != 0){
            JOptionPane.showMessageDialog(formaUbaciGlumca, "Sistem je zapamtio glumca sa id: "+ubacenGlumac.getGlumacID(), "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(formaUbaciGlumca, "Sistem ne moze da zapamti glumca!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        formaUbaciGlumca.dispose();
        //pokreniGlumce();
        formaGlumci.azurirajTabelu(vratiGlumce());
    }

    public void pokreniFormuZaIzmeniGlumca(Glumac g) {
        
        if(g == null){
            JOptionPane.showMessageDialog(formaGlumci, "Morate izabrati glumca za izmenu!", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_GLUMCA);
        kz.setParametar(g);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Glumac glumac = (Glumac) so.getOdgovor();
        
        //formaGlumci.dispose();
        formaIzmeniGlumca = new formaIzmeniGlumca(glumac);
        formaIzmeniGlumca.setLocationRelativeTo(formaGlumci);
        formaIzmeniGlumca.setVisible(true);
    }

    public void izmeniGlumca(String ime, String prezime, String pol, String adresa, String datumRodjenja, String opis, Popularnost popularnost, int id) {
        if(ime.isEmpty() || prezime.isEmpty() || pol.isEmpty() || adresa.isEmpty() || datumRodjenja.isEmpty() || opis.isEmpty() || popularnost == null){
            JOptionPane.showMessageDialog(formaUbaciGlumca, "Sva polja moraju biti popunjena!", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Date datum = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        try {
            datum = sdf.parse(datumRodjenja);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(formaUbaciGlumca, "Datum mora biti u formatu dd.MM.yyyy", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        ime = srediString(ime);
        prezime = srediString(prezime);
        adresa = srediString(adresa);
        opis = srediString(opis);
        
        Glumac g = new Glumac(id, ime, prezime, pol, adresa, datum, opis, popularnost);
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_GLUMCA);
        kz.setParametar(g);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Glumac izmenjenGlumac = (Glumac) so.getOdgovor();
        if(izmenjenGlumac.getGlumacID() != 0){
            JOptionPane.showMessageDialog(formaIzmeniGlumca, "Sistem je zapamtio glumca sa id: "+izmenjenGlumac.getGlumacID(), "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(formaIzmeniGlumca, "Sistem ne moze da zapamti glumca!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        formaIzmeniGlumca.dispose();
        //pokreniGlumce();
        formaGlumci.azurirajTabelu(vratiGlumce());
    }

    public void pokreniFormuZaBrisanjeGlumca(Glumac g) {
        if(g == null){
            JOptionPane.showMessageDialog(formaGlumci, "Morate izabrati glumca za brisanje!", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_GLUMCA);
        kz.setParametar(g);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Glumac glumac = (Glumac) so.getOdgovor();
        
      //  formaGlumci.dispose();
        formaObrisiGlumca = new formaObrisiGlumca(glumac);
        formaObrisiGlumca.setLocationRelativeTo(formaGlumci);
        formaObrisiGlumca.setVisible(true);
    }

    public void obrisiGlumca(Glumac glumac) {
        
        if(glumac == null){
            JOptionPane.showMessageDialog(formaObrisiGlumca, "Greska");
        }
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_GLUMCA);
        kz.setParametar(glumac);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Glumac glumacObrisan = (Glumac) so.getOdgovor();
        
        if(glumacObrisan.getGlumacID() != 0){
            JOptionPane.showMessageDialog(formaObrisiGlumca, "Sistem je obrisao glumca sa id: "+glumacObrisan.getGlumacID(), "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(formaObrisiGlumca, "Sistem ne moze da obrise glumca!" , "", JOptionPane.INFORMATION_MESSAGE);
        }
        formaObrisiGlumca.dispose();
        //pokreniGlumce();
        formaGlumci.azurirajTabelu(vratiGlumce());
    }

    public ArrayList<Glumac> pretraziGlumce(String pretraga) {
      
        KlijentskiZahtev kz = new KlijentskiZahtev();
        if(pretraga.isEmpty()){
            kz.setOperacija(Operacije.VRATI_GLUMCE);
        }else{
            pretraga+='%';
            kz.setOperacija(Operacije.NADJI_GLUMCA);
            kz.setParametar(pretraga);
        }
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        ArrayList<Glumac> glumci = (ArrayList<Glumac>) so.getOdgovor();
        return glumci;
    }

    public void pokreniPredstave() {
        ArrayList<Predstava> predstave = vratiPredstave();
        formaMain.dispose();
        formaPredstave = new formaPredstave(predstave);
        formaPredstave.setLocationRelativeTo(formaMain);
        formaPredstave.setVisible(true);
    }

    private ArrayList<Predstava> vratiPredstave() {
       KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_PREDSTAVE);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        ArrayList<Predstava> predstave = (ArrayList<Predstava>) so.getOdgovor();
        return predstave;
    }

    public void pokreniFormuZaUbaciPredstavu() {
        ArrayList<Glumac> glumci = vratiGlumce();
        formaUbaciPredstavu = new formaUbaciPredstavu(glumci);
        formaUbaciPredstavu.setLocationRelativeTo(formaGlumci);
        formaUbaciPredstavu.setVisible(true);
    }

    public ArrayList<Reziser> vratiRezisere() {
        ArrayList<Reziser> lista = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_LISTU_REZISERA);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        lista = (ArrayList<Reziser>) so.getOdgovor();
        return lista;
    }

    public ArrayList<Zanr> vratiZanrove() {
        ArrayList<Zanr> lista = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_LISTU_ZANROVA);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        lista = (ArrayList<Zanr>) so.getOdgovor();
        return lista;
    }

    public void ubaciPredstavu(String naziv, String trajanje, String opis, Reziser reziser, Zanr zanr, ArrayList<Glumac> glumci) {
        if(naziv.isEmpty() || trajanje.isEmpty() || opis.isEmpty() || reziser==null || zanr == null){
            JOptionPane.showMessageDialog(formaUbaciPredstavu, "Sva polja moraju biti popunjena!", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(glumci.isEmpty()){
            JOptionPane.showMessageDialog(formaUbaciPredstavu, "Morate izabrati barem jednog glumca", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int trajanjePredstave;
        try{
            trajanjePredstave = Integer.parseInt(trajanje);
        }catch(Exception e){
            JOptionPane.showMessageDialog(formaUbaciPredstavu, "Trajanje predstave mora biti broj", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        naziv = srediString(naziv);
        opis = srediString(opis);
        
        Predstava p = new Predstava();
        p.setNazivPredstave(naziv);
        p.setTrajanjePredstave(trajanjePredstave);
        p.setOpisPredstave(opis);
        p.setReziser(reziser);
        p.setZanr(zanr);
        p.setGlumci(glumci);
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.KREIRAJ_PREDSTAVU);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Predstava ubacenaPredstava = (Predstava) so.getOdgovor();
        
        if(ubacenaPredstava.getPredstavaID()!= 0){
            JOptionPane.showMessageDialog(formaUbaciPredstavu, "Sistem je zapamtio predstavu sa id: "+ubacenaPredstava.getPredstavaID(), "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(formaUbaciPredstavu, "Sistem ne moze da zapamti predstavu!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        formaUbaciPredstavu.dispose();
        //pokreniGlumce();
        formaPredstave.azurirajTabelu(vratiPredstave());
    }

    public void pokreniFormuZaIzmeniPredstavu(Predstava p) {
        if(p == null){
            JOptionPane.showMessageDialog(formaPredstave, "Morate izabrati predstavu za izmenu!", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_PREDSTAVU);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Predstava predstava = (Predstava) so.getOdgovor();
        ArrayList<Glumac> glumci = vratiGlumce();
        //formaGlumci.dispose();
        formaIzmeniPredstavu = new formaIzmeniPredstavu(glumci,predstava);
        formaIzmeniPredstavu.setLocationRelativeTo(formaPredstave);
        formaIzmeniPredstavu.setVisible(true);
    }

    public void izmeniPredstavu(String naziv, String trajanje, String opis, Reziser reziser, Zanr zanr, ArrayList<Glumac> glumci, int id) {
        if(naziv.isEmpty() || trajanje.isEmpty() || opis.isEmpty() || reziser==null || zanr == null){
            JOptionPane.showMessageDialog(formaIzmeniPredstavu, "Sva polja moraju biti popunjena!", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(glumci.isEmpty()){
            JOptionPane.showMessageDialog(formaIzmeniPredstavu, "Morate izabrati barem jednog glumca", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int trajanjePredstave;
        try{
            trajanjePredstave = Integer.parseInt(trajanje);
        }catch(Exception e){
            JOptionPane.showMessageDialog(formaIzmeniPredstavu, "Trajanje predstave mora biti broj", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        naziv = srediString(naziv);
        opis = srediString(opis);
        
        Predstava p = new Predstava(id, naziv, trajanjePredstave, opis, reziser, zanr, glumci);
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_PREDSTAVU);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Predstava izmenjenaPredstava = (Predstava) so.getOdgovor();
        if(izmenjenaPredstava.getPredstavaID()!= 0){
            JOptionPane.showMessageDialog(formaIzmeniPredstavu, "Sistem je zapamtio predstavu sa id: "+izmenjenaPredstava.getPredstavaID(), "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(formaIzmeniPredstavu, "Sistem ne moze da zapamti predstavu!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        formaIzmeniPredstavu.dispose();
        //pokreniGlumce();
        formaPredstave.azurirajTabelu(vratiPredstave());
    }

    public void pokreniFormuZaBrisanjePredstave(Predstava p) {
        if(p == null){
            JOptionPane.showMessageDialog(formaPredstave, "Morate izabrati predstavu za brisanje!", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_PREDSTAVU);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Predstava predstava = (Predstava) so.getOdgovor();
        
      //  formaGlumci.dispose();
        formaObrisiPredstavu = new formaObrisiPredstavu(predstava);
        formaObrisiPredstavu.setLocationRelativeTo(formaPredstave);
        formaObrisiPredstavu.setVisible(true);
    }

    public void obrisiPredstavu(Predstava predstava) {
        if(predstava == null){
            JOptionPane.showMessageDialog(formaObrisiPredstavu, "Greska");
        }
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_PREDSTAVU);
        kz.setParametar(predstava);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        Predstava predstavaObrisana = (Predstava) so.getOdgovor();
        
        if(predstavaObrisana.getPredstavaID() != 0){
            JOptionPane.showMessageDialog(formaObrisiPredstavu, "Sistem je obrisao predstavu sa id: "+predstavaObrisana.getPredstavaID(), "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(formaObrisiPredstavu, "Sistem ne moze da obrise predstavu!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        formaObrisiPredstavu.dispose();
        //pokreniGlumce();
        formaPredstave.azurirajTabelu(vratiPredstave());
    }

    public ArrayList<Predstava> pretraziPredstave(String pretraga) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        if(pretraga.isEmpty()){
            kz.setOperacija(Operacije.VRATI_PREDSTAVE);
        }else{
            pretraga+='%';
            kz.setOperacija(Operacije.NADJI_PREDSTAVU);
            kz.setParametar(pretraga);
        }
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        ArrayList<Predstava> predstave = (ArrayList<Predstava>) so.getOdgovor();
        return predstave;
    }

    private String srediString(String str) {
        String replace0 = str.replace(",", "");
        String replace1 = replace0.replace("\n", "");
        String replace2 = replace1.replace("\b", "");
        String replace3 = replace2.replace("\'", "");
        String replace4 = replace3.replace("\0", "");
        String replace5 = replace4.replace("\\", "");
        String replace6 = replace5.replace("\t", "");
        return replace6;
    }
    
}
