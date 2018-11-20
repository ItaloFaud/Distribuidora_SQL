/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoope
 */
public class Conexao {
    public static Connection AbrirConexao(){
        
            Connection con = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/distribuidora";
                con = DriverManager.getConnection(url,"root","");

            }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"ERRO na conexão com o Banco",
                            "Vídeo Locadora",JOptionPane.ERROR_MESSAGE);
                    e.getMessage();

            }
        return con;  
        }
    
    public static void FecharConexao(Connection con){
        try{
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
