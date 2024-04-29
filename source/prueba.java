import java.util.Scanner;

public class prueba {
    //Carlos hackeo a luz dary

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion, opcion2, opcion3, opcion4, opcionServicio;
        String bup = null;
        String nombreUsuario, apellido;
        String cedula;

        int contador = 0;
        String usuario[] = new String[100];
       

        do {
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

            opcion = Integer.parseInt(bup);

            switch (opcion) {
                case 1:
                    System.out.println("--------------------------");
                    System.out.println("-     HOTEL SVENISH      -");
                    System.out.println("--------------------------");
                    System.out.println();

                    if (contador < usuario.length) {

                        System.out.println("Intruzca su nombre:");
                        nombreUsuario = entrada.nextLine();

                        System.out.println("Intruzca su apellido: ");
                        apellido = entrada.nextLine();

                        System.out.println("Introduzca su cedula de identificación");
                        cedula = entrada.nextLine();

                        String nuevoUsuario = cedula + "," + nombreUsuario + "," + apellido;
                        usuario[contador] = nuevoUsuario;
                        contador++;
                    }
                    if (contador > 0) {
                        for (int i = 0; i < contador; i++) {
                            String data[] = usuario[i].split(",");
                            cedula = data[0];
                            nombreUsuario = data[1];
                            apellido = data[2];

                        }

                    }
                    do {
                        System.out.println();
                        System.out.println("SERVICIOS");
                        System.out.println();

                        System.out.println("1. Reserva de habitaciones.");
                        System.out.println("2. Reserva de restaurantes");
                        System.out.println("3. Reserva de eventos.");
                        System.out.println("4. Salir");
                        System.out.println();
                        System.out.println("Ingrese una opción.");
                        opcionServicio = entrada.nextInt();

                        // aquiluz

                        switch (opcionServicio) {

                            case 1:
                                System.out.println();
                                System.out.println("HABITACIONES");
                                System.out.println();

                                do {
                                    System.out.println("Seleccione el tipo de habitación:");
                                    System.out.println("1. Habitacion Personal.");
                                    System.out.println("2. Habitacion Matrimonial");
                                    System.out.println("3. Habitacion para 3 personas");
                                    System.out.println("4. Habitacion Familiar");
                                    System.out.println("5. Regresar a menú anterior");
                                    System.out.println();
                                    System.out.println("Ingrese una opcion");
                                    opcion3 = entrada.nextInt();

                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("Habitacion personal ha sido reservada");
                                            System.out.println("Habitacion 101");
                                            System.out.println("El precio es de: COP 120000");
                                            double HabitacionPersonal = 120000;
                                            System.out.println();
                                            break;
                                        case 2:
                                            System.out.println("Habitacion matrimonial ha sido reservada");
                                            System.out.println("Habitacion 201");
                                            System.out.println("El precio es de: COP 270000");
                                            double HabitacionMatrimonial = 270000;
                                            break;
                                        case 3:
                                            System.out.println("Habitacion para 3 ha sido reservada");
                                            System.out.println("Habitacion 301");
                                            System.out.println("El precio es de: COP 340000");
                                            double Habitacion3Personas = 340000;
                                            break;
                                        case 4:
                                            System.out.println("Habitacion familiar ha sido reservada");
                                            System.out.println("El precio es de: COP 570000");
                                            double HabitacionFamiliar = 570000;
                                            break;
                                        case 5:

                                            break;
                                    }

                                } while (opcion3 != 5);
                                break;

                            // HABITACIONES FIN

                            case 2:
                                System.out.println("RESTAURANTE");
                                boolean mostrarMenuComidas = true; // Para controlar si se muestra el menú de comidas

                                do {
                                    if (mostrarMenuComidas) {
                                        System.out.println("Desea su comida para: ");
                                        System.out.println("1. Desayuno");
                                        System.out.println("2. Almuerzo");
                                        System.out.println("3. Cena");
                                        System.out.println("4. Salir");
                                    }
                                    opcion4 = entrada.nextInt();

                                    switch (opcion4) {
                                        case 1:
                                            System.out.println("DESAYUNO");
                                            System.out.println(
                                                    "1. Ensalada griega de tomate, pepino, aceitunas y queso feta.");
                                            System.out.println("2. Huevos revueltos con tocino");
                                            System.out.println("3. Tostadas con aceite de oliva y tomate");
                                            System.out.println("4. Rollitos de primavera de vegetales");
                                            System.out.println("5. Regresar al menu. ");
                                            System.out.println("Seleccione la comida:");

                                            int Desayuno = entrada.nextInt();

                                            switch (Desayuno) {
                                                case 1:
                                                    System.out.println("Precio es: 50000");
                                                    double precio1 = entrada.nextDouble(); // El precio del plato 1

                                                    break;
                                                case 2:
                                                    System.out.println("Precio es: 50000");
                                                    double precio2 = entrada.nextDouble(); // El precio del plato 2
                                                    break;

                                                case 3:
                                                    System.out.println("Precio es: 50000");
                                                    double precio3 = entrada.nextDouble(); // El precio del plato 3

                                                    break;

                                                case 4:
                                                    System.out.println("Precio es: 50000");
                                                    double precio4 = entrada.nextDouble(); // El precio del plato 4
                                                    break;

                                                case 5:

                                                    break;

                                                default:
                                                    System.out.println("La opción seleccionada no esta disponible!");

                                                    break;
                                            }

                                            break;
                                        case 2:
                                            System.out.println("ALMUERZO");
                                            System.out.println("1. Risotto de champiñones");
                                            System.out.println("2. Pollo al curry con arroz y guisantes");
                                            System.out.println("3. Tacos de pollo con salsa de cilantro y cebolla.");
                                            System.out.println("4. Arroz con pescado y ensalada de payaso");
                                            int Almuerzo = entrada.nextInt();

                                            int almuerzo = entrada.nextInt();

                                            switch (almuerzo) {
                                                case 1:
                                                    System.out.println("Precio es: 47000");
                                                    double precio1Almuerzo = entrada.nextDouble(); // El precio del
                                                                                                   // plato 1

                                                    break;
                                                case 2:
                                                    System.out.println("Precio es: 67000");
                                                    double precio2Almuerzo = entrada.nextDouble(); // El precio del
                                                                                                   // plato 2
                                                    break;

                                                case 3:
                                                    System.out.println("Precio es: 70000");
                                                    double precio3Almuerzo = entrada.nextDouble(); // El precio del
                                                                                                   // plato 3

                                                    break;

                                                case 4:
                                                    System.out.println("Precio es: 81000");
                                                    double precio4Almuerzo = entrada.nextDouble(); // El precio del
                                                                                                   // plato 4
                                                    break;

                                                case 5:

                                                    break;
                                                default:
                                                    System.out.println("La opción seleccionada no esta disponible!");

                                                    break;
                                            }

                                            break;

                                        case 3:
                                            System.out.println("CENA");
                                            System.out.println("1. Pasta carbonara.");
                                            System.out.println("2. Salmón a la parrilla con salsa de limón y eneldo.");
                                            System.out.println("3. Pollo al horno con hierbas y limón. ");
                                            System.out.println("4. Sushi rolls de salmón y aguacate. ");
                                            int Cena = entrada.nextInt();

                                            int cena = entrada.nextInt();

                                            switch (cena) {
                                                case 1:
                                                    System.out.println("Precio es: 47000");
                                                    double precio1cena = entrada.nextDouble(); // El precio del plato 1

                                                    break;
                                                case 2:
                                                    System.out.println("Precio es: 67000");
                                                    double precio2cena = entrada.nextDouble(); // El precio del plato 2
                                                    break;

                                                case 3:
                                                    System.out.println("Precio es: 70000");
                                                    double precio3cena = entrada.nextDouble(); // El precio del plato 3

                                                    break;

                                                case 4:
                                                    System.out.println("Precio es: 81000");
                                                    double precio4cena = entrada.nextDouble(); // El precio del plato 4
                                                    break;

                                                case 5:

                                                    break;

                                                default:
                                                    System.out.println("La opción seleccionada no esta disponible!");

                                                    break;
                                            }

                                            break;
                                        case 4:
                                            System.out.println("¡Ha salido con exito!");
                                            System.out.println("Vuelva pronto.");
                                            mostrarMenuComidas = false;
                                            break;
                                        default:
                                            System.out.println("Ingrese una opcion valida");
                                            break;
                                    }

                                } while (opcion4 != 4);
                                break;

                            // RESTAURANTE COMIDAS FIN

                        }

                    } while (opcionServicio != 4);
                    break;

                case 2:
                    System.out.println("Hotel Seaside");
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Hotel Astoria");
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    System.out.println("Has salido del programa");
                    break;

                default:
                    System.out.println("Opción invalida");
                    break;
            }
        } while (opcion != 4);
    }

    public static boolean isInteger(String wd) {

        try {

            Integer.parseInt(wd);

            return true;

        } catch (Exception e) {

            System.out.println("Valor ingresado no nùmerico");

            return false;

        }

    }
}
