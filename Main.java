import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        limpiarPantalla();
        // Menu
        Scanner entrada = new Scanner(System.in);
        Empleado[] empleados = new Empleado[10];
        Cliente[] clientes = new Cliente[5];
        Reserva[] reservas = new Reserva[10];
        int cantidadClientes = 0;
        int cantidadEmpleados = 0;
        int cantidadReservas = 0;
        do {
            System.out.println("---------------------------------");
            System.out.println("               MENU              ");
            System.out.println("---------------------------------");
            System.out.println("1. Gestionar empleados");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Gestionar Reserva");
            System.out.println("4. Salir");

            int opcion = 0;
            while (true) {
                System.out.print("Digite una opcion: ");
                if (entrada.hasNextInt()) {
                    opcion = entrada.nextInt();
                    if (opcion >= 1 && opcion <= 4) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese una opcion valida (1-4).");
                    }
                } else {
                    System.out.println("Por favor, ingrese un numero entero.");
                    entrada.nextLine();
                }
            }
            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    Empleado.gestionarEmpleados(empleados, cantidadEmpleados, entrada);
                    break;

                case 2:
                    limpiarPantalla();
                    gestionarClientes(clientes, cantidadClientes, entrada);
                    break;

                case 3:
                    limpiarPantalla();
                    gestionarReserva(reservas, clientes, cantidadReservas, cantidadClientes, entrada);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (true);

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

    public static void gestionarClientes(Cliente[] clientes, int cantidadClientes, Scanner entrada) {
        do {
            System.out.println("-----------------------------");
            System.out.println("     GESTIONAR CLIENTES      ");
            System.out.println("-----------------------------");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Modificar clientes");
            System.out.println("4. Eliminar clientes");
            System.out.println("5. Salir");
            int opcionGestion = 0;
            while (true) {
                System.out.print("Digite una opcion: ");
                if (entrada.hasNextInt()) {
                    opcionGestion = entrada.nextInt();
                    if (opcionGestion >= 1 && opcionGestion <= 5) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese una opcion valida (1-5).");
                    }
                } else {
                    System.out.println("Por favor, ingrese un numero entero.");
                    entrada.nextLine();
                }
            }

            switch (opcionGestion) {
                case 1:
                    limpiarPantalla();
                    if (cantidadClientes < clientes.length) {
                        Cliente.guardarClientes(clientes, cantidadClientes, entrada);
                        cantidadClientes++;
                    } else  System.out.println("No se pueden agregar más clientes, se alcanzo el limite.");
                   

                    break;
                case 2:
                    limpiarPantalla();
                    Cliente.listarClientes(clientes, cantidadClientes);
                    break;
                case 3:
                    limpiarPantalla();
                    Cliente.modificarClientes(clientes, cantidadClientes, entrada);
                    break;
                case 4:
                    limpiarPantalla();
                    Cliente.eliminarClientes(clientes, cantidadClientes, entrada);
                    break;
                case 5:
                    return;
                default:

                    break;
            }

        } while (true);
    }
    private static void gestionarReserva(Reserva[] reservas, Cliente[] clientes, int cantidadReservas,
            int cantidadClientes, Scanner entrada) {
                Cliente clienteReserva = null;
        System.out.println("Verificar que el cliente este registrado");
        System.out.println();
        int cc;
        do {
            System.out.print("Digite su numero de cedula: ");

            while (!entrada.hasNextInt()) {
                System.out.println("Digite la cedula nuevamente, de manera correcta: ");
                entrada.nextInt();
            }
            cc = entrada.nextInt();

        } while ((String.valueOf(cc).length() != 8) && (String.valueOf(cc).length() != 10));

        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getcedula() == cc) {
                clienteReserva = clientes[i];
                System.out.println("El cliente "+ clientes[i].getnombre() +" se encuentra registrado!");
                break;
            }
        }
        if (clienteReserva == null) {
            System.out.println(
                    "El cliente con la cedula ingresada no esta registrado, registrese antes de realizar una reserva");
            return;
        }

        do {
            System.out.println("------------------------");
            System.out.println("    GESTIONAR RESERVA   ");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("1. Añadir reserva");
            System.out.println("2. Listar reserva");
            System.out.println("3. modificar reserva");
            System.out.println("4. Eliminar reserva");
            System.out.println("5. Salir");
            System.out.println();
            int opcionGestionReserva = 0;

            while (true) {
                System.out.print("Digite una opcion: ");
                if (entrada.hasNextInt()) {
                    opcionGestionReserva = entrada.nextInt();
                    if (opcionGestionReserva >= 1 && opcionGestionReserva <= 5) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese una opcion valida (1-5).");
                    }
                } else {
                    System.out.println("Por favor, ingrese un numero entero.");
                    entrada.nextLine();

                }
            }
            switch (opcionGestionReserva) {
                case 1:
                    if (cantidadReservas < reservas.length) {
                        guardarReserva(reservas, cantidadReservas, entrada);
                        cantidadReservas++;
                    } else {

                    }
                    break;
                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    return;

                default:
                    break;
            }
        } while (true);

    }

    public static void guardarReserva(Reserva[] reservas, int cantidadReservas, Scanner entrada) {
        System.out.println();
        limpiarPantalla();
        do {
            System.out.println("------------------------");
            System.out.println("  SERVICIOS A RESERVAR  ");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("1. Reserva de habitaciones");
            System.out.println("2. Reserva de Buffets");
            System.out.println("3. Reserva de Salon de eventos");
            System.out.println("4. Salir");
            System.out.println();
            int opcionReserva = 0;
            while (true) {
                System.out.print("Digite una opcion: ");
                if (entrada.hasNextInt()) {
                    opcionReserva = entrada.nextInt();
                    if (opcionReserva >= 1 && opcionReserva <= 4) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese una opcion valida (1-4).");
                    }
                } else {
                    System.out.println("Por favor, ingrese un numero entero.");
                    entrada.nextLine();
                }
            }
            switch (opcionReserva) {
                case 1:
                    limpiarPantalla();
                    habitaciones(reservas, cantidadReservas, null, cantidadReservas, opcionReserva, entrada);
                    break;

                case 2:
                    limpiarPantalla();
                    buffets(entrada);
                    break;

                case 3:
                    limpiarPantalla();
                    salon(entrada);
                    break;
                case 4:
                    return;
            }

        } while (true);

    }

    public static void habitaciones(Reserva[] reservas, int cantidadReservas, Cliente[] clientes, int cantidadClientes,
            int opcionReserva, Scanner entrada) {

        limpiarPantalla();
        String[] opciones = { "Habitacion personal", "Habitacion matrimonial", "Habitacion familiar" };

        do {
            System.out.println("-----------------------");
            System.out.println("     HABITACIONES      ");
            System.out.println("-----------------------");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }
            System.out.println((opciones.length + 1) + ". Salir");

            System.out.print("Elige una opción: ");
            opcionReserva = entrada.nextInt();
            System.out.println();

            if (opcionReserva >= 1 && opcionReserva <= opciones.length) {
                System.out.println("          FACTURA           ");
                System.out.println("");
                System.out.println();
                System.out.println("Servicio reservado: " + opciones[opcionReserva - 1]);

                System.out.println();
            } else if (opcionReserva == opciones.length + 1) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
            break;

        } while (opcionReserva != opciones.length + 1);
    }

    public static void buffets(Scanner entrada) {
        limpiarPantalla();
        do {
            System.out.println("-------------------------------");
            System.out.println("             BUFFET            ");
            System.out.println("-------------------------------");
            System.out.println("1. Buffet servicio a la mesa");
            System.out.println("2. Buffet autoservicio");
            System.out.println("3. Salir");
            System.out.println();
            int opcionBuffet = 0;
            while (true) {
                System.out.print("Digite una opcion: ");
                if (entrada.hasNextInt()) {
                    opcionBuffet = entrada.nextInt();
                    if (opcionBuffet >= 1 && opcionBuffet <= 3) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese una opcion valida (1-3).");
                    }
                } else {
                    System.out.println("Por favor, ingrese un numero entero.");
                    entrada.nextLine();
                }
            }
            switch (opcionBuffet) {
                case 1:

                    break;

                default:
                    break;
            }

        } while (true);

    }

    public static void salon(Scanner entrada) {
        do {
            limpiarPantalla();
            System.out.println("------------------------------");
            System.out.println("       SALON DE EVENTOS       ");
            System.out.println("------------------------------");
            System.out.println("1. Para conferencia de trabajos");
            System.out.println("2. salon de eventos sociales");
            System.out.println("3. Salir");
            int opcionSalon = 0;

            while (true) {
                System.out.print("Digite una opcion: ");
                if (entrada.hasNextInt()) {
                    opcionSalon = entrada.nextInt();
                    if (opcionSalon >= 1 && opcionSalon <= 3) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese una opcion valida (1-3).");
                    }
                } else {
                    System.out.println("Por favor, ingrese un numero entero.");
                    entrada.nextLine();

                }
            }
            switch (opcionSalon) {
                case 1:
                    break;
                case 2:
                    break;

                case 3:
                    break;
            }

        } while (true);

    }

    public static void listarReserva(Reserva[] reservas, int cantidadReservas) {
        System.out.println("-------------------------------");
        System.out.println("          LISTA RESERVA        ");
        System.out.println("-------------------------------");
        if (cantidadReservas <= 0) {

            System.out.println("No hay reservas");
            System.out.println();

        } else {
            
        }
        for (int i = 0; i < cantidadReservas; i++) {
            if (reservas[i] != null) {
                System.out.println();

            }
        }
    }
}