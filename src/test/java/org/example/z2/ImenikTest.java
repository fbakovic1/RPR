package org.example.z2;

import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import java.util.Set;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.*;

public class ImenikTest {

    @Test
    public void testNaSlovo() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Farah", new MedunarodniBroj("+49", "876-552"));

        String rezultat = imenik.naSlovo('F');

        assertEquals("1. Farah - +49876-552", rezultat);
    }

    @Test
    public void testIzGradaVracaJedanGrad() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Mirza", new FiksniBroj(Grad.TUZLA, "876-777"));
        imenik.dodaj("Farah", new MedunarodniBroj("+49", "876-552"));

        TreeSet<String> result = (TreeSet) imenik.izGrada(Grad.TUZLA);

        assertEquals(1, result.size());
        assertTrue(result.contains("Mirza"));
    }

    @Test
    public void testIzGradaVracaDvaGrada() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Mirza", new FiksniBroj(Grad.TUZLA, "876-777"));
        imenik.dodaj("Farah", new MedunarodniBroj("+49", "876-552"));
        imenik.dodaj("Kerim", new FiksniBroj(Grad.TUZLA, "811-977"));

        Set<String> result = imenik.izGrada(Grad.TUZLA);

        assertEquals(2, result.size());
        assertEquals(new TreeSet<String>() {{ add("Mirza"); add("Kerim"); }}, result);
    }

    @Test
    public void testIzGradaBrojeviVracaJedanGrad() {
        Imenik imenik = new Imenik();
        var expectedBroj = new FiksniBroj(Grad.TUZLA, "876-777");
        imenik.dodaj("Mirza", expectedBroj);
        imenik.dodaj("Farah", new MedunarodniBroj("+49", "876-552"));

        Set<TelefonskiBroj> result = imenik.izGradaBrojevi(Grad.TUZLA);

        assertEquals(1, result.size());
        assertTrue(result.contains(expectedBroj));
    }

    @Test
    public void TstDodajFiksniIzuzetak(){
        assertThrows(Izuzetak.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null, "531-532");
            }
        });
    }

    @Test
    public void testDajBrojVracaJedan(){
        Imenik imenik = new Imenik();
        imenik.dodaj("Mirza", new FiksniBroj(Grad.TUZLA, "876-777"));
        imenik.dodaj("Farah", new MedunarodniBroj("+49", "876-552"));

        assertEquals(imenik.dajBroj("Mirza"), "035/876-777");
    }

    @Test
    public void testDajBrojVracaull(){
        Imenik imenik = new Imenik();
        imenik.dodaj("Mirza", new FiksniBroj(Grad.TUZLA, "876-777"));
        imenik.dodaj("Farah", new MedunarodniBroj("+49", "876-552"));

        assertNull(imenik.dajBroj("Hasan"));
    }
}