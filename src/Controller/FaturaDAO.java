/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Cliente;
import Modelo.Fatura;
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
public class FaturaDAO extends ExecuteSQL {
    
    public FaturaDAO(Connection con) {
        super(con);
    }
    
    public void Nova_Fatura(Fatura f,Cliente c){
        try {
            String consulta = "INSERT INTO fatura VALUES (0,?,?,?)";
            System.out.println(""+c.getId());
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ps.setString(1, "0");
            ps.setInt(2, c.getId());
            ps.setString(3,"À pagar");
            
            if(ps.executeUpdate() > 0){
                   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        }
           
        
    }
    
    public void Encerrando(int idFatura,String valor){
        try {
            String consulta = "update fatura set SubTotal = '"+valor+"' where id = '"+idFatura+"'";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            
            if(ps.executeUpdate() > 0){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int idFatura(Fatura f){
        try {
            String consulta2 = "select LAST_INSERT_ID()";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs = ps2.executeQuery();
            
            while (rs != null) {
                if(rs.next()){
                    f.setId(rs.getInt(1));
                    System.out.println("IdFatura = "+f.getId());
                    return f.getId();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean Pagamento(Fatura f){
        try {
            String sql = "update fatura set situacao = 'Paga' where id = '"+f.getId()+"'";
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            if(ps.executeUpdate() > 0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
