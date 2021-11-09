package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Vare vare = new Vare();

        Vare[] array = new Vare[20];

        for (int i = 0; i < 20; i++) {
            array[i] = new Vare();
        }

        int antalVarer;

        antalVarer = laesFraFil(array);

        udskriv(array, antalVarer);

        skrivDataFil(array, antalVarer);

        udskriv(array, antalVarer);

        antalVarer = laesDataFil(array);

        udskriv(array, antalVarer);

        samletPris(array, antalVarer);

    }
        //Skrivning til txt.fil
        public static int laesFraFil(Vare[] array) throws FileNotFoundException {

            File bestilling = new File("Bestilling.txt");

            Scanner input = new Scanner(bestilling);

            int i = 0;

            while (input.hasNext()) {

                array[i].setAntal(input.nextInt());
                array[i].setVarer(input.next());
                array[i].setPris(input.nextDouble());
                i++;

            }

            return i;
        }
        //Skrivning til ser.fil
        public static void skrivDataFil(Vare [] array, int antal) throws FileNotFoundException {

            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Varer.ser"));

                for (int i = 0; i < antal; i++) {
                    out.writeObject(array[i]);
                }

            out.close();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        //Læsning fra ser.fil
        public static int laesDataFil(Vare [] array) throws FileNotFoundException {

        int i = 0;

            try {
                FileInputStream f = new FileInputStream("Varer.ser");

                ObjectInputStream input = new ObjectInputStream(f);

                while (f.available() > 0) {
                array[i] = (Vare) input.readObject();
                i++;
                }

                input.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return i;
        }

        public static void samletPris (Vare [] a, int antal) {

            System.out.format("\n%-20s %20s\n", "Varenavn", "Samlet pris");

            for (int i = 0; i < antal; i++) {

                System.out.format("%-20s  %20.2f \n", a[i].getVarer(), a[i].getAntal() * a[i].getPris());

            }

        }

        public static void udskriv (Vare [] a, int antal) {

            for (int i = 0; i < antal; i++) {

                System.out.format("%d %s %.2f \n",a[i].getAntal(),a[i].getVarer(),a[i].getPris());

            }
        }
}


/*
-	Lav funktion som beregner den samlede pris for hver vare med og uden rabat.
-	Lav funktion, som beregner saldoen for det samlede varekøb med og uden rabatter.
-	Lav funktion, som udskriver faktura hvor der er informationer om: hvilke varer der er købt, antallet af hver vare,
-   prisen for hver vare med og uden rabat, og den samlede saldo med og uden rabat.
Fakturaen skal både udskrives til skærm og til en ny tekstfil ”faktura.txt”.
 */