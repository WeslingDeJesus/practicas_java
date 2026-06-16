import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== DATOS DEL PERRO ===");

        System.out.print("Nombre: ");
        String nombrePerro = sc.nextLine();

        System.out.print("Raza: ");
        String razaPerro = sc.nextLine();

        System.out.print("Fecha Nacimiento: ");
        String fechaPerro = sc.nextLine();

        System.out.print("Peso: ");
        float pesoPerro = sc.nextFloat();
        sc.nextLine();

        System.out.print("Lugar de Entrenamiento: ");
        String lugar = sc.nextLine();

        Perro perro = new Perro(
                nombrePerro,
                razaPerro,
                "Perro",
                fechaPerro,
                pesoPerro,
                lugar
        );

        System.out.println("\n=== DATOS DEL GATO ===");

        System.out.print("Nombre: ");
        String nombreGato = sc.nextLine();

        System.out.print("Raza: ");
        String razaGato = sc.nextLine();

        System.out.print("Fecha Nacimiento: ");
        String fechaGato = sc.nextLine();

        System.out.print("Peso: ");
        float pesoGato = sc.nextFloat();

        System.out.print("Altura de Salto: ");
        double altura = sc.nextDouble();

        Gato gato = new Gato(
                nombreGato,
                razaGato,
                "Gato",
                fechaGato,
                pesoGato,
                altura
        );

        System.out.println("\n--- PERRO ---");
        perro.mostrarDatos();
        perro.comunicarse();

        System.out.println("\n--- GATO ---");
        gato.mostrarDatos();
        gato.comunicarse();

        sc.close();
    }
}