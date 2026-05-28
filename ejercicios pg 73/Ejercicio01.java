import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int suma = 0;
        double promedio;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese un número: ");
            int num = sc.nextInt();

            suma += num;
        }

        promedio = suma / 10.0;

        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + promedio);
    }
}
