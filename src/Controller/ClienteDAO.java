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
import java.util.ArrayList;
import java.util.List;
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
    
  
    
    public boolean Login(Cliente c){
        try {
            String consulta = "select id,nome,user,senha,CPF from cliente where user = '"+c.getUser()+"' and senha = '"+c.getSenha()+"'";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            while(rs != null){
                if(rs.next()){
                  c.setId(rs.getInt(1));
                  c.setNome(rs.getString(2));
                  c.setUser(rs.getString(3));
                  c.setSenha(rs.getString(4));
                  c.setCpf(rs.getString(5));
                  return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public String Cadastro(Cliente c){
        try {
            String consulta = "insert into cliente values (0,?,?,?,?)";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getUser());
            ps.setString(3, c.getSenha());
            ps.setString(4, c.getCpf());
            
            if(ps.executeUpdate() > 0){
                return "Cadastro efetuado com sucesso!";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
        return  null;
    }
    
    public List<Cliente> Consulta(){
        try {
            String consulta = "select id,nome,CPF from cliente";
            List<Cliente> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Cliente c = new Cliente();
                    c.setId(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setCpf(rs.getString(3));
                    lista.add(c);
                }return lista;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
//    public String Nome(String cpf){
//        String consulta = "select nome from cliente where CPF = '"+cpf+"'";
//        return null;
//    }
    
//    VerProdutos;
//    ConferePro;
    
   
    
}
