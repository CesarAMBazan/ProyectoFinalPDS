
package com.sidphillips.vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.sidphillips.controlador.ManagerReporte;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;

/**
 * @author Cesar Arturo Mejia Bazan - 2182005565
 * @author Enrique Ramirez Martinez - 2182000079
 * @author Rojas Piña Efraín Ulises - 2172001457
 */
public class main extends javax.swing.JFrame {
    String rutaFormato;
    String rutaPA;
    ManagerReporte man;
    /**
     * Creates new form main
     */
    public main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFormatoRuta = new javax.swing.JLabel();
        lblPARuta = new javax.swing.JLabel();
        btnFormato = new javax.swing.JButton();
        btnPA = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        lblNota = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APALizer");
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));
        setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setText("APALizer");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("Formato:");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Producto academico:");

        lblFormatoRuta.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblFormatoRuta.setText("Seleccione un archivo extension pdf o docx");

        lblPARuta.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblPARuta.setText("Seleccione un archivo extension pdf o docx");

        btnFormato.setText("SELECCIONAR ARCHIVO");
        btnFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormatoActionPerformed(evt);
            }
        });

        btnPA.setText("SELECCIONAR ARCHIVO");
        btnPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPAActionPerformed(evt);
            }
        });

        btnAnalizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        lblNota.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lblPARuta))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFormatoRuta)))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFormato)
                            .addComponent(btnPA)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblNota)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblFormatoRuta)
                    .addComponent(btnFormato))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblPARuta)
                    .addComponent(btnPA))
                .addGap(18, 18, 18)
                .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(lblNota)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormatoActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos pdf y docx", "pdf", "docx");
        fileChooser.setFileFilter(filter);
        int respuesta = fileChooser.showOpenDialog(this);
        rutaFormato = fileChooser.getSelectedFile().getPath();
        String extension = FilenameUtils.getExtension(rutaFormato);
        if(extension.compareTo("pdf") == 0  || extension.compareTo("docx")== 0)
        {
            lblFormatoRuta.setText(fileChooser.getSelectedFile().getName());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Por favor seleccionar un formato");
        }
        
    }//GEN-LAST:event_btnFormatoActionPerformed

    private void btnPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPAActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser2 = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos pdf y docx", "pdf", "docx");
        fileChooser2.setFileFilter(filter);
        int respuesta = fileChooser2.showOpenDialog(this);
      
      
        rutaPA = fileChooser2.getSelectedFile().getPath();
        String extension = FilenameUtils.getExtension(rutaPA);
        
        if(extension.compareTo("pdf") == 0  || extension.compareTo("docx")== 0)
        {
            lblPARuta.setText(fileChooser2.getSelectedFile().getName());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Por favor seleccionar un producto academico");
        }
    }//GEN-LAST:event_btnPAActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
        man = new ManagerReporte();
        if(rutaFormato ==  null )
        {
            JOptionPane.showMessageDialog(null, "Por favor seleccionar un formato");
        }
        else if(rutaPA == null)
        {
            JOptionPane.showMessageDialog(null, "Por favor seleccionar un producto academico");
        }
        else
        {
            try {
                man.generarProceso(rutaFormato, rutaPA);
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                lblNota.setText("El archivo esta listo, se encuenta en la caprteta reportes dentro del proyecto");
            }
            
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnFormato;
    private javax.swing.JButton btnPA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFormatoRuta;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblPARuta;
    // End of variables declaration//GEN-END:variables
}
