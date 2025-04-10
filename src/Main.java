import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        String[][] size = sizeM();
        int[][] mat = llenarMatriz(size);
    }

    public static void showMenu(){
        System.out.println("1) Mostrar fila");

    }

    public static void pickedMenu(int opcion){
        switch (opcion){
            case 1:
                break;
            default:
                System.out.println("No es una opcion válida");
                showMenu();
        }
    }
    public static String[][] sizeM(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese No de filas de matriz");
        int filas = getInt(sc);
        System.out.println("Ingrese No de columnas de matriz");
        int columnas = getInt(sc);
        validarDimensiones(filas,columnas);
        return new String[filas][columnas];
    }

    public static int getInt(Scanner sc) {
        String numero = sc.next();
        int num = -1;
        try {
            num = Integer.parseInt(numero); // Intenta convertir el String a int
        } catch (NumberFormatException e) {
            System.out.println("No es un número válido");
            menu();
        }
        return num;
    }

    public static boolean validarDimensiones(int filas, int columnas){
        if (filas > 0 && columnas > 0) {
            return true;
        }else {
            System.out.println("Datos no validos");
            menu();
            return false;
        }
    }

    public static int[][] llenarMatriz(String[][] matriz){
        int[][] mat = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                mat[i][j] = (int)(Math.random()*10);
                System.out.println(mat[i][j]);
            }
        }
        return mat;
    }

    public static void
}