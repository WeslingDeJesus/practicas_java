import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] A = new int[3][3];
        int[][] B = new int[3][3];

        int[][] suma = new int[3][3];
        int[][] producto = new int[3][3];

        // Ingresar matriz A
        System.out.println("Ingrese matriz A:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = sc.nextInt();
            }
        }

        // Ingresar matriz B
        System.out.println("Ingrese matriz B:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                B[i][j] = sc.nextInt();
            }
        }

        // Multiplicar matriz por número
        System.out.print("Ingrese un número multiplicador: ");
        int num = sc.nextInt();

        System.out.println("Matriz A multiplicada:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((A[i][j] * num) + "\t");
            }
            System.out.println();
        }

        System.out.println("Matriz B multiplicada:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((B[i][j] * num) + "\t");
            }
            System.out.println();
        }

        // Suma de matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                suma[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("Suma de matrices:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(suma[i][j] + "\t");
            }
            System.out.println();
        }

        // Producto de matrices
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                producto[i][j] = 0;

                for (int k = 0; k < 3; k++) {
                    producto[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("Producto de matrices:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(producto[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
