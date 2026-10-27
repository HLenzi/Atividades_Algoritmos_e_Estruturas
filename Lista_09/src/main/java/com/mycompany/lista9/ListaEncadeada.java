/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lista9;

import java.util.Set;

/**
 *
 * @author Lenzi
 */
public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
    }

    public NoLista<T> getPrimeiro() {
        return this.primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<T>();

        novo.setInfo(valor);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista buscar(T valor) {
        NoLista<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
             p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {

        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && p.getInfo() != valor) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) {
                primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }
    
    public int obterComprimento(){
    int comprimento = 0;
    
    NoLista<T> p = primeiro;
    
    while(p != null){
        comprimento++;
        p = p.getProximo();
    }
    
    return comprimento;   
    }
    
    public NoLista<T> obterNo(int idx){
        NoLista<T> p = primeiro;

        if(idx < 0){
            throw new IndexOutOfBoundsException("Invalido!");
        } 
        
        int idxAtual = 0;
        while(p != null){
            if(idxAtual == idx){
                return p;
            } else {
                idxAtual++;
                p = p.getProximo();
            }
        }
        if(p == null){
            throw new IndexOutOfBoundsException("Invalido!");
        }
        
        return p;
    }
    
    public String toString(){
        String stg = new String();
        
        NoLista<T> p = primeiro;
        
        while(p != null){
            stg  = stg + p.getInfo();
            p = p.getProximo();
        }
        
        return stg;
    }
}
