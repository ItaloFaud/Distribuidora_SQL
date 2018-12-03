/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Funcionário;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Hoope
 */
public class FuncionárioDAO extends ExecuteSQL{
    
    public FuncionárioDAO(Connection con) {
        super(con);
    }
    
    public int Logar(Funcionário f){
        try {
            String consulta = "select nivel from funcionario where user = '"+f.getUser()+"' and senha = '"+f.getSenha()+"'";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    f.setNível(rs.getInt(1));
                    return f.getNível();
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionárioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
