

public class Gato extends Mamifero {
     // Atributo específico
    private double alturaSalto;

    // Constructor
    public Gato(String nombre, String raza, String fechaNacimiento,
                float peso, double alturaSalto) {

        super(nombre, raza, fechaNacimiento, peso);
        this.alturaSalto = alturaSalto;
    }

    // Sobrescribir método comunicarse
    @Override
    public void comunicarse() {
        System.out.println("Miau Miau");
    }

    // Mostrar datos
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Altura de salto: " + alturaSalto);
    }
}
