/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista10;

/**
 *
 * @author Lenzi
 */
public class OrdenacaoQuickSort <T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
       int n = this.getInfo().length - 1;
       quickSort(0, n);
    }
    
    private void quickSort(int inicio, int fim){
        T[] vetor = this.getInfo();
        if(inicio < fim){
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo-1);
            quickSort(idxPivo+1, fim);
        }
    }
    
    private int particionar(int inicio, int fim){
        int a = inicio;
        int b = fim+1;
        T pivo = this.getInfo()[inicio];
        
        while(true){
            do{
                a++;
            } while (a <= fim && this.getInfo()[a].compareTo(pivo) < 0);
            
            do{
                b--;
            } while (b >= inicio && this.getInfo()[b].compareTo(pivo) > 0);
            
            if(a >= b){
                break;
            }
            
            this.trocar(a, b);
        }
        trocar(b, inicio);
        return b;
    }
}