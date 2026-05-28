public class Ejercicios {

    public static void main(String[] args) {

        // 1. Declaraciones

        // entero a
        int a;

        // entero x, y
        int x, y;

        // double x
        double x1;

        // double x, y
        double x2, y2;

        // entero a, b, c con valores iniciales 5, 6, 7
        int a1 = 5, b = 6, c = 7;

        // lógico sw con valor inicial falso
        boolean sw = false;

        // Cadena cad con valor nulo
        String cad = null;

        // Constante PI con valor 3.14
        final double PI = 3.14;


        // 2. Convertir cadena = "200" a entero en E
        String cadena = "200";
        int E = Integer.parseInt(cadena);

        // 3. Convertir cadena = " 200 " a entero en E1
        String cadena2 = " 200 ";
        int E1 = Integer.parseInt(cadena2.trim());

        // 4. Convertir cadena = "200" a float en f1
        float f1 = Float.parseFloat(cadena);

        // 5. Convertir el float 23.84f a cadena en nomb
        float numero = 23.84f;
        String nomb = String.valueOf(numero);


        // Mostrar resultados
        System.out.println("E = " + E);
        System.out.println("E1 = " + E1);
        System.out.println("f1 = " + f1);
        System.out.println("nomb = " + nomb);
    }
}