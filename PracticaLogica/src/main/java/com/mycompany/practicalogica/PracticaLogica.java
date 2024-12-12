/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practicalogica;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class PracticaLogica {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner lector = new Scanner(System.in);
        boolean entradaValida = false;
        System.out.println("Ingresa un número para saber si es par o impar");

        while (!entradaValida) {
            try {
                int num = lector.nextInt();
                System.out.println(esPar(num) ? "El número " + num + " es par" : "El número " + num + " es impar");
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número entero");
                lector.next();
            }
        }
        entradaValida = false;
        
        System.out.println("Ingresa un número para saber si es primo");
        while (!entradaValida) {
            try {
                int numero = lector.nextInt();
                System.out.println(esPrimo(numero) ? "El número " + numero + " es primo" : "El número " + numero + " no es primo");
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número entero");
                lector.next();
            }
        }
        entradaValida = false;
        
        System.out.println("Ingresa una cantidad mínima de números primos a listar");
        while (!entradaValida) {
            try {
                int numero = lector.nextInt();
                numerosPrimos(numero);
                entradaValida = true;
            } catch (InputMismatchException e) {
                 System.out.println("Ingrese un número entero");
                lector.next();
            }
        }
        
        entradaValida = false;
       
    }

    public static boolean esPar(int num) {
        boolean resultado = false;

        if (num % 2 == 0) {
            resultado = true;
        }
        return resultado;
    }

    public static boolean esPrimo(int num) {
        int contador = 0;
        int i = 1;
        boolean resultado = false;
        while (i <= num && contador <= 2) {
            if (num % i == 0) {
                contador++;
            }
            i++;
        }
        if (contador == 2) {
            resultado = true;
        }
        return resultado;
    }

    public static void numerosPrimos(int cantidad) {
        int contador = 0;
        String numeros = "";

        for (int i = 0; contador < cantidad; i++) {
            if (esPrimo(i)) {
                numeros += i + "/ ";
                contador++;
            }
        }
        System.out.println(numeros);
    }
}
