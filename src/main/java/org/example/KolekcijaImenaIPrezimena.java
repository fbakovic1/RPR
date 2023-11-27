package org.example;

import java.util.ArrayList;
import java.util.List;

class KolekcijaImenaIPrezimena {
    private List<String> imena = new ArrayList<>();
    private List<String> prezimena = new ArrayList<>();

    public KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }

    public int getIndexNajduzegPara() {
        int indeks = 0;
        int najduzi = 0;
        for (int i = 0; i < imena.size(); i++) {
            String imePrezime = imena.get(i) + prezimena.get(i);
            if (imePrezime.length() > najduzi) {
                najduzi = imePrezime.length();
                indeks = i;
            }
        }
        return indeks;
    }

    public String getImeiPrezime(int i) {
        return imena.get(i) + " " + prezimena.get(i);
    }
}
