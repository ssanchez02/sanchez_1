/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

  1.Ordenamiento de números aleatorios: Deberá crear un programa que sea capaz de generar N números aleatorios,
    siendo N un valor entero positivo ingresado por el usuario, almacenarlos en un arreglo y mostrar el contenido del arreglo. 
    Luego su programa debe ser capaz de ordenar de menor a mayor, usando el método de la burbuja, 
    y mostrar por consola el contenido del arreglo ordenado, además del tiempo que tardó en realizarse.
    De la misma manera se debe poder ordenar de mayor a menor, utilizando el método de la burbuja,
    debe mostrar por consola el contenido del arreglo ordenado, además del el tiempo que tardó en realizarse.
    Por último debe realizar los mismos dos ordenamientos utilizando los métodos de ordenamiento de la clase Arrays,
    mostrando lo mismo que en los pasos anteriores.

Debe validar las entradas acorde a la especificación.
 */
package Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sebastián Sanchez
 */
public class Aleatorio {

    

    public int leerDimension() {
        Scanner teclado = new Scanner(System.in);
        int dimension;
        try {
            dimension = teclado.nextInt();
            if (dimension < 0) {
                dimension = leerDimension();
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un dato valido");
            dimension = leerDimension();
        }
        return dimension;
    }

    public void llenarArreglo(Integer arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) ((Math.random() * 100) + 1);
        }
    }

    public void mostrarArreglo(Integer arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    public void burbujaMenorMayor(Integer arreglo[]) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j + 1] < arreglo[j]) {
                    int temporal = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = temporal;
                }
            }
        }
    }

    public void burbujaMayorMenor(Integer arreglo[]) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int temporal = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = temporal;
                }
            }
        }

    }

    public Integer[] ordenarMenorMayor(Integer[] arreglo) {
        Arrays.sort(arreglo);
        return arreglo;
    }

    public Integer[] ordenarMayorMenor(Integer[] arreglo) {
         Arrays.sort(arreglo,Collections.reverseOrder());
        return arreglo;
    }

    public void menu() {
                  
            System.out.println("----Bienvenidos al sistema de numeros aleatorios----");
            System.out.println("Ingresar el largo del arreglo");
            Integer[] aleatorios = new Integer[leerDimension()];
            llenarArreglo(aleatorios);
            System.out.println("Sus arreglo con numeros aleatorios es: ");
            mostrarArreglo(aleatorios);
            System.out.println("");
            System.out.println("Su arreglo ordenado de menor a mayor por el método de la burbuja es: ");
            burbujaMenorMayor(aleatorios);
            mostrarArreglo(aleatorios);
            System.out.println("");
            System.out.println("Su arreglo ordeando de mayor a menor por el método de la burbuja es: ");
            burbujaMayorMenor(aleatorios);
            mostrarArreglo(aleatorios);
            System.out.println("");
            System.out.println("Arreglo ordenado menor a mayor por método de Arrays");
            mostrarArreglo(ordenarMenorMayor(aleatorios));
            System.out.println("");
            System.out.println("Arreglo ordenado mayor a menor por método de Arrays");
            mostrarArreglo(ordenarMayorMenor(aleatorios));
       
    }
}
