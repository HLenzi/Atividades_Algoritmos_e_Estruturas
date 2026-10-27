/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista7;

/**
 *
 * @author Lenzi
 */
public class ArvoreBinaria<T> {
    
    private NoArvoreBinaria raiz;
    
    public void setRaiz(NoArvoreBinaria<T> no){
        this.raiz = no;
    }
    
    public boolean estaVazia(){
        return raiz == null;
    }
    
    public boolean pertence(T valor){
        return pertence(raiz, valor);
    }
    
    public boolean pertence(NoArvoreBinaria<T> no, T valor){
        if(no == null){
            return false;
        } else {
            return (no.getInfo().equals(valor)) || 
                this.pertence(no.getEsquerda(), valor) || 
                this.pertence(no.getDireita(), valor);
        }
    }
    
    public String toString(){
        return arvorePre(raiz);
    }
    
    private String arvorePre(NoArvoreBinaria<T> no){
        String str = "";
        if(no == null){
            return "<>";
        }
        
        str += "<";
        str += no.getInfo();
        str += (arvorePre(no.getEsquerda()));
        str += (arvorePre(no.getDireita()));
        str += ">";
        
        return str;
    }
    
    public int contarNos(){
        return contarNos(raiz);
    }
    
    private int contarNos(NoArvoreBinaria<T> no){
        if(no == null){
            return 0;
        }
        
            return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }
}
