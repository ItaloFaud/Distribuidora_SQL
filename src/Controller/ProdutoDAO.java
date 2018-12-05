/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Produto;
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
    
    public List<Produto> Consulta(){
        String consulta = "select id,caixas,preco,marca,tipo,data_validade from produto";
            List<Produto> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Produto c = new Produto();
                    c.setId(rs.getInt(1));
                    c.setCaixas(rs.getInt(2));
                    c.setPreco(rs.getString(3));
                    c.setMarca(rs.getString(4));
                    c.setTipo(rs.getString(5));
                    c.setData(rs.getString(6));
                    
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
    
    public List<Produto> PreAlterar(Produto p){
        String consulta = "select id,caixas,preco,marca,tipo,data_validade from produto where id = '"+p.getId()+"' ";
            List<Produto> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Produto c = new Produto();
                    c.setId(rs.getInt(1));
                    c.setCaixas(rs.getInt(2));
                    c.setPreco(rs.getString(3));
                    c.setMarca(rs.getString(4));
                    c.setTipo(rs.getString(5));
                    c.setData(rs.getString(6));
                    
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
    
    public String Alterar(Produto pro, int id){
        try {
            String consulta = "update produto set caixas = '"+pro.getCaixas()+"', "
                    + "preco = '"+pro.getPreco()+"', "
                    + "marca = '"+pro.getMarca()+"', "
                    + "tipo = '"+pro.getTipo()+"',"
                    + "data_validade = '"+pro.getData()+"' where id = '"+id+"'";
            
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
    
    public String Deletar(Produto p){
        try {
            String consulta = "delete from produto where id = ?";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ps.setInt(1, p.getId());
            
            if(ps.executeUpdate()>0){
                return "Deletado!";
            }else{
                return "ERRO!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
        
    }
    
    
}
