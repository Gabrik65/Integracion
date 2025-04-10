import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        String[][] size = sizeM();
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

    public static Integer[][] llenarMatriz(String[][] matriz){
        int[][] mat = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                mat[i][j] = Math.random();
            }
        }
    }
}