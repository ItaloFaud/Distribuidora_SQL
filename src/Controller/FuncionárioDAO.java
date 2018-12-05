/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Funcionário;
import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public String Cadastro(Funcionário f){
        try {
            String consulta = "insert into funcionario values (0,?,?,?,?,?)";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            
            
            ps.setString(1, f.getNome());
            ps.setString(2, f.getUser());
            ps.setString(3, f.getSenha());
            ps.setString(4, f.getCpf());
            ps.setInt(5, f.getNível());
            
            if(ps.executeUpdate() > 0){
                return "Cadastro executado com sucesso!";
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionárioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro:"+ex.getMessage();
        }
        return null;
    }
    
     public List<Funcionário> Consulta(){
        String consulta = "select id,nome,user,senha,cpf,nivel from funcionario";
            List<Funcionário> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Funcionário c = new Funcionário();
                    c.setId(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setUser(rs.getString(3));
                    c.setSenha(rs.getString(4));
                    c.setCpf(rs.getString(5));
                    c.setNível(rs.getInt(6));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
     
     public List<Funcionário> Consultaa(){
        String consulta = "select id,nome,user,senha,cpf,nivel from funcionario where nivel = 1 or nivel = 2";
            List<Funcionário> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Funcionário c = new Funcionário();
                    c.setId(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setUser(rs.getString(3));
                    c.setSenha(rs.getString(4));
                    c.setCpf(rs.getString(5));
                    c.setNível(rs.getInt(6));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
     
     public String Deletar(Funcionário f){
        try {
            String consulta = "delete from funcionario where id = ?";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ps.setInt(1, f.getId());
            
            if(ps.executeUpdate() > 0){
                return f.getNome()+" foi excluído com sucesso!";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionárioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "ERRO:"+ex.getMessage();
        }
        return null;
     }
     
     public List<Funcionário> PreAlterar(Funcionário p){
        String consulta = "select id,nome,user,senha,cpf,nivel from funcionario where id = '"+p.getId()+"' ";
            List<Funcionário> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Funcionário c = new Funcionário();
                    c.setId(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setUser(rs.getString(3));
                    c.setSenha(rs.getString(4));
                    c.setCpf(rs.getString(5));
                    c.setNível(rs.getInt(6));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
     
     public String Alterar(Funcionário f, int id){
        try {
            String consulta = "update funcionario set nome = '"+f.getNome()+"', "
                    + "user = '"+f.getUser()+"', "
                    + "senha = '"+f.getSenha()+"', "
                    + "cpf = '"+f.getCpf()+"',"
                    + "nivel = '"+f.getNível()+"' where id = '"+id+"'";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            
            if(ps.executeUpdate()> 0){
                return "Alterado!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
        return null;
    }
    
}
