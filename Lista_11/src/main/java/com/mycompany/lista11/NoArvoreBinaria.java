/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista11;

/**
 *
 * @author Lenzi
 */
public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> direita;
    private NoArvoreBinaria<T> esquerda;
    
    public NoArvoreBinaria(T info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }
}  

