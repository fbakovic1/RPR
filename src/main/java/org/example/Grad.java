package org.example;

public enum Grad {
    SARAJEVO("033"), TUZLA("035"), ZENICA("032"), BIHAC("037"), BANJALUKA("051"), MOSTAR("031");
    private String pozivni;
    Grad(String poz) {
        this.pozivni = poz;
    }

    @Override
    public String toString(){
        return pozivni;
    }
}
