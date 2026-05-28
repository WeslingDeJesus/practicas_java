public class Mamifero {

       // Atributos
    private String nombre;
    private String raza;
    private String fechaNacimiento;
    private float peso;

    // Constructor
    public Mamifero(String nombre, String raza, String fechaNacimiento, float peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }

    // Métodos
    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }

    public void comunicarse() {
        System.out.println("El mamífero se comunica.");
    }

    // Mostrar datos
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Peso: " + peso);
    }
    
}
