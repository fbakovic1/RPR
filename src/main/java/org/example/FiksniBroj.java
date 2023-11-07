package org.example;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad gr, String br) {
        if (null == gr) throw new Izuzetak("Pozivni broj za fiksni telefon nije OK!");
        this.grad = gr;
        this.broj = br;
    }

    @Override
    public String ispisi() {
        if (grad != null && broj != null){
            return grad.getPozivniBroj() + '/' + broj;
        }
        else{
            return null;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }

    public Grad getGrad() {
        return grad;
    }

    public String getBroj() {
        return broj;
    }
}
