package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> imenaIPrezimena1 = new ArrayList<>();
        imenaIPrezimena1.add("Ana Anić");
        imenaIPrezimena1.add("Ivan Ivanić");

        KolekcijaImena kolekcija1 = new KolekcijaImena(imenaIPrezimena1);
        Pobjednik pobjednik1 = new Pobjednik(kolekcija1);

        System.out.println("Pobjednik 1:");
        System.out.println("Ime: " + pobjednik1.getIme());
        System.out.println("Prezime: " + pobjednik1.getPrezime());
        System.out.println("Broj znakova: " + pobjednik1.getBrojZnakova());

        List<String> imena2 = new ArrayList<>();
        List<String> prezimena2 = new ArrayList<>();
        imena2.add("Marko");
        imena2.add("Jelena");
        prezimena2.add("Marković");
        prezimena2.add("Jelenić");

        KolekcijaImenaIPrezimena kolekcija2 = new KolekcijaImenaIPrezimena(imena2, prezimena2);
        Pobjednik pobjednik2 = new Pobjednik(kolekcija2);

        System.out.println("\nPobjednik 2:");
        System.out.println("Ime: " + pobjednik2.getIme());
        System.out.println("Prezime: " + pobjednik2.getPrezime());
        System.out.println("Broj znakova: " + pobjednik2.getBrojZnakova());
    }
}