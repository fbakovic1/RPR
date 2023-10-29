package org.example;

import java.util.List;

public class Banka {

    private Long brojRacuna;
    public List<Korisnik> korisnici;
    public List<Uposlenik> uposlenici;

    public Banka(){}

    public Korisnik kreirajNovogKorisnika(String  ime, String prezime){
        Korisnik novi = new Korisnik(ime, prezime);
        korisnici.add(novi);
        return novi;
    }

    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik novi = new Uposlenik(ime, prezime);
        uposlenici.add(novi);
        return novi;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik korisnik){
        Racun novi = new Racun(korisnik.racun.brojRacuna, korisnik );
        korisnik.dodajRacun(novi);
        return novi;
    }
}
