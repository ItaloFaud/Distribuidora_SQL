/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Fatura;
import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoope
 */
public class PedidoDAO extends ExecuteSQL{
    
    public PedidoDAO(Connection con) {
        super(con);
    }
    
    public void Novo_Pedido(int IdFatura,Produto p){
        try {
            String consulta = "insert into pedido values (0,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            
            ps.setInt(1,p.getCaixas());
            ps.setInt(2,p.getId());
            ps.setInt(3,IdFatura);
            ps.setString(4,p.getPreco());
            
            if(ps.executeUpdate() > 0){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
