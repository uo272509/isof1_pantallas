/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is2022g33.helpers;

import java.util.Random;

/**
 *
 * @author UO272509
 */
public abstract class Nombres {

    public static String randomNombre(int minLength, int maxLength) {
        Random rand = new Random();
        String name = "";
        char vocals[] = new char[]{'a', 'e', 'i', 'o', 'u'};

        char prev = 0;

        for (int i = 0; i < rand.nextInt(maxLength - minLength) + minLength; i++) {
            int letter;

            if (prev != 0 && !isVocal(prev)) {
                if (rand.nextFloat() < 0.2) {
                    letter = rand.nextInt(25) + 97;
                } else {
                    letter = vocals[rand.nextInt(5)];
                }
            } else {
                letter = rand.nextInt(25) + 97;
            }

            if (i == 0) {
                letter -= 32;
            }

            prev = (char) letter;

            name += (char) letter;
        }

        return name;
    }
    
    public static String randomNombre() {
        return randomNombre(4, 10);
    }

    public static String randomApellidos() {
        Random r = new Random();
        String rand = r.nextInt(100)<10?"del ":"";
        
        return randomNombre(6, 10) + " " + rand + randomNombre(6, 10);
    }

    public static String randomDNI() {
        Random rand = new Random();
        String dni = "";
        
        for(int i=0; i<8; i++)
            dni += Integer.toString(rand.nextInt(10));
        
        return dni + Character.toUpperCase((char)(rand.nextInt(25) + 97));
    }

    /**
     * Generates a random phone number (starting with 6 or 7, Spanish prefixes)
     *
     * @return
     */
    public String phone() {
        Random rand = new Random();
        String phone = Math.random() > 0.5 ? "6" : "7";

        for (int i = 0; i < 4; i++) {
            int n = rand.nextInt(99);

            if (n < 0) {
                phone += "0";
            }

            phone += n + " ";
        }

        return phone;
    }

    /**
     * This is a lazy implementation to check if a character is a vocal.
     *
     * @param character
     * @return
     */
    private static boolean isVocal(char c) {
        char vocals[] = new char[]{'a', 'e', 'i', 'o', 'u'};

        for (char v : vocals) {
            if (c == v) {
                return true;
            }
        }

        return false;
    }
}
