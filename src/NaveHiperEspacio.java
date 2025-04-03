import java.util.Scanner;

public class NaveHiperEspacio {
    private static Scanner scanner = new Scanner(System.in);
    private static Object sc;

    /**
     * Método principal que inicia la aplicación.
     * TODO: Llamar al método menu para iniciar la interacción con el usuario.
     */
    public static void main(String[] args) {
        // TODO: Invocar menu();
        menu();
    }

    /**
     * Menú principal con un do-while para manejar las opciones del usuario.
     * TODO: Incluir el ciclo do-while y las llamadas a mostrarMenu y ejecutarOpcion.
     */
    public static void menu() {
        // TODO: Implementar ciclo do-while, leer opción y llamar a ejecutarOpcion.
        mostrarMenu();
    }

    /**
     * Imprime el menú principal.
     * TODO: Mostrar las opciones disponibles para el usuario.
     */
    public static void mostrarMenu() {
        // TODO: Mostrar opciones: 1. Suma, 2. Resta, 3. Multiplicación, 4. Inversa, 5. División, 6. Salir.
    }

    /**
     * Ejecuta la opción elegida llamando al método específico para cada operación.
     * TODO: Evaluar la opción ingresada y redirigir a la operación correspondiente.
     */
    public static void ejecutarOpcion(int opcion, Scanner sc) {
        // TODO: Implementar switch-case para cada opción (1 a 6).

    }

    /**
     * Realiza la operación de suma de dos matrices 2x2.
     * TODO: Leer dos matrices 2x2, sumar elemento a elemento e imprimir el resultado.
     */
    public static void operacionSuma(Scanner sc) {
        // TODO: Invocar leerMatriz para ambas matrices, sumar y llamar a imprimirMatriz.
        System.out.println("Matriz A");
        double[][] a = matrizBuild(scanner);
        System.out.println("Matriz B");
        double[][] b = matrizBuild(scanner);

        double[][] c = new double[2][2];
        for (int i = 0; i < 2; i++) {
            c[0][i] = a[0][i] + b[0][i];
            c[1][i] = a[1][i] + b[1][i];
        }

        imprimirMatriz(c);
    }

    /**
     * Realiza la operación de resta de dos matrices 2x2.
     * TODO: Leer dos matrices 2x2, restar elemento a elemento e imprimir el resultado.
     */
    public static void operacionResta(Scanner sc) {
        // TODO: Invocar leerMatriz para ambas matrices, restar y llamar a imprimirMatriz.
    }

    /**
     * Realiza la operación de multiplicación de dos matrices 2x2.
     * TODO: Leer dos matrices 2x2, multiplicarlas utilizando la suma de productos y mostrar el resultado.
     */
    public static void operacionMultiplicacion(Scanner sc) {
        // TODO: Invocar leerMatriz para ambas matrices, multiplicar y llamar a imprimirMatriz.
    }

    /**
     * Realiza la operación de cálculo de la inversa de una matriz 2x2.
     * TODO: Leer una matriz 2x2, calcular su determinante, verificar invertibilidad y mostrar la inversa.
     */
    public static void operacionInversa(Scanner sc) {
        // TODO: Invocar leerMatriz, calcular determinante, verificar y calcular la inversa, luego llamar a imprimirMatriz.
    }

    /**
     * Realiza la operación de división de matrices resolviendo A * X = B.
     * TODO: Leer la matriz A, verificar que sea invertible, calcular su inversa, leer la matriz B y mostrar el resultado de A^-1 * B.
     */
    public static void operacionDivision(Scanner sc) {
        // TODO: Invocar leerMatriz para A y B, calcular inversa de A, multiplicar por B y llamar a imprimirMatriz.
    }

    /**
     * Lee una matriz 2x2 desde la entrada estándar.
     * TODO: Solicitar al usuario cada elemento de la matriz especificada y retornar la matriz.
     */
    public static double[][] leerMatriz(Scanner sc, String nombre) {
        // TODO: Implementar lectura de 2x2 elementos y retornar la matriz.
        return new double[0][];
    }

    /**
     * Imprime una matriz 2x2 en formato sencillo.
     * TODO: Recorrer la matriz y mostrar cada uno de sus elementos.
     */
    public static void imprimirMatriz(double[][] matriz) {
        // TODO: Implementar impresión de cada elemento de la matriz.
        System.out.println(matriz[0][0] + " " + matriz[0][1]);
        System.out.println(matriz[1][0] + " " + matriz[1][1]);
    }

    /**
     * Calcula el determinante de una matriz 2x2.
     * TODO: Calcular y retornar el determinante utilizando la fórmula: ad - bc.
     */
    public static double determinante(double[][] matriz) {
        // TODO: Implementar el cálculo del determinante.
        int a = 1;
        return a;
    }

    public static double[][] matrizBuild(Scanner sc) {
        int size = matrizSize(sc);
        System.out.println("Matriz A");
        double[][] matriz = new double[size][size];
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                System.out.println("Fila " + a + " Columna " + b);
                matriz[a][b] = sc.nextInt();
            }
        }
        return matriz;
    }

    public static int matrizSize(Scanner sc) {
        System.out.println("Ingrese el tamaño de las matrices:");
        return sc.nextInt();
    }

}