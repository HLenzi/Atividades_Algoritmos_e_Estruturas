/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista11;

/**
 *
 * @author Lenzi
 */
public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    @Override
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if(no.equals(null)){
            return null;
        }
        
        if(no.getInfo().equals(info)){
            return no;
        }
        
    NoArvoreBinaria<T> p = buscar(no.getEsquerda(), info);
    if (p != null) {
        return p;
    }

    return buscar(no.getDireita(), info);
    }
}
