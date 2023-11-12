package ba.unsa.etf.rpr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Odaberite format datoteke:");
        System.out.println("1. Serializable (.ser)");
        System.out.println("2. JSON (.json)");
        System.out.println("3. XML (.xml)");

        int formatOpcija = scanner.nextInt();
        scanner.nextLine();  

        switch (formatOpcija) {
            case 1:
                File file = createNewFile("laptopi.ser");
                LaptopDaoSerializableFile daoSerializable = new LaptopDaoSerializableFile(file);
                testiranjeMetoda(daoSerializable);
                break;
            case 2:
                file = createNewFile("laptopi.json");
                LaptopDaoJSONFile daoJSON = new LaptopDaoJSONFile(file);
                testiranjeMetoda(daoJSON);
                break;
            case 3:
                file = createNewFile("laptopi.xml");
                LaptopDaoXMLFile daoXML = new LaptopDaoXMLFile(file);
                testiranjeMetoda(daoXML);
                break;
            default:
                System.out.println("Nepoznat format datoteke. Kraj programa.");
        }
    }

    private static void testiranjeMetoda(LaptopDao dao) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nIzaberite opciju:");
            System.out.println("1. Dodaj laptop");
            System.out.println("2. Pretraga laptopa po procesoru");
            System.out.println("3. Prikazi sve laptope");
            System.out.println("4. Kraj");
            System.out.println("Unos: ");

            int opcija = scanner.nextInt();
            scanner.nextLine();  

            switch (opcija) {
                case 1:
                    dodajLaptop(dao, scanner);
                    break;
                case 2:
                    pretragaPoProcesoru(dao, scanner);
                    break;
                case 3:
                    prikaziSveLaptope(dao);
                    break;
                case 4:
                    System.out.println("Kraj programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nepoznata opcija.");
            }
        }
    }

    private static File createNewFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Greska prilikom kreiranja datoteke.");
            e.printStackTrace();
        }
        return file;
    }

    private static void dodajLaptop(LaptopDao dao, Scanner scanner) {
        System.out.println("Unesite podatke za laptop:");

        System.out.print("Brend: ");
        String brend = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Cijena: ");
        double cijena = scanner.nextDouble();
        scanner.nextLine();  

        System.out.print("RAM: ");
        int ram = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("HDD: ");
        int hdd = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("SSD: ");
        int ssd = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Procesor: ");
        String procesor = scanner.nextLine();

        System.out.print("Grafička kartica: ");
        String grafickaKartica = scanner.nextLine();

        System.out.print("Veličina ekrana: ");
        double velicinaEkrana = scanner.nextDouble();
        scanner.nextLine();  

        Laptop noviLaptop = new Laptop(brend, model, cijena, ram, hdd, ssd, procesor, grafickaKartica, velicinaEkrana);

        dao.dodajLaptopUFile(noviLaptop);
        System.out.println("Laptop dodat.");
    }

    private static void pretragaPoProcesoru(LaptopDao dao, Scanner scanner) {
        System.out.print("Unesite procesor za pretragu: ");
        String procesor = scanner.nextLine();

        try {
            Laptop laptop = dao.getLaptop(procesor);
            System.out.println("Pronađen laptop: ");
            laptop.ispisi();
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void prikaziSveLaptope(LaptopDao dao) {
        ArrayList<Laptop> laptopi = dao.vratiPodatkeIzDatoteke();
        System.out.println("Lista svih lapotopa:");

        int counter = 1;
        for (Laptop laptop : laptopi) {
            System.out.println(counter + ". Laptop");
            laptop.ispisi();
            counter++;
        }
    }
}