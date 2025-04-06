
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class PistolasImperio {
    static String[][] gunList = new String[100][2];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        mostrarOpciones();
        int opcion = obtenerOpcion();
        switch(opcion){
            case 1:
                agregarPistola();
                break;
                case 2:
                    eliminarPistola();
                    break;
                case 3:
                    listarPistolas();
                    break;
                case 4:
                    buscarPistola();
                    break;
                    case 5:
                    System.exit(69);
                    break;
                    default:
                        System.out.println("No es un número válido");
                        menu();
        }
    }

        /**
         * Muestra el menú principal con las opciones disponibles.
         */
        private static void mostrarOpciones() {
            System.out.println("Menu Principal");
            System.out.println("");
            System.out.println("1- Agregar Pistola");
            System.out.println("2- Eliminar Pistola");
            System.out.println("3- Lista de Pistolas");
            System.out.println("4- Buscar Pistola");
            System.out.println("5- Salir");
            System.out.println("Selecciona una opcion:");
        }

        /**
         * Obtiene y valida la opción ingresada por el usuario.
         * @return La opción seleccionada.
         */
        private static int obtenerOpcion() {
            Scanner sc = new Scanner(System.in);
            String nums = sc.next();
            int number = 0;
            try{
                number = Integer.parseInt(nums);
            }catch (NumberFormatException e) {
                System.out.println("No es un número válido");
                menu();
            }
            return number;
        }

        /**
         * Ejecuta la acción correspondiente según la opción seleccionada.
         * @param opcion Opción ingresada por el usuario.
         */
        private static void ejecutarOpcion(int opcion) {
            // TODO: Implementar la lógica para ejecutar la opción seleccionada.
        }

        /**
         * Agrega una nueva pistola al inventario, registrando su ID y el nombre del soldado.
         */
        private static void agregarPistola() {
            int bla = 0;
            for (int i = 0; i < gunList.length-1; i ++)
                if (gunList[i][0] != null) bla++;
            if (bla < 100){
                System.out.println("Ingrese ID de la pistola");
                gunList[bla][0] = sc.next();
                System.out.println("Ingrese Nombre del Soldado");
                gunList[bla][1] = sc.next();
                System.out.println("Pistola registrada");
                System.out.println(gunList[bla][0] +" - "+ gunList[bla][1]);
                menu();
            }else {
                System.out.println("No queda espacio en la lista");
                menu();
            }
        }

        /**
         * Elimina una pistola del inventario según su ID.
         */
        private static void eliminarPistola() {
            System.out.println("Ingrese ID de la pistola a eliminar");
            String ID = sc.next();
            for (int i = 0; i < gunList.length; i++) {
                if (Objects.equals(gunList[i][0], ID)){
                    reordenarInventario(i);
                    System.out.println("Pistola eliminada del registro");
                    menu();
                }
            }
            System.out.println("No existen pistolas con ID " + ID);
            menu();
        }

        /**
         * Reorganiza el inventario después de eliminar una pistola, evitando espacios vacíos.
         * @param indice Índice de la pistola eliminada.
         */
        private static void reordenarInventario(int indice) {
            // TODO: Implementar la lógica para reorganizar el inventario después de una eliminación.
            int count = indice;
            for (int i = indice+1; i <gunList.length ; i++) {
                gunList[i-1][0] = gunList[i][0];
                gunList[i-1][1] = gunList[i][1];
                count ++;
            }
            gunList[count][0] = null;
            gunList[count][1] = null;

        }

        /**
         * Muestra en pantalla todas las pistolas registradas en el inventario.
         */
        private static void listarPistolas() {
            System.out.print("  ID ");
            System.out.println("Nombre");
            if (gunList[0][0] == null){
                System.out.println("No hay pistolas en la lista");
                menu();
            }
            for (int i = 0; i < gunList.length; i++){
                if (gunList[i][0] == null){
                    break;
                }else {
                    System.out.print((i+1) + ") ");
                    System.out.print(gunList[i][0] + "  ");
                    System.out.println(gunList[i][1]);
                }
            }
            menu();
        }

        private static void buscarPistola(){
            System.out.println("Ingrese ID de la pistola");
            String search = sc.next();
            String found = null;
            for (int i = 0; i < gunList.length; i++) {
                if (Objects.equals(gunList[i][0], search)) {
                    found = gunList[i][0];
                    System.out.print(i + ") ");
                    System.out.print("ID: " + found + "  ");
                    System.out.println("nombre: " + gunList[i][1]);
                }else{
                    break;
                }

            }
            if (found == null) {
                System.out.println("ID " + search + " no encontrada.");
            }
            menu();

        }

    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str); // Intenta convertir el String a int
            return true; // Si tiene éxito, es un int válido
        } catch (NumberFormatException e) {
            return false; // Si ocurre un error, no es un int
        }
    }
    }
