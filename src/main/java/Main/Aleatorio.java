/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        System.out.println("Ingrese el largo del arreglo");
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

    public void menu() {

    }
}
