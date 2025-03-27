
import java.util.Scanner;

public class PistolasImperio {
        private static final int MAX_PISTOLAS = 100;
        private static String[][] pistolas = new String[MAX_PISTOLAS][2]; // [ID, NombreSoldado]
        private static int totalPistolas = 0;
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            menu();
            agregarPistola();
            listarPistolas();
            eliminarPistola();
            listarPistolas();
        }

        /**
         * Ejecuta el menú principal del programa y gestiona la interacción con el usuario.
         */
        public static void menu() {
            // TODO: Implementar el código para gestionar la interacción con el usuario.
        }

        /**
         * Muestra el menú principal con las opciones disponibles.
         */
        private static void mostrarOpciones() {
            // TODO: Implementar el código para mostrar las opciones del menú en pantalla.
        }

        /**
         * Obtiene y valida la opción ingresada por el usuario.
         * @return La opción seleccionada.
         */
        private static int obtenerOpcion() {
            return totalPistolas;
            // TODO: Implementar la lectura y validación de la opción ingresada.
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
            int index = totalPistolas;
            if(index < MAX_PISTOLAS){
                System.out.println("Ingrese nombre de soldado");
                String nombre = scanner.next();
                String id = String.valueOf(index+1);
                pistolas[index][0] = id;
                pistolas[index][1] = nombre;
                index += 1;
                totalPistolas += 1;
            }else{
                System.out.println("Lista llena");
            }
        }

        /**
         * Elimina una pistola del inventario según su ID.
         */
        private static void eliminarPistola() {
            // TODO: Implementar la lógica para eliminar una pistola del inventario.
            System.out.println("Ingrese id a eliminar");
            String identificacion = scanner.next();
            if(!isInt(identificacion)){
                System.out.println("ID invalida");
                return;}
            int id = Integer.parseInt(identificacion);
            if((id < MAX_PISTOLAS) && (id > 0)) {
                if(pistolas[id - 1][0] != null) {
                    System.out.println(pistolas[id - 1][0] + " " + pistolas[id - 1][1] + " eliminado");
                    pistolas[id - 1][0] = "";
                    pistolas[id - 1][1] = "";
                }else {
                    System.out.println("Ningun soldado registrado en esta id");
                }
            }else {
                System.out.println("ID invalida");
            }
        }

        /**
         * Reorganiza el inventario después de eliminar una pistola, evitando espacios vacíos.
         * @param indice Índice de la pistola eliminada.
         */
        private static void reordenarInventario(int indice) {
            // TODO: Implementar la lógica para reorganizar el inventario después de una eliminación.
            int contados = 0;
            for(int i = 0; i<MAX_PISTOLAS; i++){
                if (pistolas[i][0] != null || pistolas[i][1] != null){
                    contados ++;

                }
            }
        }

        /**
         * Muestra en pantalla todas las pistolas registradas en el inventario.
         */
        private static void listarPistolas() {
            // TODO: Implementar la lógica para listar todas las pistolas registradas.
            System.out.print("ID ");
            System.out.println("Nombre");
            for (int i = 0; i < totalPistolas; i++){
                System.out.print(pistolas[i][0] + "  ");
                System.out.println(pistolas[i][1]);
            }
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
