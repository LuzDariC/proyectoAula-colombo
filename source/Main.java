import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[][] inforUser = new String[100][4];
        String[][] userSesion = new String[100][2];

        int userCount = 0;
        int userSesionCount = 0;
        int opcionHotel, opcionHabitacion, opcionRestaurante, opcionServicio, opcionEvento;
        String bup = null;
        String nombreuser, apellido, cedula;
        String hotel;

        String usuarioInicio = ""; 
        String ContraseñaInicio = "";

        int contador = 0;
        String user[] = new String[100000];

        do {
            limpiarPantalla();
            System.out.println("--------------------------");
            System.out.println("-        HOTELES         -");
            System.out.println("--------------------------");
            System.out.println("1. Hotel Svenish.");
            System.out.println("2. Hotel Seaside.");
            System.out.println("3. Hotel Astoria.");
            System.out.println("4. Salir");
            System.out.println();
            System.out.println("Seleccione el hotel que desea.");

            do {
                bup = entrada.nextLine();
            } while (!isInteger(bup));

            opcionHotel = Integer.parseInt(bup);

            switch (opcionHotel) {

                case 1:
                    limpiarPantalla();
                    System.out.println("--------------------------");
                    System.out.println("-     HOTEL SVENISH      -");
                    System.out.println("--------------------------");
                    System.out.println();

                    if (contador < user.length) {

                        System.out.print("Ingresa tu CC: ");
                        String CC = entrada.next();
                        System.out.print("Ingresa tu nombre: ");
                        String nombre = entrada.next();
                        System.out.print("Ingresa tu email: ");
                        String email = entrada.next();

                        inforUser[userCount][0] = CC;
                        inforUser[userCount][1] = nombre;
                        inforUser[userCount][2] = email;

                        System.out.println("Agregado correctamente!");

                        userSesion[userSesionCount][0] = CC;
                        userSesion[userSesionCount][1] = email;
                        userSesionCount++;

                    } else {
                        System.out.println("No eres tu, somos nosotros");

                    }
                    do {
                        limpiarPantalla();
                        System.out.println();
                        System.out.println("SERVICIOS");
                        System.out.println();

                        System.out.println("1. Reserva de habitaciones.");
                        System.out.println("2. Reserva de restaurantes");
                        System.out.println("3. Reserva de eventos.");
                        System.out.println("4. Salir");
                        System.out.println();
                        System.out.println("Ingrese una opcion.");
                        opcionServicio = entrada.nextInt();

                        switch (opcionServicio) {

                            case 1:
                                limpiarPantalla();
                                System.out.println();
                                System.out.println("HABITACIONES");
                                System.out.println();

                                do {
                                    System.out.println("Seleccione el tipo de habitacion:");
                                    System.out.println("1. Habitacion Personal.");
                                    System.out.println("2. Habitacion Matrimonial");
                                    System.out.println("3. Habitacion para 3 personas");
                                    System.out.println("4. Habitacion Familiar");
                                    System.out.println("5. Regresar a menu anterior");
                                    System.out.println();
                                    System.out.println("Ingrese una opcion");
                                    opcionHabitacion = entrada.nextInt();

                                    switch (opcionHabitacion) {
                                        case 1:
                                            mostrarFactura(inforUser[userCount], "Habitacion Personal",
                                                    "Habitacion 101", "COP 120000");
                                            break;
                                        case 2:
                                            mostrarFactura(inforUser[userCount], "Habitacion Matrimonial",
                                                    "Habitacion 201", "COP 270000");
                                            break;
                                        case 3:
                                            mostrarFactura(inforUser[userCount], "Habitacion para 3 personas",
                                                    "Habitacion 301", "COP 340000");
                                            break;
                                        case 4:
                                            mostrarFactura(inforUser[userCount], "Habitacion Familiar", "",
                                                    "COP 570000");
                                            break;
                                        case 5:
                                            // Regresar al menu anterior
                                            break;
                                    }

                                    if (opcionHabitacion != 5) {

                                        System.out.println("¿Seguro que desea regresar al menu principal? (S/N)");
                                        String confirmacion = entrada.next().toUpperCase();
                                        if (confirmacion.equals("S")) {
                                            break;
                                        }
                                    }

                                } while (opcionHabitacion != 5);
                                break;

                            case 2:

                                break;

                            case 3:

                                break;
                        }

                    } while (opcionServicio != 4);
                    break;

                case 2:
                case 3:

                    break;

                case 4:
                    System.out.println("Saliendo...");
                    System.out.println("Has salido del programa");
                    break;

                default:
                    System.out.println("Opcion inválida");
                    break;
            }
        } while (opcionHotel != 4);
    }

    public static boolean isInteger(String wd) {

        try {

            Integer.parseInt(wd);

            return true;

        } catch (Exception e) {

            System.out.println("Valor ingresado no numerico");

            return false;

        }

    }

    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");// Simbolizacion para limpiar pantalla
            }
        } catch (Exception ex) {
            System.out.println("Error al limpiar la pantalla: " + ex.getMessage());
        }
    }

    public static void mostrarFactura(String[] userData, String habitacionTipo, String habitacionReservada,
            String precio) {
        limpiarPantalla();
        System.out.println("--------------------------");
        System.out.println("|         FACTURA        |");
        System.out.println("--------------------------");
        System.out.println("| Usuario: " + userData[1]);
        System.out.println("| Cédula: " + userData[0]);
        System.out.println("| Email: " + userData[2]);
        System.out.println("| Habitacion tipo: " + habitacionTipo);
        if (!habitacionReservada.isEmpty()) {
            System.out.println("| Habitacion reservada: " + habitacionReservada);
        }
        System.out.println("| Precio: " + precio);
        System.out.println("--------------------------");
        System.out.println("Presione Enter para regresar al menu principal...");
        new Scanner(System.in).nextLine();
    }
}
