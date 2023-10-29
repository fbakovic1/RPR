package org.example;

public class Racun {

    public long brojRacuna;
    public Osoba korisnikRacuna;
    public boolean odobrenjePrekoracenja;
    public Double stanjeRacuna;

    public Racun(Long brojRacuna, Osoba xy){
        this.brojRacuna= brojRacuna;
        this.korisnikRacuna= xy;
        this.odobrenjePrekoracenja= false;
        this.stanjeRacuna = 0.;
    }

    private boolean provjeriOdobrenjePrekoracenja(double x){
        return this.odobrenjePrekoracenja;
    }
    public boolean izvrsiUplatu(Double uplata){
        return true;
    }
    public boolean izvrsiIsplatu(Double isplata){
        return true;
    }
    public void odobriPrekoracenje(Double granica){

    }
}
