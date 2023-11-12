package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LaptopDaoJSONFileTest {
    @Test
    void getLaptop_VracaLaptopZaZadatiProcesor() throws NeodgovarajuciProcesorException {
        LaptopDaoJSONFile dao = new LaptopDaoJSONFile(new File("test.json"));
        Laptop laptop = new Laptop("Brand", "Model", 1000.0, 8, 512, 256, "Processor", "GPU", 15.6);
        dao.dodajLaptopUListu(laptop);

        Laptop result = dao.getLaptop("Processor");

        assertEquals(laptop, result);
    }

    @Test
    void vratiPodatkeIzDatoteke_VracaPraznuListuZaPraznuDatoteku() {
        // Koristit cemo mocking da bismo izbjegli kreiranje stvarnog file. Kada kreiramo stvarne filove
        // u testovima, moze se desiti da se desi nesto neocekivano, npr. da nemamo dozvolu da kreiramo file
        // u tom operativnom sistemu. Zato kreiramo mock objekat umjesto stvarnog file-a.
        File mockFile = Mockito.mock(File.class);
        when(mockFile.length()).thenReturn(0L);

        LaptopDaoJSONFile dao = new LaptopDaoJSONFile(mockFile);

        assertEquals(new ArrayList<>(), dao.vratiPodatkeIzDatoteke());
    }
}