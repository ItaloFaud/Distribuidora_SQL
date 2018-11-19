package Modelo;

import View.Alterar_Pro;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class Produto {
    private String nome;
    private String marca;
    private String caixas;
    private String preco;
    private String data;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaixas() {
        return caixas;
    }

    public void setCaixas(String caixas) {
        this.caixas = caixas;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    public void CriarPro(){
        File Produtos = new File("Produtos/"+this.nome+"_"+this.marca);
        Produtos.mkdir();
        File NomePro = new File("Produtos/"+this.nome+"_"+this.marca+"/Nome.txt");
        File MarcaPro = new File("Produtos/"+this.nome+"_"+this.marca+"/Marca.txt");
        File PrecoPro = new File("Produtos/"+this.nome+"_"+this.marca+"/Preco.txt");
        File CaixasPro = new File("Produtos/"+this.nome+"_"+this.marca+"/Caixas.txt");
        File DataPro = new File("Produtos/"+this.nome+"_"+this.marca+"/Data.txt");
        File CodPro = new File("Produtos/"+this.nome+"_"+this.marca+"/Codigo.txt");
        
        try {
        NomePro.createNewFile();
        MarcaPro.createNewFile();
        PrecoPro.createNewFile();
        CaixasPro.createNewFile();
        DataPro.createNewFile();
        CodPro.createNewFile();
            
            FileWriter NP = new FileWriter(NomePro);
            BufferedWriter ENP = new BufferedWriter(NP);
            ENP.write(this.nome);
            ENP.close();
            NP.close();
            
            FileWriter MP = new FileWriter(MarcaPro);
            BufferedWriter EMP = new BufferedWriter(MP);
            EMP.write(this.marca);
            EMP.close();
            MP.close();
            
            FileWriter PP = new FileWriter(PrecoPro);
            BufferedWriter EPP = new BufferedWriter(PP);
            EPP.write(this.preco);
            EPP.close();
            PP.close();
            
            FileWriter CP = new FileWriter(CaixasPro);
            BufferedWriter ECP = new BufferedWriter(CP);
            ECP.write(this.caixas);
            ECP.close();
            CP.close();
            
            FileWriter DP = new FileWriter(DataPro);
            BufferedWriter EDP = new BufferedWriter(DP);
            EDP.write(this.data);
            EDP.close();
            DP.close();
            
            FileWriter CodP = new FileWriter(CodPro);
            BufferedWriter ECodP = new BufferedWriter(CodP);
            ECodP.write(this.codigo);
            ECodP.close();
            CodP.close();
            
            
        } catch (Exception e) {
        }
        
    }
    
}
