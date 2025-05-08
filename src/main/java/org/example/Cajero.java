package org.example;

import java.util.Scanner;

public class Cajero {

    private static int saldo = 100000;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    /**
     * Ejecuta el menú principal del programa y gestiona la interacción con el usuario.
     */
    public static void menu() {
        int n;
        mostrarMenu();
        n = checkMenuOption(sc.next());
        if (n != -1) {
            ejecutarOpcion(n);
        }else {
            menu();
        }
    }

    public static int checkMenuOption(String number){
        int num = stringToint(number);
        if (num > 0 && num < 5){
            return num;
        }else{
            return -1;
        }
    }

    public static int stringToint(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1;
        }
    }

    public static void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1- Retirar Dinero");
        System.out.println("2- Consultar Saldo");
        System.out.println("3- Depositar Dinero");
        System.out.println("4- Salir");
        System.out.println("Selecciona una opcion:");
    }

    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> retirarDinero();
            case 2 -> obtenerSaldo();
            case 3 -> depositarDinero();
            case 4 -> System.exit(1);
            default -> System.out.println("Opcion invalida");
        }
    }

    public static void retirarDinero() {
        System.out.println("Ingrese monto a retirar");
        int num = retirarCheckString(sc.next());
        try {
            if (num == -1) throw new IllegalArgumentException("Monto inválido");
            retirar(num);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            menu();
        }
    }


    public static int retirarCheckString(String number){
        int num = stringToint(number);
        if (masque0(num)){
            return num;
        }else{
            return -1;
        }
    }

    public static void retirar(int monto) {
        if (!masque0(monto)) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        if (!multiplo1000(monto)) {
            throw new IllegalArgumentException("El monto debe ser múltiplo de 1000");
        }
        if (!montocomparasaldo(monto)) {
            throw new IllegalStateException("Saldo insuficiente para realizar el retiro");
        }
        saldo -= monto;
    }


    public static void depositarDinero() {
        System.out.println("Ingrese monto a depositar");
        int num = retirarCheckString(sc.next());
        try {
            if (num == -1) throw new IllegalArgumentException("Monto inválido");
            depositar(num);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            menu();
        }
    }


    public static void depositar(int monto) {
        if (!masque0(monto)) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        if (!multiplo1000(monto)) {
            throw new IllegalArgumentException("El monto debe ser múltiplo de 1000");
        }

        saldo += monto;
    }


    public static int obtenerSaldo() {
        return saldo;
    }

    public static void reiniciarSaldo() {
        saldo = 100000;
    }

    public static boolean masque0(int num){return num > 0;}

    public static boolean multiplo1000(int num){return num%1000 == 0;}

    public static boolean montocomparasaldo(int num){return num <= saldo;}

}