import java.util.Scanner;

public class Ejercicio04 {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arreglo = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese un número: ");
            arreglo[i] = sc.nextInt();
        }

        System.out.print("Número a buscar: ");
        int buscar = sc.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < 10; i++) {

            if (arreglo[i] == buscar) {
                System.out.println("Número encontrado en la posición: " + i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Número no encontrado");
        }
    }
}
