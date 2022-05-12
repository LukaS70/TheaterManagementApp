/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Glumac;
import domen.Predstava;
import domen.Reziser;
import domen.Zanr;
import java.awt.Color;
import java.util.ArrayList;
import kontroler.KontrolerKorisnickogInterfejsa;
import model.ModelTabeleGlumci;

/**
 *
 * @author Luka
 */
public class formaIzmeniPredstavu extends javax.swing.JFrame {

    int x,y;
    ModelTabeleGlumci mtgSvi;
    ModelTabeleGlumci mtgIzabrani;
    ArrayList<Glumac> glumci;
    Predstava p;
    /**
     * Creates new form formaIzmeniPredstavu
     */
    public formaIzmeniPredstavu(ArrayList<Glumac> glumci, Predstava p) {
        initComponents();
        this.glumci = glumci;
        this.p = p;
        popuniKomboReziser();
        popuniKomboZanr();
        this.mtgSvi = new ModelTabeleGlumci(glumci);
        
        this.mtgIzabrani = new ModelTabeleGlumci();
        napuniTabelu();
        unesipodatke(p);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTrajanje = new javax.swing.JTextField();
        cbReziser = new javax.swing.JComboBox();
        cbZanr = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSviGlumci = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOdabraniGlumci = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnIzmeni = new javax.swing.JLabel();
        btnOdustani = new javax.swing.JLabel();
        btnUbaci = new javax.swing.JLabel();
        btnIzbaci = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/close5.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(850, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Reziser: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Zanr: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 50, 20));

        txtTrajanje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTrajanje.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTrajanje.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTrajanjeFocusLost(evt);
            }
        });
        jPanel1.add(txtTrajanje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 250, -1));

        cbReziser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbReziser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbReziser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 304, -1));

        cbZanr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbZanr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbZanr, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 304, -1));

        txtOpis.setColumns(20);
        txtOpis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtOpis.setRows(5);
        txtOpis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOpisFocusLost(evt);
            }
        });
        jScrollPane4.setViewportView(txtOpis);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 305, 85));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("minuta");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 50, 20));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableSviGlumci.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableSviGlumci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableSviGlumci);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 500, 160));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tableOdabraniGlumci.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableOdabraniGlumci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableOdabraniGlumci);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 500, 130));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Trajanje: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, 20));

        txtNaziv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNaziv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNazivFocusLost(evt);
            }
        });
        jPanel1.add(txtNaziv, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 305, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Opis: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Naziv: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 20));

        btnIzmeni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_izmeni (1).png"))); // NOI18N
        btnIzmeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIzmeniMouseClicked(evt);
            }
        });
        jPanel1.add(btnIzmeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        btnOdustani.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_odustani (2).png"))); // NOI18N
        btnOdustani.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOdustaniMouseClicked(evt);
            }
        });
        jPanel1.add(btnOdustani, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        btnUbaci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_ubaci (2).png"))); // NOI18N
        btnUbaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbaciMouseClicked(evt);
            }
        });
        jPanel1.add(btnUbaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        btnIzbaci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_izbaci.png"))); // NOI18N
        btnIzbaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIzbaciMouseClicked(evt);
            }
        });
        jPanel1.add(btnIzbaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/pozDuza.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 890, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx-x, yy-y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnIzmeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIzmeniMouseClicked
        KontrolerKorisnickogInterfejsa.getInstanca().izmeniPredstavu(txtNaziv.getText(),txtTrajanje.getText(),txtOpis.getText(),(Reziser)cbReziser.getSelectedItem(),(Zanr)cbZanr.getSelectedItem(),mtgIzabrani.vratiGlumceIzTabele(),p.getPredstavaID());
    }//GEN-LAST:event_btnIzmeniMouseClicked

    private void btnOdustaniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOdustaniMouseClicked
        dispose();
    }//GEN-LAST:event_btnOdustaniMouseClicked

    private void btnUbaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbaciMouseClicked
        if(tableSviGlumci.getSelectedRow() != -1){
            mtgIzabrani.dodajUTabelu(mtgSvi.dajGlumca(tableSviGlumci.getSelectedRow()));
        }
    }//GEN-LAST:event_btnUbaciMouseClicked

    private void btnIzbaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIzbaciMouseClicked
        if(tableOdabraniGlumci.getSelectedRow()!= -1){
            mtgIzabrani.izbaciIzTabele(mtgIzabrani.dajGlumca(tableOdabraniGlumci.getSelectedRow()));
        }
    }//GEN-LAST:event_btnIzbaciMouseClicked

    private void txtNazivFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNazivFocusLost
        if(txtNaziv.getText().isEmpty()){
            txtNaziv.setBackground(new Color(255, 168, 168));
        }else{
            txtNaziv.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtNazivFocusLost

    private void txtTrajanjeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTrajanjeFocusLost
        if(txtTrajanje.getText().isEmpty()){
            txtTrajanje.setBackground(new Color(255, 168, 168));
        }else{
            int trajanjePredstave;
            try{
                trajanjePredstave = Integer.parseInt(txtTrajanje.getText());
            }catch(Exception e){
                txtTrajanje.setBackground(new Color(255, 168, 168));
                return;
            }
            txtTrajanje.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtTrajanjeFocusLost

    private void txtOpisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOpisFocusLost
        if(txtOpis.getText().isEmpty()){
            txtOpis.setBackground(new Color(255, 168, 168));
        }else{
            txtOpis.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtOpisFocusLost

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(formaIzmeniPredstavu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(formaIzmeniPredstavu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(formaIzmeniPredstavu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(formaIzmeniPredstavu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new formaIzmeniPredstavu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnIzbaci;
    private javax.swing.JLabel btnIzmeni;
    private javax.swing.JLabel btnOdustani;
    private javax.swing.JLabel btnUbaci;
    private javax.swing.JComboBox cbReziser;
    private javax.swing.JComboBox cbZanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableOdabraniGlumci;
    private javax.swing.JTable tableSviGlumci;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextArea txtOpis;
    private javax.swing.JTextField txtTrajanje;
    // End of variables declaration//GEN-END:variables

    private void napuniTabelu() {
        tableSviGlumci.setModel(mtgSvi);
        tableOdabraniGlumci.setModel(mtgIzabrani);
    }

    private void popuniKomboReziser() {
        cbReziser.removeAllItems();
        ArrayList<Reziser> reziseri = KontrolerKorisnickogInterfejsa.getInstanca().vratiRezisere();
        for (Reziser r : reziseri) {
            cbReziser.addItem(r);
        }
    }

    private void popuniKomboZanr() {
        cbZanr.removeAllItems();
        ArrayList<Zanr> zanrovi = KontrolerKorisnickogInterfejsa.getInstanca().vratiZanrove();
        for (Zanr z : zanrovi) {
            cbZanr.addItem(z);
        }
    }

    private void unesipodatke(Predstava p) {
        txtNaziv.setText(p.getNazivPredstave());
        txtTrajanje.setText(""+p.getTrajanjePredstave());
        txtOpis.setText(p.getOpisPredstave());
        cbReziser.setSelectedIndex(p.getReziser().getReziserID()-1);
        cbZanr.setSelectedIndex(p.getZanr().getZanrID()-1);
        for(Glumac g : p.getGlumci()){
            mtgIzabrani.dodajUTabelu(g);
        }
        
    }
}
