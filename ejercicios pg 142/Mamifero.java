public abstract class Mamifero implements IMamifero{

       // Atributos
    public String nombre;
    public String raza;
    public String fechaNacimiento;
    public String tipoDeAnimal;
    public float peso;

    // Constructor
    public Mamifero(String nombre, String raza, String fechaNacimiento, String tipoDeAnimal,float peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }

    // Métodos
    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }

    
     public void mostrarTipoAnimal() {
        System.out.println("Tipo de animal: " + tipoDeAnimal);
    }

    @Override
    public abstract void comunicarse();

    // Mostrar datos
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Peso: " + peso);
    }
    
}
