package org.example;

public class Osoba {
    private String ime;
    private String prezime;

    public Osoba(Osoba xy){
        ime= xy.ime;
        prezime= xy.prezime;
    }
    public Osoba(String ime, String prezime){
        this.ime= ime;
        this.prezime= prezime;
    }
        @Override
        public String toString() {
        return  ime + " " + prezime ;
    }
}
