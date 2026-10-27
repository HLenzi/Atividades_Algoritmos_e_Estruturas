/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lista7;

/**
 *
 * @author Lenzi
 */
public class NoArvoreBinaria<T> {

    T info;
    private NoArvoreBinaria esquerda;
    private NoArvoreBinaria direita;
    
    public NoArvoreBinaria(T info){
        this.info = info;
    }
    
    
    public NoArvoreBinaria(T info, NoArvoreBinaria esq, NoArvoreBinaria dir){
        this.info = info;
        this.esquerda = esq;
        this.direita = dir;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvoreBinaria getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria direita) {
        this.direita = direita;
    }
    
    
}
