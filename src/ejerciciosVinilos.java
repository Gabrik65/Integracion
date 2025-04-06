public class ejerciciosVinilos {
    public static void main(String[] args){
        String vin[][] = new String[100][3];

        System.out.println("Espacio Maximo en la coleccion " + vin.length);

        agregarVinilos(vin,"Iron Maiden", "Iron Maiden", "1980");
        agregarVinilos(vin,"Iron Maiden", "Killers", "1981");
        agregarVinilos(vin,"Iron Maiden", "The Number of the Beast", "1982");
        agregarVinilos(vin,"AC-DC", "Back in black", "1980");
        agregarVinilos(vin,"AC-DC", "Highway to Hell", "1979");
        agregarVinilos(vin,"AC-DC", "Who made who", "1986");
        agregarVinilos(vin,"Judas Priest", "British steel", "1980");
        agregarVinilos(vin,"Judas Priest", "PainKillers", "1990");
        agregarVinilos(vin,"Judas Priest", "Defenders of the faith", "1984");
        agregarVinilos(vin,"Kiss", "Destroyers", "1976");

        spaceUsed(vin);
        spaceAvailable(vin);
        showCollection(vin);

        String artista = "AC-DC";
        System.out.println("Buscando Banda " + artista);
        buscarArtista(vin, artista);

        String artista2 = "AB-CD";
        System.out.println("Buscando Banda " + artista2);
        buscarArtista(vin, artista2);
    }


    public static String[][] agregarVinilos(String[][] vin, String name, String disc, String year){
        int bla = 0;
        for (int i = 0; i < vin.length-1; i ++)
            if (vin[i][0] != null) bla++;
        vin[bla][0] = name;
        vin[bla][1] = disc;
        vin[bla][2] = year;
        return vin;
    }

    public static void showCollection(String[][] vin){
        for (int i = 0; i < vin.length; i++) {
            if (vin[i][0] == null) {
                break;
            }else{
                System.out.print("Fila " + (i+1));
                for (int j = 0; j < 3; j++) {
                    System.out.print(" "+vin[i][j] +" -");
                }
            System.out.println("");
            }
        }
        System.out.println("");
    }

    public static void spaceUsed(String[][] vin){
        int bla = 0;
        for (int i = 0; i < vin.length-1; i ++)
            if (vin[i][0] != null) bla++;
        System.out.println("Hay un total de: " + bla + " vinilos en la coleccion");
        System.out.println("");
    }

    public static void spaceAvailable(String[][] vin){
        int bla = 0;
        for (int i = 0; i < vin.length-1; i ++)
            if (vin[i][0] != null) bla++;
        int sp = vin.length - bla;
        System.out.println("Hay un total de: " + sp + " espacios disponibles en la coleccion");
        System.out.println("");
    }

    public static boolean buscarArtista(String[][] vin, String name){
        for (int i = 0; i < vin.length; i++) {
            if (vin[i][0] == name) {
                System.out.println("La banda " + name + " si esta en la coleccion");
                System.out.println("");
                return true;
            }

        }
        System.out.println("la banda " + name + " no se encuentra en la coleccion");
        System.out.println("");
        return false;
    }
}
