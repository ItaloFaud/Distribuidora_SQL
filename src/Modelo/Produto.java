package Modelo;

import View.Escritório.Alterar_Pro;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class Produto {
    private int id;
    private String tipo;
    private String marca;
    private int caixas;
    private String preco;
    private String data;
    private String codigo;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String nome) {
        this.tipo = nome;
    }

    public int getCaixas() {
        return caixas;
    }

    public void setCaixas(int caixas) {
        this.caixas = caixas;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    
}

