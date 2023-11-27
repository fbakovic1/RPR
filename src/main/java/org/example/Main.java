package org.example;

public class Main {
    public static void main(String[] args) {
        Predmet predmet = new Predmet();
        predmet.setNaziv("Programiranje");
        predmet.setOpis("Učenje programiranja u Javi.");

        InformacijeONastavniku nastavnik = new InformacijeONastavniku();
        nastavnik.setIme("Prof");
        nastavnik.setPrezime("Smith");
        nastavnik.setTitula("PhD");

        // Omogućavanje unosa ocjene za predmet
        Ocjena ocjenaPredmeta = predmet.ocijeni(9);
        System.out.println("Ocjena za predmet " + predmet.getNaziv() + ": " + ocjenaPredmeta.getOcjena());

        // Omogućavanje unosa ocjene za nastavnika (samo student može ocijeniti nastavnika)
        // Ovdje bi trebalo koristiti postojeću osobu koja je student
        Ocjena ocjenaNastavnika = nastavnik.ocijeni(8);
        System.out.println("Ocjena za nastavnika " + nastavnik.getIme() + " " + nastavnik.getPrezime() + ": " + ocjenaNastavnika.getOcjena());
    }
}