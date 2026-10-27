/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenzi
 */
import java.util.Objects;

public class NoMapa<K,T> {
    private T valor;
    private K chave;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NoMapa<?, ?> noMapa = (NoMapa<?, ?>) o;
        return Objects.equals(getChave(), noMapa.getChave());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getChave());
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
