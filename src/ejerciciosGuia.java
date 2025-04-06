import java.util.Arrays;
import java.util.Scanner;

public class ejerciciosGuia {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {

            System.out.println("Ingrese int numero " + (i+1));
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        for (int i : num) {
            System.out.print(i + " ");
        }

        System.out.println("");
        System.out.println("Arreglo Inverso");
        int[] numInv = new int[10];
        for (int i = 0; i< num.length; i++) {
            numInv[i] = num[num.length - 1 - i ];
            System.out.print(numInv[i] + " ");
        }
    }
}
