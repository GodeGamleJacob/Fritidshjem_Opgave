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
                    out.writeInt(array[i].getAntal());
                    out.writeUTF(array[i].getVarer());
                    out.writeDouble(array[i].getPris());
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
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("Varer.ser"));

                while (input.available() > 0) {
                array[i].setAntal(input.readInt());
                array[i].setVarer(input.readUTF());
                array[i].setPris(input.readDouble());
                }
                input.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return i;
        }



        public static void udskriv (Vare [] a, int antal) {

            for (int i = 0; i < antal; i++) {
                System.out.format("%d %s %.2f \n",a[i].getAntal(),a[i].getVarer(),a[i].getPris());

            }
        }
}
