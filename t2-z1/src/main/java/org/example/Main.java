package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Unesite broj: ");
        Scanner unos = new Scanner(System.in);
        int broj = unos.nextInt();
        System.out.println("Faktorijel broja je " + Faktorijel.factorial(broj));
        System.out.println("Sinus broja je " + Sinus.sin(broj));
    }
}