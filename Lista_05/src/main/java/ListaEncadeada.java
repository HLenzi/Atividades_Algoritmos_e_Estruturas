/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Set;

/**
 *
 * @author Lenzi
 */
public class ListaEncadeada<T> {

    private NoListaEnc<T> primeiro;

    public ListaEncadeada() {
    }

    public void setPrimeiro(NoListaEnc<T> primeiro) {
        this.primeiro = primeiro;
    }

    public NoListaEnc<T> getPrimeiro() {
        return this.primeiro;
    }

    public void inserir(T valor) {
        NoListaEnc<T> novo = new NoListaEnc<T>();

        novo.setInfo(valor);
        novo.setProximo(primeiro);
        this.setPrimeiro(novo);
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoListaEnc<T> buscar(T valor) {
        NoListaEnc<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p.setProximo(p.getProximo());
        }
        return null;
    }

    public void retirar(T valor) {

        NoListaEnc<T> anterior = null;
        NoListaEnc<T> p = primeiro;

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
    
    public int obterComprimeto(){
    int comprimento = 0;
    
    NoListaEnc<T> p = primeiro;
    
    while(p != null){
        comprimento++;
        p = p.getProximo();
    }
    
    return comprimento;   
    }
    
    public NoListaEnc<T> obterNo(int idx){
        NoListaEnc<T> p = primeiro;

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
        
        NoListaEnc<T> p = primeiro;
        
        while(p != null){
            stg  = stg + p.getInfo();
            p = p.getProximo();
        }
        
        return stg;
    }
}
