package org.example;

public enum Grad {
    BUGOJNO("030"),
    FOJNICA("030"),
    JAJCE("030"),
    ORASJE("031"),
    ODZAK("031"),
    KAKANJ("032"),
    TESANJ("032"),
    VISOKO("032"),
    ZENICA("032"),
    TRNOVO("033"),
    SARAJEVO("033"),
    DRVAR("034"),
    GLAMOC("034"),
    TUZLA("035"),
    ZIVINICE("035"),
    NEUM("036"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038"),
    BRCKO("049"),
    KUPRES("050"),
    BANJALUKA("051"),
    PRIJEDOR("052"),
    DOBOJ("053"),
    BIJELJINA("055"),
    ZVORNIK("056"),
    PALE("057"),
    FOCA("058"),
    TREBINJE("059");


    private String pozivni;

    Grad(String poz) {
        this.pozivni = poz;
    }

    public static Grad izPozivnog(String pozivni){
        for(Grad g: Grad.values()){
            if(g.getPozivniBroj().equals(pozivni)){
                return g;
            }
        }
        return null;
    }

    public String getPozivniBroj(){
        return pozivni;
    }
}
