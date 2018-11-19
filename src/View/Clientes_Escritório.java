/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Modelo.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoope
 */
public class Clientes_Escritório extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Inicial
     */
    
//     Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
//        int lar = (int) tela.getWidth();
//        int alt = (int) tela.getHeight();
        
    public Clientes_Escritório() {
        initComponents();
        setTitle("Distribuidora Ítalo");
        setSize(670, 580);
        setLocationRelativeTo(this);
        Clientes();
        
    }
    
    public void Clientes() {
        DefaultTableModel tabela = (DefaultTableModel) Tabela.getModel();
        
        File pasta = new File("Pedidos");
        File Clientes[] = pasta.listFiles();
        
        if (Clientes != null){
            Cliente c1 = new Cliente();
            String PTot = "";
            int pos = 1;
            
            for (int i = 0; i < Clientes.length; i++) {
                File Cliente = Clientes[i];
                c1.setNome(Cliente.getName().toUpperCase());
                
                try {
                    //                File NomePro = new File("Pedidos/"+c1.getNome());
//                File Preco[] = NomePro.listFiles();

                FileReader PrecoTot = new FileReader("Pedidos/"+c1.getNome()+"/Sub_Total.txt");
                    BufferedReader Lptot = new BufferedReader(PrecoTot);
                    try {
                        PTot = Lptot.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(Clientes_Escritório.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                
                
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Clientes_Escritório.class.getName()).log(Level.SEVERE, null, ex);
                }
                Object InfoCliente[] = {pos+"."+c1.getNome(),PTot};
                tabela.addRow(InfoCliente);
                pos++;
                
            }
            
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton2.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton2.setText("Tela Inicial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(530, 500, 120, 29);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Distribuidora Ítalo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 510, 126, 21);

        Tabela.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Preço do Pedido"
            }
        ));
        jScrollPane1.setViewportView(Tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 620, 400);

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 500, 110, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/maxresdefault.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 660, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Tela_Inicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Controle_Escritório().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes_Escritório.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes_Escritório.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes_Escritório.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes_Escritório.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes_Escritório().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
