/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Hoope
 */
public class ProdutoDAO extends ExecuteSQL{
    
    public ProdutoDAO(Connection con) {
        super(con);
    }
    //Compra Cliente
    public void Confere(Produto p){
        
        String consulta = "select * from produto where id = '"+p.getId()+"' ";
    }
    
    public String Cadastro (Produto c){
        try {
                //String resulta = "Cadsatro";
                String consulta = "insert into produto values (0,?,?,?,?,?)";
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setInt(1, c.getCaixas());
                ps.setString(2, c.getPreco());
                ps.setString(3, c.getMarca());
                ps.setString(4, c.getTipo());
                ps.setString(5, c.getData());
                
                if(ps.executeUpdate() > 0){
                  return "Cadastrado!";
                }
            
        } catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "ERRO!"+ex.getMessage();
        }
    return null;
    }
    
    
}
