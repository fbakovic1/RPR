package org.example;

class KolekcijaPoruka {
    private String[] poruke;

    // Konstruktor koji prima listu klasa koje imaju metodu predstavi()
    public KolekcijaPoruka(Object[] objekti) {
        this.poruke = new String[objekti.length];
        for (int i = 0; i < objekti.length; i++) {
            if (objekti[i] instanceof LicneInformacije) {
                poruke[i] = ((LicneInformacije) objekti[i]).getIme() + " " + ((LicneInformacije) objekti[i]).getPrezime();
            } else if (objekti[i] instanceof InformacijeOStudentu) {
                poruke[i] = ((InformacijeOStudentu) objekti[i]).getIme() + " " +
                        ((InformacijeOStudentu) objekti[i]).getPrezime() + " - " +
                        ((InformacijeOStudentu) objekti[i]).getBrojIndexa();
            } else if (objekti[i] instanceof InformacijeONastavniku) {
                poruke[i] = ((InformacijeONastavniku) objekti[i]).getIme() + " " +
                        ((InformacijeONastavniku) objekti[i]).getPrezime() + " - " +
                        ((InformacijeONastavniku) objekti[i]).getTitula();
            } else if (objekti[i] instanceof Predmet) {
                poruke[i] = "Predmet: " + ((Predmet) objekti[i]).getNaziv() + " - " +
                        ((Predmet) objekti[i]).getOpis();
            }
        }
    }

    // Metoda za dohvaćanje liste poruka
    public String[] getPoruke() {
        return poruke;
    }
}