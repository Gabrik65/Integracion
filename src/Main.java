import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Start();
    }

    public static void Start(){
        Scanner sc = new Scanner(System.in);
        String[][] size = sizeM(sc);
        int[][] mat = llenarMatriz(size);
        menu(mat);
    }

    public static void menu(int[][] mat){
        showMenu();
        pickedMenu(mat);
    }

    public static void showMenu(){
        System.out.println("1) Mostrar fila");
        System.out.println("Selecciona una opcion");

    }

    public static void pickedMenu(int[][] mat){
        Scanner sc = new Scanner(System.in);
        int opcion = obtenerOpcion(mat);
        switch (opcion){
            case 1:
                muestraFila(mat,1);
                break;
            default:
                System.out.println("No es una opcion válida");
                menu(mat);
        }
    }

    private static int obtenerOpcion(int[][] mat) {
        Scanner sc = new Scanner(System.in);
        String nums = sc.next();
        int number = 0;
        try{
            number = Integer.parseInt(nums);
        }catch (NumberFormatException e) {
            System.out.println("No es un número válido");
            menu(mat);
        }
        return number;
    }

    public static String[][] sizeM(Scanner sc){
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
            Start();
        }
        return num;
    }

    public static boolean validarDimensiones(int filas, int columnas){
        if (filas > 0 && columnas > 0) {
            return true;
        }else {
            System.out.println("Datos no validos");
            Start();
            return false;
        }
    }

    public static int[][] llenarMatriz(String[][] matriz){
        int[][] mat = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                mat[i][j] = (int)(Math.random()*10);
            }
        }
        return mat;
    }

    public static void muestraFila(int[][] matriz,int fila){
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[fila][i]);
        }
    }
}