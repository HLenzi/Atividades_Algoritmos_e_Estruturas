/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista10;

/**
 *
 * @author Lenzi
 */
    public class OrdenacaoBolha <T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
       T[] vetor = this.getInfo();
       int n = vetor.length;
       
       for(int i = n-1; i >= 1; i--){
           for(int j = 0; j < i; j++){
               if(vetor[j].compareTo(vetor[j+1]) > 0){
                   this.trocar(j, j + 1);
               }
           }
       }
       
    }
}
