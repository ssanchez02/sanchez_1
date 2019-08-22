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

    public void llenarArreglo(int arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) ((Math.random() * 100) + 1);
        }
    }

    public void mostrarArreglo(int arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }

    public void burbujaMenorMayor(int arreglo[]) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; i++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int temporal = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = temporal;
                }
            }
        }
    }

    public void burbujaMayorMenor(int arreglo[]) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; i++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temporal;
                }
            }
        }

    }

    public void menu() {
        boolean bandera = true;
        while (bandera) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("----Bienvenidos al sistema de numeros aleatorios----");
            System.out.println("Ingresar el largo del arreglo");
            int[] aleatorios = new int[leerDimension()];
            System.out.println("1.-Llenar arreglo\n2.Ordenar de Menor a Mayor por método de burbuja-\n3.-Ordenar de Mayor a Menor por método de burbuja");
            System.out.println("4.-");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    llenarArreglo(aleatorios);
                    System.out.println("Sus arreglo es: ");
                    mostrarArreglo(aleatorios);
                    break;
                case 2:
                    burbujaMenorMayor(aleatorios);
                    break;
                case 3:
                    bandera = false;
                    break;
            }

        }
    }
}
