/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.lista11;

/**
 *
 * @author Lenzi
 */
public abstract class BuscaAbstract<T extends Comparable<T>> {
    protected T[] info;
    
    public T[] getInfo() {
        return info;
    }
    
    public void setInfo(T[] info) {
        this.info = info;
    }
    
    public abstract int buscar(T valor);
}