package ba.unsa.etf.rpr;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Laptop implements Serializable {

    private String brend;
    private String model;
    private double cijena;
    private int ram;
    private int hdd;
    private int  ssd;
    private String procesor;
    private String grafickaKartica;
    private double velicinaEkrana;

    @XmlElement
    public void setBrend(String brend) {
        this.brend = brend;
    }

    @XmlElement
    public void setModel(String model) {
        this.model = model;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }

    public Laptop(String brend, String model, double cijena, int ram, int hdd, int ssd, String procesor, String grafickaKartica, double velicinaEkrana) {
        this.brend = brend;
        this.model = model;
        this.cijena = cijena;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
        this.procesor = procesor;
        this.grafickaKartica = grafickaKartica;
        this.velicinaEkrana = velicinaEkrana;
    }

    public Laptop() {
    }

    public void ispisi() {
        System.out.println("Brend: " + this.brend);
        System.out.println("Model: " + this.model);
        System.out.println("Cijena: " + this.cijena);
        System.out.println("RAM: " + this.ram);
        System.out.println("Hdd: " + this.hdd);
        System.out.println("Ssd: " + this.ssd);
        System.out.println("Procesor: " + this.procesor);
        System.out.println("Graficka kartica: " + this.grafickaKartica);
        System.out.println("Velicina ekrana: " + this.velicinaEkrana);
    }

    @XmlElement
    public String getBrend() {
        return brend;
    }

    @XmlElement
    public String getModel() {
        return model;
    }

    @XmlElement
    public double getCijena() {
        return cijena;
    }

    @XmlElement
    public int getRam() {
        return ram;
    }

    @XmlElement
    public int getHdd() {
        return hdd;
    }

    @XmlElement
    public int getSsd() {
        return ssd;
    }

    @XmlElement
    public String getProcesor() {
        return procesor;
    }

    @XmlElement
    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    @XmlElement
    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

}
