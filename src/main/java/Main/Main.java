/*
  1.Ordenamiento de números aleatorios: Deberá crear un programa que sea capaz de generar N números aleatorios,
    siendo N un valor entero positivo ingresado por el usuario, almacenarlos en un arreglo y mostrar el contenido del arreglo. 
    Luego su programa debe ser capaz de ordenar de menor a mayor, usando el método de la burbuja, 
    y mostrar por consola el contenido del arreglo ordenado, además del tiempo que tardó en realizarse.
    De la misma manera se debe poder ordenar de mayor a menor, utilizando el método de la burbuja,
    debe mostrar por consola el contenido del arreglo ordenado, además del el tiempo que tardó en realizarse.
    Por último debe realizar los mismos dos ordenamientos utilizando los métodos de ordenamiento de la clase Arrays,
    mostrando lo mismo que en los pasos anteriores.


    PD:Probandolo con mi notebook, arreglos de largos muy pequeños como largo 10 o hasta largo 2000 se demora tan poco que se a veces aproxima 
    a 0 el tiempo que tarda en en realizarse el ordenamiento, en cambio probe con largo 10000 y aproximadamente se demoraba 5 segundos el ordenamiento.

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
public class Main {

    public static void main(String[] args) {
        System.out.println("----Bienvenidos al sistema de numeros aleatorios----");
        System.out.println("Ingresar el largo del arreglo");
        Integer[] aleatorios = new Integer[leerDimension()];
        llenarArreglo(aleatorios);
        System.out.println("Sus arreglo con numeros aleatorios es: ");
        mostrarArreglo(aleatorios);
        System.out.println("Su arreglo ordenado de menor a mayor por el método de la burbuja es: ");
        long inicio = System.currentTimeMillis();
        mostrarArreglo(burbujaMenorMayor(aleatorios));
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo que tardo es de: " + ((fin-inicio)/1000) +" segundos");
        System.out.println("Su arreglo ordeando de mayor a menor por el método de la burbuja es: ");
        inicio=System.currentTimeMillis();
        mostrarArreglo(burbujaMayorMenor(aleatorios));
        fin =System.currentTimeMillis();
        System.out.println("Tiempo que tardo es de: " + ((fin-inicio)/1000) +" segundos");
        System.out.println("Arreglo ordenado menor a mayor por método de Arrays");
        inicio=System.currentTimeMillis();
        mostrarArreglo(ordenarMenorMayor(aleatorios));
        fin =System.currentTimeMillis();
        System.out.println("Tiempo que tardo es de: " + ((fin-inicio)/1000) +" segundos");
        System.out.println("Arreglo ordenado mayor a menor por método de Arrays");
        inicio=System.currentTimeMillis();
        mostrarArreglo(ordenarMayorMenor(aleatorios));
        fin =System.currentTimeMillis();
        System.out.println("Tiempo que tardo es de: " + ((fin-inicio)/1000) +" segundos");
    }

    /**
     *  Método que lee la dimension del arreglo validando el dato ingresado
     * @return  Dimension del arreglo
     */
    public static int leerDimension() {
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

    /**
     *  Método que llena el arreglo ingresado con numeros aleatorios desde el 1 al 100
     * @param arreglo que se desea rellenar
     */
    public static void llenarArreglo(Integer arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) ((Math.random() * 100) + 1);
        }
    }

    /**
     *  Método que muestra por pantalla el arreglo ingresado
     * @param arreglo que se desea mostar por pantalla
     */
    public static void mostrarArreglo(Integer arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    /**
     *  Método que ordena el arreglo ingresado de menor a mayor, a través del método de la burbuja
     * @param arreglo que se desea ordenar
     * @return arreglo ordenado de menor a mayor
     */
    public static Integer[] burbujaMenorMayor(Integer arreglo[]) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j + 1] < arreglo[j]) {
                    int temporal = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = temporal;
                }
            }
        }
        return arreglo;
    }

    /**
     *  Método que ordena el arreglo ingresado de mayor a menor, a través del método de la burbuja
     * @param arreglo que se desea ordenar
     * @return  arreglo ordenado de mayor a menor
     */
    public static Integer [] burbujaMayorMenor(Integer arreglo[]) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int temporal = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = temporal;
                }
            }
        }
        return arreglo;
    }

    /**
     * Método que ordena el arreglo ingresado de menor a mayor, a través de métodos propios de los Arrays
     * @param arreglo que se desea ordenar
     * @return  arreglo ordenado de menor a mayor
     */
    public static Integer[] ordenarMenorMayor(Integer[] arreglo) {
        Arrays.sort(arreglo);
        return arreglo;
    }

    /**
     * Método que ordena el arreglo ingresado de mayor a menor, a través de métodos propios de los Arrays
     * @param arreglo que se desea ordenar
     * @return arreglo ordenado de mayor a menor
     */
    public static Integer[] ordenarMayorMenor(Integer[] arreglo) {
        Arrays.sort(arreglo, Collections.reverseOrder());
        return arreglo;
    }
}
