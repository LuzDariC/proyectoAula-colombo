import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        limpiarPantalla();
        // Menu
        Scanner entrada = new Scanner(System.in);
        Empleado[] empleados = new Empleado[10];
        Cliente[] clientes = new Cliente[5];
        ReservaHabitacion [] reservasHabitaciones = new ReservaHabitacion[10];
        String [] habitacion = new String[5];
        
        habitacion[0] = "Habitacion 101";
        habitacion[1] = "Habitacion 102";
        habitacion[2] = "Habitacion 103";
        habitacion[3] = "Habitacion 104";
        habitacion[4] = "Habitacion 105";
        
        
        int cantidadClientes = 0;
        int cantidadEmpleados = 0;
        int cantidadReservasHabitaciones = 0;
        
        do {
            System.out.println("---------------------------------");
            System.out.println("               MENU              ");
            System.out.println("---------------------------------");
            System.out.println("1. Gestionar empleados");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Gestionar Reserva de habitacion");
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
                    gestionarReservaDeHabitacion(reservasHabitaciones, clientes, cantidadReservasHabitaciones, cantidadClientes, entrada);
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
                        Cliente.AñadirClientes(clientes, cantidadClientes, entrada);
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
    private static void gestionarReservaDeHabitacion (ReservaHabitacion[] reservaHabitaciones, Cliente[] clientes, int cantidadReservas,
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
            System.out.println("--------------------------------");
            System.out.println(" GESTIONAR RESERVA DE HABITACION ") ;
            System.out.println("--------------------------------");
            System.out.println();
            System.out.println("1. Añadir reserva");
            System.out.println("2. Listar reserva");
            System.out.println("3. modificar reserva");
            System.out.println("4. Eliminar reserva");
            System.out.println("5. Salir");
            System.out.println();
            int opcionGestionReservaHabitacion = 0;

            while (true) {
                System.out.print("Digite una opcion: ");
                if (entrada.hasNextInt()) {
                    opcionGestionReservaHabitacion = entrada.nextInt();
                    if (opcionGestionReservaHabitacion >= 1 && opcionGestionReservaHabitacion <= 5) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese una opcion valida (1-5).");
                    }
                } else {
                    System.out.println("Por favor, ingrese un numero entero.");
                    entrada.nextLine();

                }
            }
            switch (opcionGestionReservaHabitacion) {
                case 1:
                  
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
    
    }