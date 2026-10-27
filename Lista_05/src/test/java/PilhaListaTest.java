/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenzi
 */
public class PilhaListaTest {
    
    public PilhaListaTest() {
    }

    @Test
    public void pilhaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        
        assertTrue(pilha.estaVazia());
    }
    
    @Test
    public void pilhaNaoVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        pilha.push(10);
        
        assertFalse(pilha.estaVazia());
    }
    
    @Test
    public void empilharDesempilhar() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());
    }
    
    @Test
    public void pilhaPeek() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        assertEquals(30, pilha.peek());
    }
 
       @Test
    public void pilhaLiberar() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        
        assertTrue(pilha.estaVazia());
    }
 
}
