import java.io.*;
import java.util.ArrayList;

public class ArchivoCalificaciones {

    private static final String DIRECTORIO = "calificaciones";

    public ArchivoCalificaciones() {
        new File(DIRECTORIO).mkdirs();
    }

    private String obtenerRuta(String mes, String curso) {
        return DIRECTORIO + File.separator
                + "cal_" + mes.toUpperCase() + "_" + curso.toUpperCase() + ".txt";
    }

    public void guardar(Estudiante est) {
        String ruta = obtenerRuta(est.getMes(), est.getCurso());
        try (FileWriter fw = new FileWriter(ruta, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(
                est.getNombre()    + "," +
                est.getApellido()  + "," +
                est.getCurso()     + "," +
                est.getMes()       + "," +
                (int) est.getMatematica() + "," +
                (int) est.getLengua()     + "," +
                (int) est.getNaturales()  + "," +
                (int) est.getSociales()
            );

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public ArrayList<Estudiante> leerPorMesCurso(String mes, String curso) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        File archivo = new File(obtenerRuta(mes, curso));

        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                Estudiante est = parsearLinea(linea);
                if (est != null) lista.add(est);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        return lista;
    }

    public ArrayList<Estudiante> leer() {
        ArrayList<Estudiante> todos = new ArrayList<>();
        File dir = new File(DIRECTORIO);
        if (!dir.exists()) return todos;

        File[] archivos = dir.listFiles(
            (d, name) -> name.startsWith("cal_") && name.endsWith(".txt")
        );
        if (archivos == null) return todos;

        for (File archivo : archivos) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    linea = linea.trim();
                    if (linea.isEmpty()) continue;
                    Estudiante est = parsearLinea(linea);
                    if (est != null) todos.add(est);
                }
            } catch (IOException e) {
                System.out.println("Error al leer " + archivo.getName() + ": " + e.getMessage());
            }
        }

        return todos;
    }

    private Estudiante parsearLinea(String linea) {
        String[] datos = linea.split(",");
        if (datos.length < 8) return null;
        try {
            return new Estudiante(
                datos[0], datos[1], datos[2], datos[3],
                Double.parseDouble(datos[4]),
                Double.parseDouble(datos[5]),
                Double.parseDouble(datos[6]),
                Double.parseDouble(datos[7])
            );
        } catch (NumberFormatException e) {
            System.out.println("Linea con formato incorrecto omitida: " + linea);
            return null;
        }
    }
}
