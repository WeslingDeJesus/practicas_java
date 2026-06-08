public class Estudiante {

    private String nombre;
    private String apellido;
    private String curso;
    private String mes;

    private double matematica;
    private double lengua;
    private double naturales;
    private double sociales;

    public Estudiante(String nombre,
                      String apellido,
                      String curso,
                      String mes,
                      double matematica,
                      double lengua,
                      double naturales,
                      double sociales) {

        this.nombre    = nombre;
        this.apellido  = apellido;
        this.curso     = curso;
        this.mes       = mes;
        this.matematica = matematica;
        this.lengua    = lengua;
        this.naturales = naturales;
        this.sociales  = sociales;
    }

    public double calcularPromedio() {
        int cantidadMaterias = 4;
        if (cantidadMaterias == 0) return 0; // proteccion division por cero
        return (matematica + lengua + naturales + sociales) / cantidadMaterias;
    }

    public String getLiteral() {
        double promedio = calcularPromedio();
        if (promedio >= 90) return "A";
        if (promedio >= 80) return "B";
        if (promedio >= 70) return "C";
        return "D";
    }

    public String getNombre()     { return nombre; }
    public String getApellido()   { return apellido; }
    public String getCurso()      { return curso; }
    public String getMes()        { return mes; }
    public double getMatematica() { return matematica; }
    public double getLengua()     { return lengua; }
    public double getNaturales()  { return naturales; }
    public double getSociales()   { return sociales; }
}
