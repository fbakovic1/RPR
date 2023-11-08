package org.example;
import java.util.*;

public class Imenik {

    private HashMap<String, TelefonskiBroj> brojevi;

    public Imenik(){
        this.brojevi = new HashMap<String, TelefonskiBroj>();
    }

    public Map<String, TelefonskiBroj> getBrojevi() {
        return brojevi;
    }

    public void setBrojevi(HashMap<String, TelefonskiBroj> brojevi) {
        this.brojevi = brojevi;
    }

    public void dodaj(String ime, TelefonskiBroj broj){ brojevi.put(ime,broj); }

    public String dajBroj(String ime){
        TelefonskiBroj broj = this.brojevi.get(ime);
        if (broj != null){
            return broj.ispisi();
        }
        return null;
    }

    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String,TelefonskiBroj> entry : this.brojevi.entrySet()){
            if(entry.getValue().ispisi().equals(broj.ispisi())){
                return entry.getKey();
            }
        }
        return null;
    }

    public String naSlovo(char s){
        StringBuilder builder = new StringBuilder();
        int brojac = 1;
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){
            if (entry.getKey().startsWith(String.valueOf(s))) {
                builder.append(brojac)
                        .append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
                brojac++;
            }
        }
        return builder.toString();
    }

    public Set<String> izGrada(Grad g){
        Set<String> skup = new TreeSet<String>();

        for(Map.Entry<String,TelefonskiBroj> entry : this.brojevi.entrySet()){
            if(jelIzGrada(entry.getValue(), g)) {
                skup.add(entry.getKey());
            }
        }
        return skup;
    }

    private boolean jelIzGrada(TelefonskiBroj broj, Grad g) {
        if (broj instanceof FiksniBroj) {
            return g.equals(((FiksniBroj) broj).getGrad());
        }
        else {
            return false;
        }
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> skup = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });

        for(Map.Entry<String,TelefonskiBroj> entry : brojevi.entrySet()){
            if (jelIzGrada(entry.getValue(), g)) {
                skup.add(entry.getValue());
            }
        }
        return skup;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int brojac = 1;
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){
            builder.append(brojac)
                    .append(". ")
                    .append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue().ispisi())
                    .append(System.lineSeparator());
            brojac++;
        }
        return builder.toString();
    }
}