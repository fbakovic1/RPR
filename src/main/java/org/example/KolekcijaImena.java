package org.example;

import java.util.ArrayList;
import java.util.List;

class KolekcijaImena {
    private List<String> imenaIPrezimena = new ArrayList<>();

    public KolekcijaImena(List<String> imenaIPrezimena) {
        this.imenaIPrezimena = imenaIPrezimena;
    }

    public String getNajduzeIme() {
        String najduzeIme = "";
        for (String ime : imenaIPrezimena) {
            if (ime.length() > najduzeIme.length()) {
                najduzeIme = ime;
            }
        }
        return najduzeIme;
    }
}