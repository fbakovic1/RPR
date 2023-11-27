package org.example;

import java.util.ArrayList;
import java.util.List;

class InformacijeONastavniku extends LicneInformacije implements MozeOcijeniti {
    private String titula;
    private List<Ocjena> ocjene = new ArrayList<>();

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }

    @Override
    public Ocjena ocijeni(int x) {
        LicneInformacije osoba = new LicneInformacije(); // Ovdje bi bilo prikladno koristiti već postojeću osobu
        Ocjena novaOcjena = new Ocjena(osoba, x);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }
}