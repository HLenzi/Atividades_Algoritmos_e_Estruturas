/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.lista6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenzi
 */
public class FilaVetorTest {
    
    public FilaVetorTest() {
    }

    @Test
    public void estaVazia(){
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        
        assertTrue(fila.estaVazia());
    }
    
    @Test
    public void naoEstaVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }
    
    @Test
    public void enfileirarDesenfileirar() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(30, fila.retirar());
        assertTrue(fila.estaVazia());
    }
    
    @Test
    public void filaCheia() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        assertThrows(FilaCheiaException.class, () -> {
            fila.inserir(40);
        });
    }
    
    @Test
    public void filaVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        
        assertThrows(FilaVaziaException.class, () -> {
            fila.retirar();
        });
    }
    
    @Test
    public void testePeek() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        assertEquals(10, fila.peek());
        assertEquals(10, fila.retirar());
    }
    
    @Test
    public void testeLiberar() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        fila.liberar();
        assertTrue(fila.estaVazia());
    }
    
    @Test
    public void testConcatenar() {
        FilaVetor<Integer> fila1 = new FilaVetor<>(5);
        fila1.inserir(10);
        fila1.inserir(20);
        fila1.inserir(30);
        
        FilaVetor<Integer> fila2 = new FilaVetor<>(5);
        fila2.inserir(40);
        fila2.inserir(50);
        
        FilaVetor<Integer> filaConcatenada = fila1.criarFilaConcatenada(fila2);
        
        assertEquals("10,20,30,40,50", filaConcatenada.toString());
        assertEquals("10,20,30", fila1.toString());
        assertEquals("40,50", fila2.toString());
    }
}
