/**
 * author: Domingo Pérez
 * Date: 15/10/2020
 */

public class Main {


    /**
     * Método que comprueba si un numero es divisible entre 3 | 5 ó ambos inclusive
     */
    public static void drawPingPong() {
        for (int i = 1; i <= 100; i++) { // recorremos los números de del 1 al 100

            if (i % 3 == 0 && i % 5 == 0) { // se verifica que el resto de la división entre (i, 3) y (i, 5) si y solo si es 0 entonces imprimo PingPong
                System.out.println("PingPong");

            } else if (i % 3 == 0) {
                System.out.println("Ping"); //  se verifica que el resto de la división entre (i, 3) es 0 entonces imprimo Ping

            } else if (i % 5 == 0) {
                System.out.println("Pong"); //  se verifica que el resto de la división entre (i, 5) es 0 entonces imprimo Pong

            } else {
                System.out.println(i); //  si no imprimo el número correspondiente al valor de i
            }
        }
    }

    /**
     * Algoritmo encargado de mostrar por consola en forma de cuadrado el número que recibe como parámetro
     *
     * @param number
     */
    public static void drawNumbersSquared(int number) {
        if (number > 0) {  // compruebo que el numero recibido es mayor que 0

            for (int i = 1; i <= number; i++) { // recorro desde 1 (mínimo valor permitido), hasta el valor que recibido por parametro

                System.out.println(); // imprimo un salto de linea

                if (i == 1 || i == number) { // verifico que si el valor de i es 1 o es igual a cifra recibida por parametro

                    for (int j = 1; j <= number; j++) { // hago un segundo recorrido desde j con valor 1 hasta el numero recibido por parametro

                        System.out.print(number + " "); // imprimo el numero recibido junto a el espaciado pertinente

                    }
                } else { // si i no es 1 ni es igual al valor recibido por parametro entonces

                    for (int k = 1; k <= number; k++) { // hago un tercer recorrigo desde k igual 1 a el numero que recibo por parametro

                        if (k == 1 || k == number) { // vuelvo a verificar si el valor de i es 1 o es igual a cifra recibida por parametro

                            System.out.print(number + " "); // imprimo el numero recibido por parametro junto al espacio correspondiente

                        } else { // sino

                            System.out.print("  ");  // imprimo un espacio en blanco (este será clave para la forma de Square)

                        }
                    }
                }
            }

        } else {
            System.out.println(); // si es 0 o menor, imprimo linea vacia
        }
    }

    /**
     * Algoritmo de búsqueda basado el en método matemático divide y venceras.
     *
     * @param unsorted
     * @param izq
     * @param der
     */
    public static void quicksort(int[] unsorted, int izq, int der) {

        int pivote = unsorted[izq]; // tomamos primer elemento como pivote
        int i = izq;         // i realiza la búsqueda de izquierda a derecha
        int j = der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {                          // mientras no se crucen las búsquedas
            while (unsorted[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while (unsorted[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux = unsorted[i];                      // los intercambia
                unsorted[i] = unsorted[j];
                unsorted[j] = aux;
            }
        }

        unsorted[izq] = unsorted[j];      // se coloca el pivote en su lugar de forma que tendremos
        unsorted[j] = pivote;      // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1)
            quicksort(unsorted, izq, j - 1);          // ordenamos subarray izquierdo
        if (j + 1 < der)
            quicksort(unsorted, j + 1, der);          // ordenamos subarray derecho

    }


    public static void main(String[] args) {

        drawPingPong();

        drawNumbersSquared(4);

        int[] unsorted = {7, 2, 6, 1, 8, 4, 5}; // array desordenado
        int ult = unsorted.length - 1; // ultima posición del array
        int der = unsorted[ult];

        System.out.println(); // salto de linea

        for (int i = 0; i < unsorted.length; i++) {
            System.out.print(" " + unsorted[i] + ", "); // array desordenado
        }
        quicksort(unsorted, 0, der); // llamo al método quicksort()

        for (int i = 0; i < unsorted.length; i++) {
            System.out.print(" " + unsorted[i] + ", "); // array ordenado
        }


    }
}
