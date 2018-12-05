/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Escritório;


import Controller.Conexao;
import Controller.ProdutoDAO;
import Modelo.Produto;
import Principal.Tela_Inicial;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Hoope
 */
public class Alterar_Pro extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Inicial
     */
    int id;
//     Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
//        int lar = (int) tela.getWidth();
//        int alt = (int) tela.getHeight();
        
    public Alterar_Pro(Produto p) {
        initComponents();
        setTitle("Distribuidora Ítalo");
        setSize(670, 580);
        setLocationRelativeTo(this);
        PegarValores(p);
        id = p.getId();
        
    }
    
    
    
    public void PegarValores(Produto p){
        Connection con = Conexao.AbrirConexao();
        ProdutoDAO sql = new ProdutoDAO(con);
        
        List<Produto> lista = new ArrayList<>();
        lista = sql.PreAlterar(p);
        
        int i = 0;
        for (Produto tab : lista) {
            //Object object = arr[j];
            
            NomePro.setText(tab.getTipo());
            MarcaPro.setText(tab.getMarca());
            CaixaPro.setText(""+tab.getCaixas());
            PrecoPro.setText(tab.getPreco());
            DataPro.setText(tab.getData());
            CodPro.setText(""+tab.getId());
            i++; 
        }
        Conexao.FecharConexao(con);
    }

    private Alterar_Pro() {
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
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CaixaPro = new javax.swing.JTextField();
        PrecoPro = new javax.swing.JTextField();
        DataPro = new javax.swing.JTextField();
        MarcaPro = new javax.swing.JTextField();
        NomePro = new javax.swing.JTextField();
        Alterar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        CodPro = new javax.swing.JTextField();
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

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alterar produto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 220, 29);

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quantidade (caixas):");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 200, 140, 21);

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Data de Validade:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 320, 120, 21);

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Marca:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 140, 50, 21);

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Distribuidora Ítalo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 510, 126, 21);

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Preço:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(100, 260, 50, 21);

        CaixaPro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        CaixaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaixaProActionPerformed(evt);
            }
        });
        getContentPane().add(CaixaPro);
        CaixaPro.setBounds(300, 200, 200, 30);

        PrecoPro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        PrecoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoProActionPerformed(evt);
            }
        });
        getContentPane().add(PrecoPro);
        PrecoPro.setBounds(300, 260, 200, 30);

        DataPro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        DataPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataProActionPerformed(evt);
            }
        });
        getContentPane().add(DataPro);
        DataPro.setBounds(300, 320, 200, 30);

        MarcaPro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        MarcaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaProActionPerformed(evt);
            }
        });
        getContentPane().add(MarcaPro);
        MarcaPro.setBounds(300, 140, 200, 30);

        NomePro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        NomePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeProActionPerformed(evt);
            }
        });
        getContentPane().add(NomePro);
        NomePro.setBounds(300, 80, 200, 30);

        Alterar.setBackground(new java.awt.Color(0, 204, 0));
        Alterar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Alterar.setForeground(new java.awt.Color(255, 255, 255));
        Alterar.setText("Alterar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(Alterar);
        Alterar.setBounds(210, 450, 150, 40);

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nome:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(100, 80, 50, 21);

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(530, 454, 120, 30);

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Código:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(100, 380, 50, 21);

        CodPro.setEditable(false);
        CodPro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        CodPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodProActionPerformed(evt);
            }
        });
        getContentPane().add(CodPro);
        CodPro.setBounds(300, 380, 200, 30);

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

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void DataProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataProActionPerformed

    private void MarcaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaProActionPerformed

    private void CaixaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixaProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixaProActionPerformed

    private void PrecoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoProActionPerformed

    
    
    
    
    
    
    
    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        // TODO add your handling code here:
       String ProNome = NomePro.getText();
       String ProMarca = MarcaPro.getText();
       String ProCaixa = CaixaPro.getText();
       String ProPreco = PrecoPro.getText();
       String ProData = DataPro.getText();
       //String ProCod = CodPro.getText();
        
//        JOptionPane.showMessageDialog(null, ProNome+"\n"+ProCaixa+"\n"+
//                ProPreco+"\n"+ProData);

        Produto pro = new Produto();
        pro.setTipo(ProNome);
        pro.setMarca(ProMarca);
        pro.setCaixas(Integer.parseInt(ProCaixa));
        pro.setPreco(ProPreco);
        pro.setData(ProData);
        
        
        //pro.setCodigo(ProCod);
        
        //Alterar
        Connection con = Conexao.AbrirConexao();
        ProdutoDAO sql = new ProdutoDAO(con);
        JOptionPane.showMessageDialog(null,sql.Alterar(pro,id),"Distribuidara",JOptionPane.INFORMATION_MESSAGE);
        
        NomePro.setText("");
        MarcaPro.setText("");
        DataPro.setText("");
        PrecoPro.setText("");
        CaixaPro.setText("");
        
        new Controle_Escritório().setVisible(true);
        dispose();
        
//        
//        
       
        
    }//GEN-LAST:event_AlterarActionPerformed

    private void NomeProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeProActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Controle_Escritório().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CodProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodProActionPerformed

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
            java.util.logging.Logger.getLogger(Alterar_Pro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alterar_Pro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alterar_Pro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alterar_Pro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Alterar_Pro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JTextField CaixaPro;
    private javax.swing.JTextField CodPro;
    private javax.swing.JTextField DataPro;
    private javax.swing.JTextField MarcaPro;
    private javax.swing.JTextField NomePro;
    private javax.swing.JTextField PrecoPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
