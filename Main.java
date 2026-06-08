import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArchivoCalificaciones archivo = new ArchivoCalificaciones();

    private static final String[] MESES = {
        "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
        "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
    };

    public static void main(String[] args) {
        boolean ejecutando = true;

        while (ejecutando) {
            mostrarMenu();
            String opcion = leerLinea();

            if (opcion.isEmpty()) continue;

            // ESC key = caracter 27
            if (opcion.charAt(0) == 27 || opcion.equals("3")) {
                ejecutando = false;
            } else {
                switch (opcion) {
                    case "1":
                        registrarCalificaciones();
                        break;
                    case "2":
                        generarReporte();
                        break;
                    default:
                        System.out.println("\nOpcion no valida. Intente de nuevo.");
                        break;
                }
            }
        }

        System.out.println("\nGracias por usar el Sistema de Calificaciones.");
        System.out.println("Hasta pronto.");
    }

    // -------------------------------------------------------------------------
    // MENU
    // -------------------------------------------------------------------------

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("      COLEGIO DIOS ES BUENO         ");
        System.out.println("    SISTEMA DE CALIFICACIONES       ");
        System.out.println("====================================");
        System.out.println("  1- Registro de calificaciones     ");
        System.out.println("  2- Reporte calificaciones por mes ");
        System.out.println("  3- Presione <ESC> para salir      ");
        System.out.println("====================================");
        System.out.print("Elija la opcion deseada y pulse <ENTER>: [ _ ]\b\b\b\b");
    }

    // -------------------------------------------------------------------------
    // OPCION 1 - REGISTRO
    // -------------------------------------------------------------------------

    private static void registrarCalificaciones() {
        System.out.println("\n--- REGISTRO DE CALIFICACIONES ---");

        String mes = seleccionarMes();
        if (mes == null) return;

        System.out.print("Ingrese el curso (ej. 1A, 2B): ");
        String curso = leerLinea().trim().toUpperCase();
        if (curso.isEmpty()) {
            System.out.println("Curso no valido. Regresando al menu.");
            return;
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n-- Datos del estudiante --");

            System.out.print("Nombre    : ");
            String nombre = leerLinea().trim();

            System.out.print("Apellido  : ");
            String apellido = leerLinea().trim();

            if (nombre.isEmpty() || apellido.isEmpty()) {
                System.out.println("Nombre y apellido son obligatorios.");
                continue;
            }

            double matematica = leerNota("Matematica (0-100): ");
            double lengua     = leerNota("Lengua     (0-100): ");
            double naturales  = leerNota("Naturales  (0-100): ");
            double sociales   = leerNota("Sociales   (0-100): ");

            Estudiante est = new Estudiante(
                nombre, apellido, curso, mes,
                matematica, lengua, naturales, sociales
            );

            archivo.guardar(est);
            System.out.printf(
                "%nEstudiante guardado. Promedio: %.1f  Literal: %s%n",
                est.calcularPromedio(), est.getLiteral()
            );

            System.out.print("Agregar otro estudiante? (S/N): ");
            String resp = leerLinea().trim().toUpperCase();
            continuar = resp.equals("S");
        }
    }

    // -------------------------------------------------------------------------
    // OPCION 2 - REPORTE
    // -------------------------------------------------------------------------

    private static void generarReporte() {
        System.out.println("\n--- REPORTE DE CALIFICACIONES ---");

        String mes = seleccionarMes();
        if (mes == null) return;

        System.out.print("Ingrese el curso (ej. 1A, 2B): ");
        String curso = leerLinea().trim().toUpperCase();

        ArrayList<Estudiante> estudiantes = archivo.leerPorMesCurso(mes, curso);

        if (estudiantes.isEmpty()) {
            System.out.println(
                "No se encontraron calificaciones para " + mes + " - Curso " + curso
            );
            return;
        }

        // Ordenar por apellido
        estudiantes.sort((a, b) -> a.getApellido().compareToIgnoreCase(b.getApellido()));

        imprimirReporte(mes, curso, estudiantes);
    }

    private static void imprimirReporte(String mes, String curso,
                                         ArrayList<Estudiante> lista) {
        String sep   = "=".repeat(78);
        String sepFin = "-".repeat(78);

        System.out.println();
        System.out.println("Colegio Dios es Bueno.");
        System.out.println("Reporte de Calificaciones de " + mes);
        System.out.println("Curso: " + curso);
        System.out.println(sep);
        System.out.printf("%-15s %-15s %10s %8s %10s %9s %9s %7s%n",
            "Nombre", "Apellido", "Matematica", "Lengua",
            "Naturales", "Sociales", "Promedio", "Literal");
        System.out.println(sep);

        for (Estudiante est : lista) {
            System.out.printf("%-15s %-15s %10.0f %8.0f %10.0f %9.0f %9.1f %7s%n",
                est.getNombre(),
                est.getApellido(),
                est.getMatematica(),
                est.getLengua(),
                est.getNaturales(),
                est.getSociales(),
                est.calcularPromedio(),
                est.getLiteral()
            );
        }

        System.out.println(sepFin);
        System.out.println("Total de estudiantes: " + lista.size());
    }

    // -------------------------------------------------------------------------
    // UTILIDADES
    // -------------------------------------------------------------------------

    private static String seleccionarMes() {
        System.out.println("\nSeleccione el mes:");
        for (int i = 0; i < MESES.length; i++) {
            System.out.printf("  %2d- %s%n", i + 1, MESES[i]);
        }
        System.out.print("Opcion (1-12): ");

        while (true) {
            String input = leerLinea().trim();
            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= 12) {
                    return MESES[num - 1];
                }
                System.out.print("Ingrese un numero entre 1 y 12: ");
            } catch (NumberFormatException e) {
                System.out.print("Opcion no valida. Ingrese un numero (1-12): ");
            }
        }
    }

    private static double leerNota(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = leerLinea().trim();
            try {
                double valor = Double.parseDouble(input);
                if (valor >= 0 && valor <= 100) {
                    return valor;
                }
                System.out.println("La nota debe estar entre 0 y 100.");
            } catch (NumberFormatException e) {
                System.out.println("Valor no valido. Ingrese un numero.");
            }
        }
    }

    private static String leerLinea() {
        try {
            return sc.nextLine();
        } catch (Exception e) {
            return "";
        }
    }
}
