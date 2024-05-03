import java.util.Scanner;

public class testing {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int op, opcionServicios, opcionHabitaciones, opcionRestaurante, opcionEventos;
        do {
            limpiarPantalla();
            menu_principal();
            System.out.println("\nDigite la opcion: ");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Gestion de hoteles");
                    pausa();
                    break;
                case 2:
                    System.out.println("\nUsted ha seleccionado Gestion de servicios");
                    pausa();
                    do {
                        limpiarPantalla();
                        menu_servicios();
                        System.out.println("\nDigite la opcion: ");
                        opcionServicios = leer.nextInt();

                        switch (opcionServicios) {
                            case 1:
                                System.out.println("\nUsted ha seleccionado la opcion habitaciones");
                                pausa();

                                do {
                                    limpiarPantalla();
                                    menu_habitaciones();
                                    System.out.println("\nDigite la opcion: ");
                                    opcionHabitaciones = leer.nextInt();

                                    switch (opcionHabitaciones) {
                                        case 1:
                                            System.out.println("\nUsted ha seleccionado la opcion habitacion personal");
                                            pausa();
                                            System.out.println("HABITACION PERSONAL");
                                            System.out.println("CAPACIDAD: 1 persona");
                                            System.out.println("");
                                            break;
                                        case 2:
                                            System.out.println( "\nUsted ha seleccionado la opcion habitacion matrimonial");
                                            pausa();
                                            System.out.println("HABITACION MATRIMONIAL");
                                            System.out.println("CAPACIDAD: 2 persona");
                                            System.out.println("");
                                            break;
                                        case 3:
                                            System.out.println("\nUsted ha seleccionado la opcion habitacion familiar");
                                            pausa();
                                            System.out.println("HABITACION FAMILIAR");
                                            System.out.println("CAPACIDAD: 3 persona");
                                            System.out.println("");
                                            break;
                                    }

                                    break;
                                } while (opcionHabitaciones >= 1 && opcionHabitaciones < 4); {

                            }

                            break;

                            case 2:
                                System.out.println("\nUsted ha seleccionado la opcion restaurante");
                                pausa();
                                
                                do {
                                    limpiarPantalla();
                                    menu_restaurante();
                                    System.out.println("\nDigite la opcion: ");
                                    opcionRestaurante = leer.nextInt();

                                    switch (opcionRestaurante) {
                                        case 1:
                                            System.out.println("\nUsted ha seleccionado la opcion comidas para el desayuno");
                                            pausa();
                                            break;
                                        case 2:
                                            System.out.println( "\nUsted ha seleccionado la opcion comidas para el almuerzo");
                                            pausa();
                                            break;
                                        case 3:
                                            System.out.println("\nUsted ha seleccionado la opcion comidas para la cena");
                                            pausa();

                                            break;
                                    }

                                    break;
                                } while (opcionRestaurante >= 1 && opcionRestaurante < 4); {

                            }

                                break;

                            case 3:
                                System.out.println("\nUsted ha seleccionado la opcion eventos");
                                pausa();

                                do {
                                    limpiarPantalla();
                                    menu_eventos();
                                    System.out.println("\nDigite la opcion: ");
                                    opcionEventos = leer.nextInt();

                                    switch (opcionEventos) {
                                        case 1:
                                            System.out.println("\nUsted ha seleccionado la opcion Boda");
                                            pausa();
                                            break;
                                        case 2:
                                            System.out.println( "\nUsted ha seleccionado la opcion Cumpleaños");
                                            pausa();
                                            break;
                                        case 3:
                                            System.out.println("\nUsted ha seleccionado la opcion conferencias empresariales");
                                            pausa();

                                            break;
                                    }

                                    break;
                                } while (opcionEventos >= 1 && opcionEventos < 4); {

                            }

                                break;

                            default:
                                break;
                        }

                    } while (opcionServicios >= 1 && opcionServicios < 4);
                    break;
                case 3:
                    System.out.println("Gestion de empleados");
                    pausa();
                    break;
                case 4:
                    System.out.println("Gestion de clientes");
                    pausa();
                    break;
            }

        } while (op >= 1 && op < 5);
        System.out.println("gracias por utilizar el software");

    }

    public static void limpiarPantalla() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void pausa() {
        leer.nextLine();
        System.out.println("\t\nPresione enter para continuar...");
        leer.nextLine();
    }

    public static void menu_principal() {
        System.out.println("-----------------------");
        System.out.println("          MENU         ");
        System.out.println("-----------------------");
        System.out.println("1. Gestion de hotel");
        System.out.println("2. Gestion de servicios");
        System.out.println("3. Gestion de empleados");
        System.out.println("4. Gestion de clientes");
        System.out.println("5. Salir.");

    }

    public static void menu_servicios() {
        System.out.println("------------------");
        System.out.println("    SERVICIOS     ");
        System.out.println("------------------");
        System.out.println("1. Habitaciones");
        System.out.println("2. Restaurante");
        System.out.println("3. Eventos");
        System.out.println("4. Regresar al menu principal");
        System.out.println();
        System.out.println("Seleccione una opcion.");

    }

    public static void menu_habitaciones() {
        System.out.println("------------------");
        System.out.println("   HABITACIONES   ");
        System.out.println("------------------");
        System.out.println("1. Habitacion personal");
        System.out.println("2. Habitacion matrimonial");
        System.out.println("3. Habitacion familiar");
        System.out.println("4. Regresar al menu de servicios");
        System.out.println();
        System.out.println("Seleccione una opcion.");
    }
    public static void menu_restaurante() {
        System.out.println("------------------");
        System.out.println("   RESTAURANTE    ");
        System.out.println("------------------");
        System.out.println("1. Comidas para el desayuno");
        System.out.println("2. comidas para el almuerzo");
        System.out.println("3. comidas para la cena");
        System.out.println("4. Regresar al menu de servicios");
        System.out.println();
        System.out.println("Seleccione una opcion.");
    }

    public static void menu_eventos() {
        System.out.println("------------------");
        System.out.println("      EVENTOS     ");
        System.out.println("------------------");
        System.out.println("1. Bodas");
        System.out.println("2. Cumpleaños");
        System.out.println("3. Conferencias empresariales");
        System.out.println("4. Regresar al menu de servicios");
        System.out.println();
        System.out.println("Seleccione una opcion.");
    }
}