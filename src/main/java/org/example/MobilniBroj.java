package org.example;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj {
    private int mobilnaMreza;
    private String broj;
    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public String toString() {
        return "0" + mobilnaMreza + "/" + broj;
    }

    @Override
    public int compareTo(Object o){
        MobilniBroj br = (MobilniBroj) o;
        return this.ispisi().compareTo(br.ispisi());
    }

    @Override
    public String ispisi() {
        return this.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza, broj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilniBroj that = (MobilniBroj) o;
        return mobilnaMreza == that.mobilnaMreza && broj.equals(that.broj);
    }

}
