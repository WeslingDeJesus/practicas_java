
public class Perro extends Mamifero {
     // Atributo específico
    private String lugarEntrenamiento;

    // Constructor
    public Perro(String nombre, String raza, String fechaNacimiento,
                 float peso, String lugarEntrenamiento) {

        super(nombre, raza, fechaNacimiento, peso);
        this.lugarEntrenamiento = lugarEntrenamiento;
    }

    // Sobrescribir método comunicarse
    @Override
    public void comunicarse() {
        System.out.println("Guau Guau");
    }

    // Mostrar datos
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Lugar de entrenamiento: " + lugarEntrenamiento);
    }
}
