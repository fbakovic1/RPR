package ba.unsa.etf.rpr;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LaptopDaoXMLFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();

        laptopi = vratiPodatkeIzDatoteke();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        dodajLaptopUListu(laptop);

        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(file, laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException(("Nema laptopa sa traženim procesorom: " + procesor));
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Laptop[] laptopArray = xmlMapper.readValue(file, Laptop[].class);
            return new ArrayList<>(Arrays.asList(laptopArray));
        } catch (IOException e) {
            System.out.println("Greška prilikom čitanja podataka iz datoteke.");
            return new ArrayList<>();
        }
    }
}