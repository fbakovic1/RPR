package org.example;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad gr, String br) throws Izuzetak {
        if(br.length() >10 ) throw new Izuzetak("Neispravan format!");
        grad = gr;
        broj = br;
    }

    @Override
    public String ispisi() {
        return grad.toString() + '/' + broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }

    @Override
    public int compareTo(Object o) {
        FiksniBroj br = (FiksniBroj) o;
        return this.ispisi().compareTo(br.ispisi());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiksniBroj that = (FiksniBroj) o;
        return grad == that.grad && broj.equals(that.broj);
    }
    public Grad dajGrad(){ return grad; }
}
