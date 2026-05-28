import java.util.Scanner;
public class Ejercicio02 {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num, mayor = 0, menor = 0;

        for (int i = 0; i < 10; i++) {

            System.out.print("Ingrese un número: ");
            num = sc.nextInt();

            if (i == 0) {
                mayor = num;
                menor = num;
            }

            if (num > mayor) {
                mayor = num;
            }

            if (num < menor) {
                menor = num;
            }
        }

        System.out.println("Número mayor: " + mayor);
        System.out.println("Número menor: " + menor);
    }
}
