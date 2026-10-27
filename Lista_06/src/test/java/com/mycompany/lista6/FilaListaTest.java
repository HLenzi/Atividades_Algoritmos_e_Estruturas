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
public class FilaListaTest {
    
    public FilaListaTest() {
    }

    @Test
    public void testEstaVazia() {
        FilaLista<Integer> fila = new FilaLista<>();
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testNaoEstaVazia() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testEnfileirarDesenfileirar() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testPeek() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        assertEquals(10, fila.peek());
        assertEquals(10, fila.retirar());
    }

    @Test
    public void testLiberar() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        fila.liberar();
        assertTrue(fila.estaVazia());
    }
}
