/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Cliente;


import Modelo.Produto;
import Principal.Tela_Inicial;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoope
 */
public class Comprar_Pro_Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Inicial
     */
    
//     Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
//        int lar = (int) tela.getWidth();
//        int alt = (int) tela.getHeight();
        
    public Comprar_Pro_Cliente(String NCliente) {
        initComponents();
        setTitle("Distribuidora Ítalo");
        setSize(660, 580);
        setLocationRelativeTo(this);
        Cliente1.setText(NCliente);
        
        
    }

    private Comprar_Pro_Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Procurar_Cod(String Cod) throws FileNotFoundException{
        File pro = new File ("Produtos");
        File Procura[] = pro.listFiles();
        
        for (int i = 0; i < Procura.length; i++) {
            File file = Procura[i];
            //System.out.println(Procura[i]);
            FileReader Pros = new FileReader(Procura[i]+"/Codigo.txt");
            BufferedReader LPros = new BufferedReader(Pros);
            try {
                String cod = LPros.readLine();
                if (cod.equals(Cod)) {
                FileReader Nome  = new FileReader(Procura[i]+"/Nome.txt");
                BufferedReader LNome  = new BufferedReader(Nome);
                String NomeProo = LNome.readLine();
                
                FileReader Marca = new FileReader(Procura[i]+"/Marca.txt");
                BufferedReader LMarca  = new BufferedReader(Marca);
                String MarcaProo  = LMarca.readLine();
                
                FileReader Preco  = new FileReader(Procura[i]+"/Preco.txt");
                BufferedReader LPreco  = new BufferedReader(Preco);
                String PrecoProo  = LPreco.readLine();
                
                NomePro.setText(NomeProo);
                MarcaPro.setText(MarcaProo);
                PrecoPro.setText(PrecoProo);
                
                float c = Float.parseFloat(QtnCaixas.getText());
                float PU = Float.parseFloat(PrecoProo);
                
                float PTdaC = c*PU;
                
                
                PrecoTotal.setText((PTdaC)+"");
                Subtotal.setText((PTdaC)+"");
                
//               double p = Double.parseDouble(PrecoProo);
//               
//               double c = Double.parseDouble(QtnCaixas.getText());
//                
//                double Preco_Total = p*c;
//                PrecoTotal.setText(toString(Preco_Total));
//
//                                      Olharrrrrrrrrrrrrrrr
                break;
                
                
                }
            } catch (IOException ex) {
                Logger.getLogger(Comprar_Pro_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
    public void Comprar(String Cod) throws IOException{
        File pro = new File ("Pedidos");
        File Procura[] = pro.listFiles();
        
        String Cliente = Cliente1.getText();
        
        for (int i = 0; i < Procura.length; i++) {
            File file = Procura[i];
            //System.out.println(file);
            String NomeC = file.getName();
           
            if(NomeC.equals(Cliente)){
                Produto pro1 = new Produto();
                
                pro1.setNome(NomePro.getText().toUpperCase()); ;
                pro1.setMarca(MarcaPro.getText().toUpperCase());
                int caixasR = Integer.parseInt(QtnCaixas.getText());
                
                FileReader Ler_Caixas = new FileReader("Produtos/"+pro1.getNome()+"_"+pro1.getMarca()+"/Caixas.txt");
                BufferedReader LC = new BufferedReader(Ler_Caixas);
                int caixas = Integer.parseInt(LC.readLine());
                        
                int CR = caixas-caixasR;
                
                String CaixasRR = CR+"";
                
                FileWriter Cai = new FileWriter("Produtos/"+pro1.getNome()+"_"+pro1.getMarca()+"/Caixas.txt");
                BufferedWriter CaixasAtuais = new BufferedWriter(Cai);
                CaixasAtuais.write(CaixasRR);
                CaixasAtuais.close();
                Cai.close();
                
                File Pro = new File("Pedidos/"+NomeC+"/"+pro1.getNome()+"_"+pro1.getMarca());
                Pro.mkdir();
                
                FileWriter M = new FileWriter("Pedidos/"+NomeC+"/"+pro1.getNome()+"_"+pro1.getMarca()+"/Marca.txt");
                BufferedWriter EM = new BufferedWriter(M);
                EM.write(MarcaPro.getText().toUpperCase());
                EM.close();
                M.close();
                
                FileWriter C = new FileWriter("Pedidos/"+NomeC+"/"+pro1.getNome()+"_"+pro1.getMarca()+"/Caixas.txt");
                BufferedWriter EC = new BufferedWriter(C);
                EC.write(QtnCaixas.getText().toUpperCase());
                EC.close();
                C.close();
                
                FileWriter PT = new FileWriter("Pedidos/"+NomeC+"/"+pro1.getNome()+"_"+pro1.getMarca()+"/Preco_Total.txt");
                BufferedWriter EPT = new BufferedWriter(PT);
                EPT.write(PrecoTotal.getText().toUpperCase());
                EPT.close();
                PT.close();
                
                FileWriter SubTotal = new FileWriter("Pedidos/"+NomeC+"/"+"/Sub_Total.txt");
                BufferedWriter ESb = new BufferedWriter(SubTotal);
                ESb.write(Subtotal.getText().toUpperCase());
                ESb.close();
                SubTotal.close();
                
                
              
                
                break;
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

        jLabel5 = new javax.swing.JLabel();
        Comprar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Cliente = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        QtnCaixas = new javax.swing.JTextField();
        Subtotal = new javax.swing.JTextField();
        NomePro = new javax.swing.JTextField();
        MarcaPro = new javax.swing.JTextField();
        PrecoTotal = new javax.swing.JTextField();
        PrecoPro = new javax.swing.JTextField();
        CodPro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Tela_Inicial = new javax.swing.JButton();
        FimCompra = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Cliente1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Escritório");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        Comprar.setBackground(new java.awt.Color(102, 255, 0));
        Comprar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Comprar.setForeground(new java.awt.Color(255, 255, 255));
        Comprar.setText("Comprar outro Produto");
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });
        getContentPane().add(Comprar);
        Comprar.setBounds(240, 400, 220, 40);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Distribuidora Ítalo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 510, 126, 21);

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Compra de Produtos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 40, 210, 30);

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quantidade de Caixas:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 180, 160, 21);

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Marca:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 300, 45, 21);

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total da Compra:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 380, 130, 21);

        Cliente.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cliente.setText("Cliente:");
        getContentPane().add(Cliente);
        Cliente.setBounds(380, 60, 60, 20);

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Preço Total:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(320, 300, 90, 21);

        QtnCaixas.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        QtnCaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtnCaixasActionPerformed(evt);
            }
        });
        getContentPane().add(QtnCaixas);
        QtnCaixas.setBounds(170, 180, 130, 30);

        Subtotal.setEditable(false);
        Subtotal.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        Subtotal.setText("0");
        Subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubtotalActionPerformed(evt);
            }
        });
        getContentPane().add(Subtotal);
        Subtotal.setBounds(20, 410, 160, 30);

        NomePro.setEditable(false);
        NomePro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        NomePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeProActionPerformed(evt);
            }
        });
        getContentPane().add(NomePro);
        NomePro.setBounds(110, 240, 200, 30);

        MarcaPro.setEditable(false);
        MarcaPro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        MarcaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaProActionPerformed(evt);
            }
        });
        getContentPane().add(MarcaPro);
        MarcaPro.setBounds(110, 300, 200, 30);

        PrecoTotal.setEditable(false);
        PrecoTotal.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        PrecoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoTotalActionPerformed(evt);
            }
        });
        getContentPane().add(PrecoTotal);
        PrecoTotal.setBounds(430, 300, 200, 30);

        PrecoPro.setEditable(false);
        PrecoPro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        PrecoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoProActionPerformed(evt);
            }
        });
        getContentPane().add(PrecoPro);
        PrecoPro.setBounds(430, 240, 200, 30);

        CodPro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        CodPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodProActionPerformed(evt);
            }
        });
        getContentPane().add(CodPro);
        CodPro.setBounds(160, 120, 200, 30);

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nome:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(60, 240, 44, 21);

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Código:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(100, 120, 60, 21);

        Tela_Inicial.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Tela_Inicial.setText("Tela Inicial");
        Tela_Inicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tela_InicialActionPerformed(evt);
            }
        });
        getContentPane().add(Tela_Inicial);
        Tela_Inicial.setBounds(530, 500, 120, 29);

        FimCompra.setBackground(new java.awt.Color(255, 0, 0));
        FimCompra.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        FimCompra.setForeground(new java.awt.Color(255, 255, 255));
        FimCompra.setText("Finalizar Compra");
        FimCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FimCompraActionPerformed(evt);
            }
        });
        getContentPane().add(FimCompra);
        FimCompra.setBounds(480, 400, 160, 40);

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Preço Unitário:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(310, 240, 110, 20);

        Cliente1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Cliente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cliente1.setText("Nome:");
        getContentPane().add(Cliente1);
        Cliente1.setBounds(430, 60, 150, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/maxresdefault.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 660, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
        // TODO add your handling code here:
        String cod = CodPro.getText();
        int Conf = JOptionPane.showConfirmDialog(null, "Você deseja comprar este produto?");
        if(Conf == JOptionPane.YES_OPTION){
        try {
            Comprar(cod);
            CodPro.setText("");
        QtnCaixas.setText("");
        NomePro.setText("");
        MarcaPro.setText("");
        PrecoPro.setText("");
        PrecoTotal.setText("");
        new Comprar_Pro_Cliente2(Cliente1.getText(),Subtotal.getText()).setVisible(true);
        dispose();
        } catch (IOException ex) {
            Logger.getLogger(Comprar_Pro_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }    
        }else{
         CodPro.setText("");
        QtnCaixas.setText("");
        NomePro.setText("");
        MarcaPro.setText("");
        PrecoPro.setText("");
        PrecoTotal.setText("");
        Subtotal.setText("");
        }
        
        
        
    }//GEN-LAST:event_ComprarActionPerformed

    private void QtnCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtnCaixasActionPerformed
        // TODO add your handling code here:
        String Codd = CodPro.getText();
        try {
            Procurar_Cod(Codd);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Comprar_Pro_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_QtnCaixasActionPerformed

    private void SubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubtotalActionPerformed

    private void NomeProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeProActionPerformed

    private void MarcaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaProActionPerformed

    private void PrecoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoTotalActionPerformed

    private void PrecoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoProActionPerformed

    private void CodProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodProActionPerformed
        
        
    }//GEN-LAST:event_CodProActionPerformed

    private void Tela_InicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tela_InicialActionPerformed
        // TODO add your handling code here:
        new Tela_Inicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_Tela_InicialActionPerformed

    private void FimCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FimCompraActionPerformed
        // TODO add your handling code here:
        String Codd = CodPro.getText();
        int cc = JOptionPane.showConfirmDialog(null,"Você deseja comprar este produto?");
        if(cc == JOptionPane.YES_OPTION){
            try {
                Comprar(Codd);
            } catch (IOException ex) {
                Logger.getLogger(Comprar_Pro_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            CodPro.setText("");
        QtnCaixas.setText("");
        NomePro.setText("");
        MarcaPro.setText("");
        PrecoPro.setText("");
        PrecoTotal.setText("");
        int c = JOptionPane.showConfirmDialog(null, "Você deseja terminar sua compra?");
        if(c == JOptionPane.YES_OPTION){
            DecimalFormat df = new DecimalFormat("##.##");
            float SubTotal = Float.parseFloat(Subtotal.getText());
            String Pagar = JOptionPane.showInputDialog(null,"O total da compra foi de R$"+df.format(SubTotal));
            float troco = Float.parseFloat(Pagar) - SubTotal;
            
            if(troco == 0){
                JOptionPane.showMessageDialog(null, "Obrigado pela preferência\n entre em contato com o nosso escritório"
                        + " para marcar a sua entrega");
                new Tela_Inicial().setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,"O seu troco é de R$"+df.format(troco));
                JOptionPane.showMessageDialog(null, "Obrigado pela preferência\n entre em contato com o nosso escritório"
                        + " para marcar a sua entrega");
                new Tela_Inicial().setVisible(true);
                dispose();
            }
            
        }
        }
    }//GEN-LAST:event_FimCompraActionPerformed

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
            java.util.logging.Logger.getLogger(Comprar_Pro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comprar_Pro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comprar_Pro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comprar_Pro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comprar_Pro_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cliente;
    private javax.swing.JLabel Cliente1;
    private javax.swing.JTextField CodPro;
    private javax.swing.JButton Comprar;
    private javax.swing.JButton FimCompra;
    private javax.swing.JTextField MarcaPro;
    private javax.swing.JTextField NomePro;
    private javax.swing.JTextField PrecoPro;
    private javax.swing.JTextField PrecoTotal;
    private javax.swing.JTextField QtnCaixas;
    private javax.swing.JTextField Subtotal;
    private javax.swing.JButton Tela_Inicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables


}
