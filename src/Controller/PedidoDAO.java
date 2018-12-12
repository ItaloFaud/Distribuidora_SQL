/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Cliente;
import Modelo.Fatura;
import Modelo.Pedido;
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
public class PedidoDAO extends ExecuteSQL{
    
    public PedidoDAO(Connection con) {
        super(con);
    }
    
    public void Novo_Pedido(int IdFatura,Produto p){
        int caixas;
        try {
            String consulta = "insert into pedido values (0,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            
            ps.setInt(1,p.getCaixas());
            ps.setInt(2,p.getId());
            ps.setInt(3,IdFatura);
            ps.setString(4,p.getPreco());
            
            if(ps.executeUpdate() > 0){
               String consulta2 = "select caixas from produto where id = '"+p.getId()+"'";
               
               PreparedStatement ps2 = getCon().prepareStatement(consulta2);
               ResultSet rs2 = ps2.executeQuery();
               
               if(rs2 != null){
                   while (rs2.next()) {                       
                        caixas = rs2.getInt(1) - p.getCaixas();
                       String consulta3 = "update produto set caixas = '"+caixas+"' where id = '"+p.getId()+"'";
               
                       PreparedStatement ps3 = getCon().prepareStatement(consulta3);
                       
                       if (ps3.executeUpdate() > 0) {
                           
                       }
                   }
                   
               }
               
               
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Pedido> Consulta(Fatura f){
        try {
            String consulta = "select id,Caixas,idProduto,idFatura,total from pedido where idFatura = '"+f.getId()+"'";
            List<Pedido> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Pedido c = new Pedido();
                    c.setId(rs.getInt(1));
                    c.setCaixaas(rs.getInt(2));
                    c.setIdProduto(rs.getInt(3));
                    c.setIdFatura(rs.getInt(4));
                    c.setTotal(rs.getString(5));
                    lista.add(c);
                }return lista;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
}
