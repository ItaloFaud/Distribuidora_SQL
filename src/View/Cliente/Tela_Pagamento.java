/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Cliente;


import Controller.Conexao;
import Controller.FaturaDAO;
import Modelo.Fatura;
import View.*;
import Principal.Tela_Inicial;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoope
 */
public class Tela_Pagamento extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Inicial
     */
    
//     Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
//        int lar = (int) tela.getWidth();
//        int alt = (int) tela.getHeight();
        Fatura ff = new Fatura();
    public Tela_Pagamento(Fatura f) {
        initComponents();
        setTitle("Distribuidora Ítalo");
        setSize(670, 580);
        setLocationRelativeTo(this);
        JtfValorCompra.setText(f.getSubtotal());
        ff = f;
    }

    private Tela_Pagamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JtfTroco = new javax.swing.JTextField();
        JtfValorRecebido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Comprar = new javax.swing.JButton();
        JtfValorCompra = new javax.swing.JTextField();
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

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pagamento");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 40, 210, 30);

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Troco:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(120, 220, 120, 30);

        JtfTroco.setEditable(false);
        JtfTroco.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        JtfTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfTrocoActionPerformed(evt);
            }
        });
        getContentPane().add(JtfTroco);
        JtfTroco.setBounds(240, 220, 200, 30);

        JtfValorRecebido.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        JtfValorRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfValorRecebidoActionPerformed(evt);
            }
        });
        getContentPane().add(JtfValorRecebido);
        JtfValorRecebido.setBounds(240, 170, 200, 30);

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Valor da compra:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(120, 120, 120, 30);

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Valor recebido:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(120, 170, 120, 30);

        Comprar.setBackground(new java.awt.Color(102, 255, 0));
        Comprar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Comprar.setForeground(new java.awt.Color(255, 255, 255));
        Comprar.setText("Pagar");
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });
        getContentPane().add(Comprar);
        Comprar.setBounds(230, 300, 210, 60);

        JtfValorCompra.setEditable(false);
        JtfValorCompra.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        JtfValorCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfValorCompraActionPerformed(evt);
            }
        });
        getContentPane().add(JtfValorCompra);
        JtfValorCompra.setBounds(240, 120, 200, 30);

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

    private void JtfValorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfValorCompraActionPerformed
        //JOptionPane.showMessageDialog(null, "Insira a quantidade de caixas e aperte ENTER", "Distribuidora Ítalo", JOptionPane.INFORMATION_MESSAGE);
        

    }//GEN-LAST:event_JtfValorCompraActionPerformed

    private void JtfTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfTrocoActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_JtfTrocoActionPerformed

    private void JtfValorRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfValorRecebidoActionPerformed
        // TODO add your handling code here:
        double troco = Double.parseDouble(JtfValorRecebido.getText()) - Double.parseDouble(JtfValorCompra.getText());
        JtfTroco.setText(troco+"");
    }//GEN-LAST:event_JtfValorRecebidoActionPerformed

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
        // TODO add your handling code here:
        if(Double.parseDouble(JtfTroco.getText()) < 0){
            JOptionPane.showMessageDialog(null, "Dinheiro insuficiente","Distribuidora Ítalo",JOptionPane.WARNING_MESSAGE);
        }else{
            Connection con = Conexao.AbrirConexao();
            FaturaDAO sql = new FaturaDAO(con);
            
            if(sql.Pagamento(ff)){
                JOptionPane.showMessageDialog(null, "Fatura paga!\nEntrega será liberada","Distribuidora Ítalo",JOptionPane.INFORMATION_MESSAGE);
                new Tela_Inicial().setVisible(true);
                dispose();
            }else{
                 JOptionPane.showMessageDialog(null, "Erro","Distribuidora Ítalo",JOptionPane.WARNING_MESSAGE);
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
            java.util.logging.Logger.getLogger(Tela_Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Pagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comprar;
    private javax.swing.JTextField JtfTroco;
    private javax.swing.JTextField JtfValorCompra;
    private javax.swing.JTextField JtfValorRecebido;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}