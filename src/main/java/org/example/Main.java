package org.example;

public class Main {
    public static void main(String[] args) {
        // Primjeri korištenja klasa
        LicneInformacije osoba1 = new LicneInformacije();
        osoba1.setIme("Kerim");
        osoba1.setPrezime("Sakic");

        InformacijeOStudentu student = new InformacijeOStudentu();
        student.setIme("Tarik");
        student.setPrezime("Kalajdzija");
        student.setGodinaStudija("3");
        student.setBrojIndexa("12345");

        InformacijeONastavniku nastavnik = new InformacijeONastavniku();
        nastavnik.setIme("Prof");
        nastavnik.setPrezime("Ja");
        nastavnik.setTitula("Samic");

        Predmet predmet = new Predmet();
        predmet.setNaziv("Programiranje");
        predmet.setOpis("Učenje programiranja u Javi.");

        // Kolekcija poruka sa objektima različitih klasa
        KolekcijaPoruka kolekcija = new KolekcijaPoruka(new Object[]{osoba1, student, nastavnik, predmet});

        // Ispis poruka
        for (String poruka : kolekcija.getPoruke()) {
            System.out.println(poruka);
        }
    }
}