package ba.unsa.etf.rpr;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
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

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, laptopi);
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
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (file.length() == 0) {
                System.out.println("Datoteka je prazna.");
                return new ArrayList<>();
            }
            Laptop[] laptopArray = objectMapper.readValue(file, Laptop[].class);

            return new ArrayList<>(Arrays.asList(laptopArray));
        } catch (IOException e) {
            System.out.println("Greška prilikom čitanja podataka iz datoteke.");
            return new ArrayList<>();
        }
    }
}