import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class NaveHiperEspacio extends JFrame {

    public static void main(String[] args) {
        menu();
        }

    /**
     * Menú principal con un do-while para manejar las opciones del usuario.
     * TODO: Incluir el ciclo do-while y las llamadas a mostrarMenu y ejecutarOpcion.
     */
    public static void menu() {
        // TODO: Implementar ciclo do-while, leer opción y llamar a ejecutarOpcion.
        String opt;
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            mostrarMenu();
            opt = sc.next();
            try{
                opcion = Integer.parseInt(opt);
            }catch (NumberFormatException e) {
                System.out.println("No es un número válido");
                menu();
            }
            ejecutarOpcion(opcion,sc);
        }while (opcion != 0); {
            sc.close();
        }
    }

    /**
     * Imprime el menú principal.
     * TODO: Mostrar las opciones disponibles para el usuario.
     */
    public static void mostrarMenu() {
        // TODO: Mostrar opciones: 1. Suma, 2. Resta, 3. Multiplicación, 4. Inversa, 5. División, 6. Salir.
        System.out.println("Menu Principal");
        System.out.println("1- Suma");
        System.out.println("2- Resta");
        System.out.println("3- Multiplicación");
        System.out.println("4- Inversa");
        System.out.println("5- División");
        System.out.println("6- Salir");
        System.out.println("Selecciona una opcion:");
    }

    /**
     * Ejecuta la opción elegida llamando al método específico para cada operación.
     * TODO: Evaluar la opción ingresada y redirigir a la operación correspondiente.
     */
    public static void ejecutarOpcion(int opcion, Scanner sc) {
        switch(opcion){
            case 1:
                operacionSuma(sc);
                break;
            case 2:
                operacionResta(sc);
                break;
            case 3:
                operacionMultiplicacion(sc);
                break;
            case 4:
                operacionInversa(sc);
                break;
            case 5:
                operacionDivision(sc);
                break;
            case 6:
                System.exit(69);
                break;
            default:
                System.out.println("Opcion invalida");
                menu();
        }
    }

    public static void operacionSuma(Scanner sc) {
        int size = matrizSize(sc);
        double[][] a = matrizBuild(sc,"Matriz A",size);
        double[][] b = matrizBuild(sc,"Matriz B",size);

        imprimirMatriz(a);
        imprimirMatriz(b);

        double[][] c = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        imprimirMatriz(c);
        sc.next();
        menu();
    }

    public static void operacionResta(Scanner sc) {
        int size = matrizSize(sc);
        double[][] a = matrizBuild(sc,"Matriz A",size);
        double[][] b = matrizBuild(sc,"Matriz B",size);

        imprimirMatriz(a);
        imprimirMatriz(b);

        double[][] c = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }

        imprimirMatriz(c);
        sc.next();
        menu();
    }

    public static void operacionMultiplicacion(Scanner sc) {
        int size = matrizSize(sc);
        double[][] a = matrizBuild(sc,"Matriz A",size);
        double[][] b = matrizBuild(sc,"Matriz B",size);
        double[][] c = matrizMultp(a,b);
        imprimirMatriz(c);
        sc.next();
        menu();
    }

    public static void operacionInversa(Scanner sc) {
        int size = matrizSize(sc);
        double[][] matriz = matrizBuild(sc,"Matriz",size);
        imprimirMatriz(matriz);
        matrizInv(matriz);
        sc.next();
        menu();

    }

    /**
     * Realiza la operación de división de matrices resolviendo A * X = B.
     * TODO: Leer la matriz A, verificar que sea invertible, calcular su inversa, leer la matriz B y mostrar el resultado de A^-1 * B.
     */
    public static void operacionDivision(Scanner sc) {
        int size = matrizSize(sc);
        double[][] a = matrizBuild(sc,"Matriz A",size);
        double[][] b = matrizBuild(sc,"Matriz B",size);
        if(invertible(determinante(a))) {
            double[][] aInv = matrizInv(a);
            double[][] c = matrizMultp(aInv,b);
            imprimirMatriz(c);
        }else System.out.println("Matriz no divisible");

        sc.next();
        menu();
    }

    public static double[][] leerMatriz(Scanner sc, String nombre) {
        double [][] matriz = matrizBuild(sc,nombre,2);
        imprimirMatriz(matriz);
        return matriz;
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public static double determinante(double[][] matriz) {
        return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
    }

    public static boolean invertible(double det){
        if (det == 0){
            System.out.println("Matriz singular y sin inversa");
            return false;
        }else{
            return true;
        }
    }

    public static double[][] matrizBuild(Scanner sc, String name, int n) {
        double[][] matriz = new double[n][n];
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                System.out.println(name);
                System.out.println("Fila " + (a+1) + " Columna " + (b+1));
                matriz[a][b] = sc.nextInt();
            }
        }
        return matriz;
    }

    public static int matrizSize(Scanner sc) { // Esta funcion puedes cambiar el tamaño de las matricez
//        System.out.println("Ingrese el tamaño de las matrices: ");
        return 2;
    }
    public static double[][] matrizInv(double[][] matriz){
        double det = determinante(matriz);
        double[][] inverseM = new double[matriz.length][matriz.length];
        if(invertible(det)){
            for (int a = 0; a < inverseM.length; a++) {
                for (int b = 0; b < inverseM.length; b++) {

                    if ((a+b)%2 == 0) {
                        inverseM[a][b] = matriz[matriz.length-1-a][matriz.length-1-b];
                    }else {
                        inverseM[a][b] = -1*matriz[a][b];
                    }
                    inverseM[a][b] = inverseM[a][b]/det;
                }
            }
            imprimirMatriz(inverseM);
        }
        return inverseM;
    }

    public static double[][] matrizMultp(double[][] a, double[][] b){

        double[][] c = new double[2][2];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    c[i][j] = a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}