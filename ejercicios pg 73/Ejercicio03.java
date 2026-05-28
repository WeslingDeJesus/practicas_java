import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[10];

        System.out.print("Ingrese el divisor: ");
        int divisor = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese un número: ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("Múltiplos de " + divisor + ":");

        for (int i = 0; i < 10; i++) {

            if (numeros[i] % divisor == 0) {
                System.out.println(numeros[i] + " es múltiplo");
            }
        }
    }
}
