import java.util.Scanner;

public class ejercicioCalculadora {

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        System.out.println("1- Suma");
        System.out.println("2- Resta");
        System.out.println("3- Multiplicacion");
        System.out.println("4- Division");
        System.out.println("5- Salir");
        System.out.println("Selecciona una opcion:");
        optionPick();
    }

    public static void optionPick(){
        Scanner sc = new Scanner(System.in);
        int pick = sc.nextInt();
        switch(pick){
            case 1:
                suma(sc);
                break;
            case 2:
                resta(sc);
                break;
            case 3:
                mult(sc);
                break;
            case 4:
                division(sc);
                break;
            case 5:
                System.exit(69);
                break;
            default:
                System.out.println("Opcion invalida");
                menu();
        }
    }

    public static double number(Scanner sc,String name){
        System.out.println(name);
        String nums = sc.next();
        double number = 0;
        try{
            number = Double.parseDouble(nums);
        }catch (NumberFormatException e) {
            System.out.println("No es un número válido");
            menu();
        }
        return number;
    }
    public static void suma(Scanner sc){
        double a = number(sc, "Numero 1");
        double b = number(sc, "Numero 2");
        double c = a + b;
        System.out.println("La suma da " + c);
        System.out.println("");
        System.out.println("_________________________________");
        menu();
    }
    public static void resta(Scanner sc){
        double a = number(sc, "Numero 1");
        double b = number(sc, "Numero 2");
        double c = a - b;
        System.out.println("La resta da " + c);
        System.out.println("");
        System.out.println("_________________________________");
        menu();
    }
    public static void mult(Scanner sc){
        double a = number(sc, "Numero 1");
        double b = number(sc, "Numero 2");
        double c = a * b;
        System.out.println("La multiplicacion da " + c);
        System.out.println("");
        System.out.println("_________________________________");
        menu();
    }

    public static void division(Scanner sc){
        double a = number(sc, "Numero 1");
        double b = number(sc, "Numero 2");
        if(noCero(b)){
            double c = a / b;
            System.out.println("La divicion da " + c);
            System.out.println("");
            System.out.println("_________________________________");
            menu();
        }
        else{
            System.out.println("No se puede divir por 0");
            System.out.println("");
            System.out.println("_________________________________");
            menu();
        }
    }

    public static boolean noCero(double num){
        if (num != 0){
            return true;
        }else {
            return false;
        }
    }

}
