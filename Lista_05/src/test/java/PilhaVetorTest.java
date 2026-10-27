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
public class PilhaVetorTest {

    public PilhaVetorTest() {
    }

    @Test
    public void estaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        assertTrue(pilha.estaVazia());
    }

    @Test
    public void nãoEstaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);

        assertFalse(pilha.estaVazia());
    }

    @Test
    public void empilharDesempilhar() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());

        assertTrue(pilha.estaVazia());
    }

    @Test
    public void pilhaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        assertThrows(PilhaVaziaException.class, () -> {
            pilha.pop();
        });
    }

    @Test
    public void peek() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        assertEquals(30, pilha.peek());
        assertEquals(30, pilha.pop());
    }
    
    @Test
    public void liberar() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        pilha.liberar();
        
        assertTrue(pilha.estaVazia());
    }
    
    
    @Test
    public void concatenar() {
        PilhaVetor<Integer> pilha1 = new PilhaVetor<>(5);
        pilha1.push(10);
        pilha1.push(20);
        pilha1.push(30);
        
        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(5);
        pilha2.push(40);
        pilha2.push(50);
        
        pilha1.concatenar(pilha2);
        
        assertEquals("50, 40, 30, 20, 10", pilha1.toString());
    }

    
}
