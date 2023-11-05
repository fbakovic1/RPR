package org.example;

import java.util.Objects;

public class MedunarodniBroj extends TelefonskiBroj{
    private String drzava, broj;
    public MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return "+" + drzava + "/" + broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drzava,broj);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedunarodniBroj that = (MedunarodniBroj) o;
        return drzava == that.drzava && broj.equals(that.broj);
    }
}
