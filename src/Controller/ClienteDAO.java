/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Cliente;
import Modelo.Fatura;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoope
 */
public class ClienteDAO extends ExecuteSQL{
    
    public ClienteDAO(Connection con) {
        super(con);
    }
    
    public void Comprar(Cliente c,Fatura f,Pedido p){
        String compra = "insert into fa";
    }
    
    public boolean Login(Cliente c){
        try {
            
                String consulta = "insert into cliente values (0,?,?)";
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setString(1, c.getNome());
                ps.setString(2, c.getCpf());
                
                if(ps.executeUpdate() > 0){
                 return true;
                }
            
        } catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            
           
            
            
        return false;
    }
    
//    public String Nome(String cpf){
//        String consulta = "select nome from cliente where CPF = '"+cpf+"'";
//        return null;
//    }
    
//    VerProdutos;
//    ConferePro;
    
   
    
}
