/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista10;

/**
 *
 * @author Lenzi
 */
public class OrdenacaoMergeSort <T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int n = this.getInfo().length - 1;
        mergeSort(0,n);
    }
    
    private void mergeSort(int inicio, int fim){
       int meio = (inicio + fim) / 2;
       mergeSort(inicio, meio);
       mergeSort(meio+1, fim);
       merge(inicio, fim, meio);
    }
    
    private void merge(int inicio, int fim, int meio){
        int tamEsq = meio - inicio + 1;
        T[] esquerda = (T[]) new Object[tamEsq];
        
        for(int i = 0; i < tamEsq; i++){
            esquerda[i] = (T) this.getInfo()[inicio+i];
        }
        
        int tamDir = fim - meio;
        T[] direita = (T[]) new Object[tamDir];
        
        for(int i = 0; i < tamDir - 1; i++){
            direita[i] = (T) this.getInfo()[meio+1+i];
        }
        
        
        int cEsq = 0;
        int cDir = 0;
        int i;
        
        for(i = inicio; i < fim; i++){
            if((cEsq < tamEsq) && (cDir < tamDir)){
                if(esquerda[cEsq].compareTo(direita[cDir]) < 0 ){
                this.getInfo()[i] = esquerda[cEsq];
                cEsq++;
                } else {
                this.getInfo()[i] = direita[cDir];
                cDir++;                }
            } else {
                break;
            }
        }
        
        while(cEsq < tamEsq){
            this.getInfo()[i] = esquerda[cEsq];
            cEsq++;
            i++;
        }
        
        while(cDir < tamDir){
            this.getInfo()[i] = direita[cDir];
            cDir++;
            i++;
        }
    }
    
}
