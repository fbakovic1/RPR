package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Unesite broj n: ");
        int n = scan.nextInt();
        for(int i = 1; i < n; i++){
            if(jeDjeljiv(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean jeDjeljiv(int number){
        int suma = sumaCifara(number);
        return number%suma == 0;
    }

    private static int sumaCifara(int number){
        int suma = 0;
        while(number > 0){
            suma += number % 10;
            number = number / 10;
        }
        return suma;
    }
}