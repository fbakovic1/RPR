package org.example;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Imenik {

    private HashMap<String, TelefonskiBroj> mapa;

    public Imenik(){ mapa = new HashMap<>(); }

    public void dodaj(String ime, TelefonskiBroj broj){ mapa.put(ime,broj); }

    public String dajBroj(String ime){ return mapa.get(ime).ispisi(); }

    public String dajIme(String broj){
        String ime="";
        for(HashMap.Entry<String,TelefonskiBroj> entry : mapa.entrySet()){
            if(entry.getValue().equals(broj)){
                ime = new String(entry.getKey());
                break;
            }
        }
        return ime;
    }

    public String naSlovo(char s){
        String imena = "";
        int br = 1;
        for(HashMap.Entry<String,TelefonskiBroj> entry : mapa.entrySet()){
            if(entry.getKey().charAt(0) == s){
                imena += br + ". " + entry.getKey() + " - " + entry.getValue().ispisi() + "\n";
                br++;
            }
        }
        return imena;
    }

    public Set<String> izGrada(Grad g){
        Set<String> skup = new TreeSet<>();

        for(HashMap.Entry<String,TelefonskiBroj> entry : mapa.entrySet()){
            if(entry.getValue() instanceof FiksniBroj){
                FiksniBroj temp = (FiksniBroj) entry.getValue();
                if(temp.dajGrad().equals(g)) {
                    skup.add(entry.getKey());
                }
            }
        }
        return skup;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> skup = new TreeSet<>();

        for(HashMap.Entry<String,TelefonskiBroj> entry : mapa.entrySet()){
            if(entry.getValue() instanceof FiksniBroj){
                FiksniBroj temp = (FiksniBroj) entry.getValue();
                if(temp.dajGrad().equals(g)) {
                    skup.add(entry.getValue());
                }
            }
        }
        return skup;
    }
}