import java.util.Scanner;

public class prueba2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion, opcion2, opcion3, opcion4;
        int opcionUno, opcionDos, opcionTres, Opcioncuatro;
        String bup = null;
        String nombreUsuario, apellido;
        int cedula;
        int numeroUsers = 0;
        String usuario [] = new String [1000];

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

            do{
                
                bup = entrada.nextLine();
            
            }while(!isInteger(bup));

            opcion = Integer.parseInt(bup);

            switch (opcion) {
                case 1:
                    System.out.println("--------------------------");
                    System.out.println("-     HOTEL SVENISH      -");
                    System.out.println("--------------------------");

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
                        opcion2 = entrada.nextInt();

                        switch (opcion2) {

                            case 1:
                                System.out.println("HABITACIONES");

                                do {
                                    System.out.println("Seleccione el tipo de habitación:");
                                    System.out.println("1. Habitacion Personal.");
                                    System.out.println("2. Habitacion Matrimonial");
                                    System.out.println("3. Habitacion para 3 personas");
                                    System.out.println("4. Habitacion Familiar");
                                    System.out.println("5. Salir");
                                    System.out.println();
                                    System.out.println("Ingrese una opcion");
                                    opcion3 = entrada.nextInt();

                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("Reservado");
                                            System.out.println("El precio es de: COP 120000");
                                            break;
                                        case 2:
                                            System.out.println("Reservado");
                                            System.out.println("El precio es de: COP 270000");
                                            break;
                                        case 3:
                                            System.out.println("Reservado");
                                            System.out.println("El precio es de: COP 340000");
                                            break;
                                        case 4:
                                            System.out.println("Reservado");
                                            System.out.println("El precio es de: COP 570000");
                                            break;
                                        case 5:
                                            System.out.println("¡Ha salido de la aplicacion");
                                            break;
                                    }

                                } while (opcion3 != 5);
                                break;

                                //HABITACIONES FIN

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
                                            System.out.println("1. Ensalada griega de tomate, pepino, aceitunas y queso feta.");
                                            System.out.println("2. Huevos revueltos con tocino");
                                            System.out.println("3. Tostadas con aceite de oliva y tomate");
                                            System.out.println("4. Rollitos de primavera de vegetales");
                                            System.out.println("5. Regresar al menu. ");
                                            System.out.println("Seleccione la comida:");
                                           

                                            int Desayuno=entrada.nextInt();

                                            switch (Desayuno) {
                                                case 1:
                                                System.out.println("Precio es: 50000");
                                                double precio1=entrada.nextInt(); //El precio del plato 1
                                                    
                                                    break;
                                                    case 2:
                                                    System.out.println("Precio es: 50000");
                                                    double precio2=entrada.nextInt(); //El precio del plato 2
                                                    break;

                                                    case 3:
                                                System.out.println("Precio es: 50000");
                                                double precio3=entrada.nextInt(); //El precio del plato 3
                                                    
                                                    break;

                                                    case 4:
                                                System.out.println("Precio es: 50000");
                                                double precio4=entrada.nextInt(); //El precio del plato 4
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
                                            int Almuerzo=entrada.nextInt();

                                            int almuerzo=entrada.nextInt();

                                            switch (almuerzo) {
                                                case 1:
                                                System.out.println("Precio es: 47000");
                                                double precio1Almuerzo=entrada.nextInt(); //El precio del plato 1
                                                    
                                                    break;
                                                    case 2:
                                                    System.out.println("Precio es: 67000");
                                                    double precio2Almuerzo=entrada.nextInt(); //El precio del plato 2
                                                    break;

                                                    case 3:
                                                System.out.println("Precio es: 70000");
                                                double precio3Almuerzo=entrada.nextInt(); //El precio del plato 3
                                                    
                                                    break;

                                                    case 4:
                                                System.out.println("Precio es: 81000");
                                                double precio4Almuerzo=entrada.nextInt(); //El precio del plato 4
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
                                            int Cena=entrada.nextInt();

                                            
                                            int cena=entrada.nextInt();

                                            switch (cena) {
                                                case 1:
                                                 System.out.println("Precio es: 47000");
                                                 double precio1cena=entrada.nextInt(); //El precio del plato 1
                                                 break;
                                                case 2:
                                                 System.out.println("Precio es: 67000");
                                                 double precio2cena=entrada.nextInt(); //El precio del plato 2
                                                 break;

                                                case 3:
                                                  System.out.println("Precio es: 70000");
                                                  double precio3cena=entrada.nextInt(); //El precio del plato 3 
                                                  break;

                                                case 4:
                                                System.out.println("Precio es: 81000");
                                                double precio4cena=entrada.nextInt(); //El precio del plato 4
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

                                //RESTAURANTE COMIDAS FIN

                        }

                    } while (opcion2 != 4);
                    break;

                case 2:
                    System.out.println("Hotel Seaside");
                    System.out.println("Hotel Seaside");
                    // AQUI
                    System.out.println("--------------------------");
                    System.out.println("-     HOTEL SEASIDE      -");
                    System.out.println("--------------------------");
                    System.out.println("");

                    do{
                        System.out.println("SERVICIOS");
                        System.out.println("1. Reserva de habitaciones.");
                        System.out.println("2. Reserva de restaurante.");
                        System.out.println("3. Reserva de parque atracciones.");
                        System.out.println("4. Salir.");
                        System.out.println("");
                        System.out.println("Por favor seleccione una opcion");
                        opcionUno = entrada.nextInt();

                        switch (opcionUno) {
                            case 1:

                            System.out.println("HABITACIONES");

                            do{
                                System.out.println();
                            System.out.println("1.Habitacion personal");
                            System.out.println("2. Habitacion matrimonial");
                            System.out.println("3. Habitacion para tres personas");
                            System.out.println("4. Habitacion familiar");
                            System.out.println("5. Salir");
                            System.out.println();
                            System.out.println("Por favor seleccione una opcion");
                            opcionDos = entrada.nextInt();

                            switch (opcionDos) {
                                case 1:
                                System.out.println("RESERVADO");
                                System.out.println("El precio es de COP $150000");

                                case 2:
                                System.out.println("RESERVADO");
                                System.out.println("El precio es de COP $260000");

                                case 3:
                                System.out.println("RESERVADO");
                                System.out.println("El precio es de COP $300000");

                                case 4:
                                System.out.println("RESERVADO");
                                System.out.println("El precio es de cop $370000");

                                case 5:
                                System.out.println("¡Haz salido de la aplicacion!");

                                    
                                    break;
                            
                                default:
                                    break;
                            }

                            } while (opcion != 5);
                            
                    System.out.println("");
                    break;

                    case 2: 
                    System.out.println("Restaurante");
                    boolean mostrarMenuComidas = true;
                    do{
                        if (mostrarMenuComidas){

                            System.out.println("Desea su comida para:");
                            System.out.println("1. Desayuno");
                            System.out.println("2. Almuerzo");
                            System.out.println("3. Cena.");
                            System.out.println("4. Salir.");

                        }
                        System.out.println("Seleccione la opcion que desee: ");
                        opcionTres = entrada.nextInt();

                        switch (opcionTres) {
                            case 1:
                            System.out.println("DESAYUNOS");
                            System.out.println("1. Tortilla de dulce de kiwi, fresas y pera.");
                            System.out.println("2. Crumble de manzana con maiz.");
                            System.out.println("3. Macedonia de piña y grocellas");
                            System.out.println("4. Muesli de avena con arandanos");
                            System.out.println("5. Salir.");
                            System.out.println("Ingrese la opcion que desee");
                            int Desayuno2 = entrada.nextInt();
                            switch (Desayuno2) {
                                case 1:
                                System.out.println("El precio es: COP $25000");
                                double precioPlato1=entrada.nextInt(); // precio plato 1
                                break;
                                
                                case 2:
                                System.out.println("El precio es: COP $20000");
                                double precioPlato2=entrada.nextInt(); // precio plato 2 y asi
                                break; 
                                case 3:
                                System.out.println("El precio es: COP 30000");
                                double precioPlato3=entrada.nextInt();
                                break;

                                case 4:
                                System.out.println("El precio es: COP $35000");
                                double precioPlato4=entrada.nextInt();
                                break;

                                case 5:
                                System.out.println("Ha salido exitosamente");
                                    
                                    break;
                            
                                default: 
                                System.out.println("La opcion selccionda no esta disponible");
                                    break;
                            } 
                            while (opcionUno!=4) {
                                break;
                                
                            }


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
