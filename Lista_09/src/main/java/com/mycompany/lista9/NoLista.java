/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista9;

/**
 *
 * @author Lenzi
 */
public class NoLista<T> {
    
    private T info;
    private NoLista<T> proximo;


    public T getInfo(){
        return this.info;
    }
    
    public void setInfo(T info){
        this.info = info;
    }
    
    public NoLista<T> getProximo(){
        return this.proximo;
    }
    
    public void setProximo(NoLista<T> proximo){
        this.proximo = proximo;
    }
}
