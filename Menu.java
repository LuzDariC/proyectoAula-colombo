import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String[] opciones = {"Habitacion personal", "Habitacion matrimonial", "Habitacion familiar"};

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }
            System.out.println((opciones.length + 1) + ". Salir");

            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= opciones.length) {
                System.out.println("          FACTURA           ");
                System.out.println("_____________________________");
                System.out.println("Servicio reservado: " + opciones[opcion - 1]);
            } else if (opcion == opciones.length + 1) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción inválida. Inténtalo de nuevo.");
            }break;

        } while (opcion != opciones.length + 1);

        

    }
    
}
