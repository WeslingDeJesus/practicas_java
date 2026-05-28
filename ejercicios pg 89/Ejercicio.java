import java.util.Scanner;
public class Ejercicio {
         public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Datos del perro
        System.out.println("=== DATOS DEL PERRO ===");

        System.out.print("Nombre: ");
        String nombrePerro = sc.nextLine();

        System.out.print("Raza: ");
        String razaPerro = sc.nextLine();

        System.out.print("Fecha de nacimiento: ");
        String fechaPerro = sc.nextLine();

        System.out.print("Peso: ");
        float pesoPerro = sc.nextFloat();
        sc.nextLine();

        System.out.print("Lugar de entrenamiento: ");
        String lugar = sc.nextLine();

        Perro perro = new Perro(
                nombrePerro,
                razaPerro,
                fechaPerro,
                pesoPerro,
                lugar
        );

        System.out.println();

        // Datos del gato
        System.out.println("=== DATOS DEL GATO ===");

        System.out.print("Nombre: ");
        String nombreGato = sc.nextLine();

        System.out.print("Raza: ");
        String razaGato = sc.nextLine();

        System.out.print("Fecha de nacimiento: ");
        String fechaGato = sc.nextLine();

        System.out.print("Peso: ");
        float pesoGato = sc.nextFloat();

        System.out.print("Altura de salto: ");
        double salto = sc.nextDouble();

        Gato gato = new Gato(
                nombreGato,
                razaGato,
                fechaGato,
                pesoGato,
                salto
        );

        // Mostrar datos
        System.out.println("\n=== INFORMACIÓN DEL PERRO ===");
        perro.mostrarDatos();
        perro.comer();
        perro.comunicarse();

        System.out.println("\n=== INFORMACIÓN DEL GATO ===");
        gato.mostrarDatos();
        gato.comer();
        gato.comunicarse();
    }
}
