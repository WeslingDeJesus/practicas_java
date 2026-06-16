
public class Perro extends Mamifero {
       private String lugarEntrenamiento;

    public Perro(String nombre, String raza, String tipoDeAnimal,
                 String fechaNacimiento, float peso,
                 String lugarEntrenamiento) {

        super(nombre, raza, tipoDeAnimal, fechaNacimiento, peso);
        this.lugarEntrenamiento = lugarEntrenamiento;
    }

    @Override
    public void comunicarse() {
        System.out.println("Guau Guau");
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Tipo Animal: " + tipoDeAnimal);
        System.out.println("Fecha Nacimiento: " + fechaNacimiento);
        System.out.println("Peso: " + peso);
        System.out.println("Lugar de Entrenamiento: " + lugarEntrenamiento);
    }
}
