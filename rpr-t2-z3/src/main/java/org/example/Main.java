package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main
{
    public static void main( String[] args )
    {
        Scanner unos = new Scanner(System.in);
        List<Double> lista = new ArrayList<>();

        System.out.println("Unesite broj (stop za prekid)");

        for(;;){
            if(unos.hasNextDouble()) lista.add(unos.nextDouble());
            else if(unos.next().equalsIgnoreCase("stop")) break;

        }

        double standDev=0;
        double srVr=0;

        for(Double i : lista) srVr+=i;
        srVr/=lista.size();

        for(Double i : lista) standDev+= Math.pow((i-srVr),2);
        standDev/=lista.size();
        standDev=Math.sqrt(standDev);

        int br = 1;
        for(Double i : lista) {
            System.out.println(br + ". clan " + i);
            br++;
        }
        System.out.println("Najmanji element liste je: " + Collections.min(lista));
        System.out.println("Najveci element liste je: " + Collections.max(lista));
        System.out.println("Srednja vrijednost liste je:" + srVr);
        System.out.println("Standardna devijacija liste je: " + standDev);
    }


}