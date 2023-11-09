package org.example.z3;

import org.example.FiksniBroj;
import org.example.Grad;
import org.example.Imenik;
import org.example.MedunarodniBroj;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

class ImenikTestMocking {


    private static Imenik imenik = new Imenik();

    @BeforeAll
    public static void napraviImenik(){
        imenik.dodaj("Mirza", new FiksniBroj(Grad.TUZLA, "876-777"));
        imenik.dodaj("Farah", new MedunarodniBroj("+49", "876-552"));
        imenik.dodaj("Kerim", new FiksniBroj(Grad.TUZLA, "811-977"));
    }


    @Test
    void TestMockdajBroj() {
        Imenik i = Mockito.mock(Imenik.class);
        Mockito.when(i.dajBroj("Kerim")).thenReturn("Nema kontakta u imeniku!");

        String test = i.dajBroj("Kerim");
        assertEquals(test, "Nema kontakta u imeniku!");
    }
}