/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Glumac;
import domen.Predstava;
import java.util.ArrayList;
import kontroler.KontrolerKorisnickogInterfejsa;
import model.ModelTabeleGlumci;
import model.ModelTabelePredstave;

/**
 *
 * @author Luka
 */
public class formaPredstave extends javax.swing.JFrame {
    
    int x,y;
    ArrayList<Predstava> predstave;
    Predstava izabranaPredstava;
    /**
     * Creates new form formaPredstave
     */
    public formaPredstave(ArrayList<Predstava> predstave) {
        initComponents();
        this.predstave = predstave;
        napuniTabelu();
        ModelTabeleGlumci mtg = new ModelTabeleGlumci();
        tableGlumci.setModel(mtg);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePredstave = new javax.swing.JTable();
        txtPretraga = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
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

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pretrazite predstave po nazivu:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablePredstave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablePredstave.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePredstave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePredstaveMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePredstave);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 610, 230));

        txtPretraga.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtPretraga, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 330, 30));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tableGlumci.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jScrollPane2.setViewportView(tableGlumci);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 650, 190));

        btnUbaci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_ubaci-predstavu.png"))); // NOI18N
        btnUbaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbaciMouseClicked(evt);
            }
        });
        jPanel1.add(btnUbaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        btnIzmeni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_izmeni-predstavu (1).png"))); // NOI18N
        btnIzmeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIzmeniMouseClicked(evt);
            }
        });
        jPanel1.add(btnIzmeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        btnObrisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_obrisi-predstavu (2).png"))); // NOI18N
        btnObrisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObrisiMouseClicked(evt);
            }
        });
        jPanel1.add(btnObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        btnPretrazi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/button_pretrazi (1).png"))); // NOI18N
        btnPretrazi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPretraziMouseClicked(evt);
            }
        });
        jPanel1.add(btnPretrazi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forme/zav.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePredstaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePredstaveMouseClicked
      //  System.out.println("Klik");
        ModelTabelePredstave mtp = new ModelTabelePredstave(predstave);
        
        izabranaPredstava =  mtp.dajPredstavu(tablePredstave.getSelectedRow());
        System.out.println(izabranaPredstava.getNazivPredstave());
        for (Glumac g : izabranaPredstava.getGlumci()) {
            System.out.println(g.toString());
        }
        
        ModelTabeleGlumci mtg = new ModelTabeleGlumci(izabranaPredstava.getGlumci());
        tableGlumci.setModel(mtg);
    }//GEN-LAST:event_tablePredstaveMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnNazadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNazadMouseClicked
        dispose();
        KontrolerKorisnickogInterfejsa.getInstanca().pokreniMainFormu();
    }//GEN-LAST:event_btnNazadMouseClicked

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
        KontrolerKorisnickogInterfejsa.getInstanca().pokreniFormuZaUbaciPredstavu();
    }//GEN-LAST:event_btnUbaciMouseClicked

    private void btnIzmeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIzmeniMouseClicked
        ModelTabelePredstave mtp = new ModelTabelePredstave(predstave);
        KontrolerKorisnickogInterfejsa.getInstanca().pokreniFormuZaIzmeniPredstavu(mtp.dajPredstavu(tablePredstave.getSelectedRow()));
    }//GEN-LAST:event_btnIzmeniMouseClicked

    private void btnObrisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObrisiMouseClicked
        ModelTabelePredstave mtp = new ModelTabelePredstave(predstave);
        KontrolerKorisnickogInterfejsa.getInstanca().pokreniFormuZaBrisanjePredstave(mtp.dajPredstavu(tablePredstave.getSelectedRow()));
    }//GEN-LAST:event_btnObrisiMouseClicked

    private void btnPretraziMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPretraziMouseClicked
        predstave = KontrolerKorisnickogInterfejsa.getInstanca().pretraziPredstave(txtPretraga.getText().trim());
        ModelTabelePredstave mtp = new ModelTabelePredstave(predstave);
        tablePredstave.setModel(mtp);
    }//GEN-LAST:event_btnPretraziMouseClicked

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
//            java.util.logging.Logger.getLogger(formaPredstave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(formaPredstave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(formaPredstave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(formaPredstave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new formaPredstave().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableGlumci;
    private javax.swing.JTable tablePredstave;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void napuniTabelu() {
        ModelTabelePredstave mtp = new ModelTabelePredstave(predstave);
        tablePredstave.setModel(mtp);
        
    }
    public void azurirajTabelu(ArrayList<Predstava> p){
        this.predstave = p;
        napuniTabelu();
    }
}