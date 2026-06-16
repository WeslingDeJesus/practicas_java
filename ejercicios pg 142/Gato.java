

public class Gato extends Mamifero {
    private double alturaSalto;

    public Gato(String nombre, String raza, String tipoDeAnimal,
                String fechaNacimiento, float peso,
                double alturaSalto) {

        super(nombre, raza, fechaNacimiento, tipoDeAnimal, peso);
        this.alturaSalto = alturaSalto;
    }

    @Override
    public void comunicarse() {
        System.out.println("Miau Miau");
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Tipo Animal: " + tipoDeAnimal);
        System.out.println("Fecha Nacimiento: " + fechaNacimiento);
        System.out.println("Peso: " + peso);
        System.out.println("Altura de Salto: " + alturaSalto);
    }
}
