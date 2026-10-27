/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;

/**
 *
 * @author Lenzi
 */
public class Palavra {
    private String palavra;
    private ListaEncadeada<File> arquivos;

    public Palavra(String palavra, File arquivo) {
        this.palavra = palavra;
        this.arquivos = new ListaEncadeada<>();
        this.arquivos.inserir(arquivo);
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public ListaEncadeada<File> getArquivos() {
        return arquivos;
    }

    public void adicionarArquivo(File arquivo){
        if(!contemArquivo(arquivo)){
            arquivos.inserir(arquivo);
        }
    }
    
    public boolean contemArquivo(File arquivo){
        NoLista<File> no = arquivos.getPrimeiro();
        while(no != null){
            if(no.getInfo().equals(arquivo)){
                return true;
            }
            no = no.getProximo();
        }
        
        return false;
    }
    
}
