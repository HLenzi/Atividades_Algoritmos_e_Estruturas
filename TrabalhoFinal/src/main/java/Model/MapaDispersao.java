/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenzi
 */
public class MapaDispersao<K,T> {
    private ListaEncadeada<NoMapa<K,T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(K chave) { 
        return Math.abs(chave.hashCode()) % info.length; 
    }

    public void inserir(K chave, T valor) {
        int indice = calcularHash(chave);

        if (info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }

        NoMapa<K,T> no = new NoMapa<K,T>();
        no.setChave(chave);
        no.setValor(valor);

        info[indice].inserir(no);
    }

    public T buscar(K chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<K,T> noMapa = new NoMapa();
            noMapa.setChave(chave);

            NoLista<NoMapa<K,T>> no = info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getValor();
            }
        }
        return null;
    }

    public void remover(K chave) {
        int indice = calcularHash(chave);

        NoMapa<K,T> buscador = new NoMapa();
        buscador.setChave(chave);

        info[indice].retirar(buscador);
    }

    public double calcularFatorCarga() {
        int totalElementos = 0;
        int tamanho = info.length;

        for (int i = 0; i < tamanho; i++) {
            if (info[i] != null) totalElementos += info[i].obterComprimento();
        }

        if (totalElementos == 0) return 0;
        return (double) totalElementos / tamanho;
    }
    
    public ListaEncadeada<NoMapa<K,T>> getLista(K chave) { 
        int idx = this.calcularHash(chave);
        return info[idx];
    }
}
