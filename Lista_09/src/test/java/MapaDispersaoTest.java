/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.lista9.Aluno;
import com.mycompany.lista9.MapaDispersao;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenzi
 */
public class MapaDispersaoTest {

    public MapaDispersaoTest() {
    }

    @Test
    public void inserirTest() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.inserir(12000, obj1);

        Aluno aluno = mapa.buscar(12000);

        assertSame(aluno, obj1);
    }

    @Test
    public void variosInserirTest() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(a1.getMatricula(), a1);
        mapa.inserir(a2.getMatricula(), a2);
        mapa.inserir(a3.getMatricula(), a3);
        mapa.inserir(a4.getMatricula(), a4);

        assertSame(a1, mapa.buscar(12000));
        assertSame(a2, mapa.buscar(14000));
        assertSame(a3, mapa.buscar(12500));
        assertSame(a4, mapa.buscar(13000));
    }

@Test
    public void inserirColisaoTest() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(a1.getMatricula(), a1);
        mapa.inserir(a2.getMatricula(), a2);
        mapa.inserir(a3.getMatricula(), a3);
        mapa.inserir(a4.getMatricula(), a4);

        assertSame(a1, mapa.buscar(12000));
        assertSame(a2, mapa.buscar(14000));
        assertSame(a3, mapa.buscar(14226));
        assertSame(a4, mapa.buscar(17180));
    }
}
