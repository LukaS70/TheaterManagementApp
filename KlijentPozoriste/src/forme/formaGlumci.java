/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Glumac;
import java.util.ArrayList;
import kontroler.KontrolerKorisnickogInterfejsa;
import model.ModelTabeleGlumci;


/**
 *
 * @author Luka
 */
public class formaGlumci extends javax.swing.JFrame {

    int x,y;
    ArrayList<Glumac> glumci;
    /**
     * Creates new form formaGlumci
     */
    public formaGlumci(ArrayList<Glumac> glumci) {
        initComponents();
        this.glumci = glumci;
        napuniTabelu();
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
        jLabel3 = new javax.swing.JLabel();
        btnNazad = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGlumci = new javax.swing.JTable();
        btnUbaci = new javax.swing.JLabel();
        btnIzmeni = new javax.swing.JLabel();
        btnObrisi = new javax.swing.JLabel();
        btnPretrazi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/close5.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        btnNazad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_nazad (1).png"))); // NOI18N
        btnNazad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNazadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNazad, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 639, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNazad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pretrazite glumce po prezimenu:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 40));

        txtPretraga.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtPretraga, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 350, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableGlumci.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableGlumci);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 650, 240));

        btnUbaci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_unesi-glumca (1).png"))); // NOI18N
        btnUbaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbaciMouseClicked(evt);
            }
        });
        jPanel1.add(btnUbaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        btnIzmeni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_izmeni-glumca (1).png"))); // NOI18N
        btnIzmeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIzmeniMouseClicked(evt);
            }
        });
        jPanel1.add(btnIzmeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        btnObrisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_obrisi-glumca (1).png"))); // NOI18N
        btnObrisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObrisiMouseClicked(evt);
            }
        });
        jPanel1.add(btnObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        btnPretrazi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_pretrazi (1).png"))); // NOI18N
        btnPretrazi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPretraziMouseClicked(evt);
            }
        });
        jPanel1.add(btnPretrazi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/zav.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx-x, yy-y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnUbaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbaciMouseClicked
        KontrolerKorisnickogInterfejsa.getInstanca().pokreniFormuZaUbaciGlumca();
    }//GEN-LAST:event_btnUbaciMouseClicked

    private void btnIzmeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIzmeniMouseClicked
        ModelTabeleGlumci mtg = new ModelTabeleGlumci(glumci); 
        KontrolerKorisnickogInterfejsa.getInstanca().pokreniFormuZaIzmeniGlumca(mtg.dajGlumca(tableGlumci.getSelectedRow()));
    }//GEN-LAST:event_btnIzmeniMouseClicked

    private void btnObrisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObrisiMouseClicked
        ModelTabeleGlumci mtg = new ModelTabeleGlumci(glumci); 
        KontrolerKorisnickogInterfejsa.getInstanca().pokreniFormuZaBrisanjeGlumca(mtg.dajGlumca(tableGlumci.getSelectedRow()));
    }//GEN-LAST:event_btnObrisiMouseClicked

    private void btnPretraziMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPretraziMouseClicked
        glumci = KontrolerKorisnickogInterfejsa.getInstanca().pretraziGlumce(txtPretraga.getText().trim());
        ModelTabeleGlumci mtg = new ModelTabeleGlumci(glumci);
        tableGlumci.setModel(mtg);
    }//GEN-LAST:event_btnPretraziMouseClicked

    private void btnNazadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNazadMouseClicked
        dispose();
        KontrolerKorisnickogInterfejsa.getInstanca().pokreniMainFormu();
    }//GEN-LAST:event_btnNazadMouseClicked

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
//            java.util.logging.Logger.getLogger(formaGlumci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(formaGlumci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(formaGlumci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(formaGlumci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new formaGlumci().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnIzmeni;
    private javax.swing.JLabel btnNazad;
    private javax.swing.JLabel btnObrisi;
    private javax.swing.JLabel btnPretrazi;
    private javax.swing.JLabel btnUbaci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGlumci;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void napuniTabelu() {
        ModelTabeleGlumci mtg = new ModelTabeleGlumci(glumci);
        tableGlumci.setModel(mtg);
    }

    public void azurirajTabelu(ArrayList<Glumac> g){
        this.glumci = g;
        napuniTabelu();
    }
    
}