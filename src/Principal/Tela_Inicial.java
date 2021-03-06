/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controller.ClienteDAO;
import Controller.Conexao;
import Principal.Login_Funn;
import View.Cliente.Estoque_Armazem;
import View.Cliente.Comprar_Pro_Cliente;
import Modelo.Cliente;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoope
 */
public class Tela_Inicial extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Inicial
     */
    
//     Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
//        int lar = (int) tela.getWidth();
//        int alt = (int) tela.getHeight();
        
    public Tela_Inicial() {
        initComponents();
        setSize(670, 580);
        setTitle("Distribuidora Ítalo");
        setLocationRelativeTo(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Estoque = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Comprar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        Estoque.setBackground(new java.awt.Color(255, 204, 0));
        Estoque.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        Estoque.setForeground(new java.awt.Color(255, 255, 255));
        Estoque.setText("Estoque");
        Estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstoqueActionPerformed(evt);
            }
        });
        getContentPane().add(Estoque);
        Estoque.setBounds(260, 260, 140, 37);

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 500, 70, 20);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Distribuidora Ítalo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 336, 56);

        Comprar.setBackground(new java.awt.Color(51, 255, 153));
        Comprar.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        Comprar.setForeground(new java.awt.Color(255, 255, 255));
        Comprar.setText("Comprar");
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });
        getContentPane().add(Comprar);
        Comprar.setBounds(260, 210, 140, 37);

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 51));
        jButton5.setText("Acesso Restrito");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(230, 420, 210, 37);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/maxresdefault.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 670, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
               
              dispose();

       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         new Login_Funn().setVisible(true);
              dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void EstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstoqueActionPerformed
        // TODO add your handling code here:
       new Estoque_Armazem().setVisible(true);
       dispose();
    }//GEN-LAST:event_EstoqueActionPerformed

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
        // TODO add your handling code here:
        int Per = JOptionPane.showConfirmDialog(null, "Você já anotou os códigos dos produtos que deseja?");
        
        if (Per == JOptionPane.YES_OPTION) {
            Connection con = Conexao.AbrirConexao();
            ClienteDAO sql = new ClienteDAO(con);
            Cliente c = new Cliente();
            
            int confirm = JOptionPane.showConfirmDialog(null,"Você é um novo usuário?","Distribuidora Ítalo",JOptionPane.INFORMATION_MESSAGE);
            if(confirm == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"Redirecionando para a tela de cadastro","Distribuidora Ítalo",JOptionPane.INFORMATION_MESSAGE);
                    new Tela_Cadastro().setVisible(true);
                    dispose();
            }else{
                    int confirm2 = JOptionPane.showConfirmDialog(null,"Você é um usuário antigo?","Distribuidora Ítalo",JOptionPane.INFORMATION_MESSAGE);
                    if (confirm2 == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null,"Redirecionando para a tela de login","Distribuidora Ítalo",JOptionPane.INFORMATION_MESSAGE);
                        new Tela_Login().setVisible(true);
                        dispose();
                    }
            }
            
               
        }
        
    }//GEN-LAST:event_ComprarActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comprar;
    private javax.swing.JButton Estoque;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
