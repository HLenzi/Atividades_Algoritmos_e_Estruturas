/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenzi
 */
public class NoListaEnc<T> {
    
    private T info;
    private NoListaEnc<T> proximo;


    public T getInfo(){
        return this.info;
    }
    
    public void setInfo(T info){
        this.info = info;
    }
    
    public NoListaEnc<T> getProximo(){
        return this.proximo;
    }
    
    public void setProximo(NoListaEnc<T> proximo){
        this.proximo = proximo;
    }
}
