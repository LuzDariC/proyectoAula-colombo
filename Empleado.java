import java.util.Scanner;

class Empleado {
        private int cedula;
        private String nombre;
        private String email;
        private String cargo;
    
        public Empleado(int cedula, String nombre, String email, String cargo) {
            this.cedula = cedula;
            this.nombre = nombre;
            this.email = email;
            this.cargo = cargo;
        }
        public int getcedula() {
            return cedula;
        }
    
        public void setcedula(int cedula) {
            this.cedula = cedula;
        }
    
        public String getnombre() {
            return nombre;
        }
    
        public void setnombre(String nombre) {
            this.nombre = nombre;
        }
    
        public String getemail() {
            return email;
        }
    
        public void setemail(String email) {
            this.email = email;
        }
    
        public String getcargo() {
            return cargo;
        }
    
        public void setcargo(String cargo) {
            this.cargo = cargo;
        }

        

        public static int gestionarEmpleados(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {
            do {
                System.out.println(" ----------------------------------");
                System.out.println("|        GESTIONAR EMPLEADOS       |");
                System.out.println(" ----------------------------------");
                System.out.println("1. Añadir empleados");
                System.out.println("2. Listar empleados");
                System.out.println("3. Modificar empleados");
                System.out.println("4. Eliminar empleados");
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
                        if (cantidadEmpleados < empleados.length) {
                            System.out.println("---------------------------------");
                            System.out.println("        GUARGAR EMPLEADOS        ");
                            System.out.println("---------------------------------");
                            AñadirEmpleados(empleados, cantidadEmpleados, entrada);
                            cantidadEmpleados++;
                        } else {
                        }
                        break;
                    case 2:
                        System.out.println("---------------------------------");
                        System.out.println("        LISTAR EMPLEADOS         ");
                        System.out.println("---------------------------------");
                        listarEmpleados(empleados, cantidadEmpleados);
                        break;
                    case 3:
                        System.out.println("---------------------------------");
                        System.out.println("        MODIFICAR EMPLEADOS      ");
                        System.out.println("---------------------------------");
                        modificarEmpleado(empleados, cantidadEmpleados, entrada);
                        break;
                    case 4:
                        System.out.println("---------------------------------");
                        System.out.println("        ELIMINAR EMPLEADOS        ");
                        System.out.println("---------------------------------");
                        eliminarEmpleado(empleados, cantidadEmpleados, entrada);
                        break;
                    case 5:
                        return opcionGestion;
                    default:
                     System.out.println("Opción invalida");
                    break;
                }
    
            } while (true);
        }

    public static void AñadirEmpleados(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {

        // CEDULA
        int cedula;
        System.out.print("Digite su cedula: ");
        entrada.nextLine();
        do {

            while (!entrada.hasNextInt()) {
                System.out.println("Digite la cedula nuevamente, de manera correcta");
                entrada.next();
            }
            cedula = entrada.nextInt();
        } while ((String.valueOf(cedula).length() != 8) && (String.valueOf(cedula).length() != 10));

        // NAME
        System.out.print("Digite su nombre: ");

        while (!entrada.hasNext("[a-z-A-Z]+")) {
            System.out.println("Digite nuevamente su nombre: ");
            entrada.next();
        }
        String nombre = entrada.next();

        // EMAIL

        System.out.print("Digite su email: ");
        String email = entrada.next();
        while (!email.contains("@")) {
            System.out.print("Digite el email nuevamente: ");
            entrada.next();
        }

        // CARGO
        System.out.print("Digite su cargo: ");

        while (!entrada.hasNext("[a-z-A-Z]+")) {
            System.out.println("Digite nuevamente su cargo: ");
            entrada.next();
        }
        String cargo = entrada.next();

        empleados[cantidadEmpleados] = new Empleado(cedula, nombre, email, cargo);
        System.out.println(" Guardado con exito!");
        System.out.println();
    }
     // LISTAR EMPLEADOS

     public static void listarEmpleados(Empleado[] empleados, int cantidadEmpleados) {
    
        System.out.println();
        if (cantidadEmpleados <= 0) {
            System.out.println("No hay empleados");
            System.out.println();
        } else
            System.out.println("                              Lista de empleados                                     ");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Nombre          Cedula                  Cargo                   Email                ");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i] != null) {
                System.out.println(empleados[i].getnombre() + "\t\t" + empleados[i].getcedula() + "\t\t"  + empleados[i].getcargo() + "\t\t" + empleados[i].getemail());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
    
    // MODIFICAR EMPLEADOS
    public static void modificarEmpleado(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {
        int Cedula;

        do {
            System.out.print("Digite la cedula a modificar : ");
            while (!entrada.hasNextInt()) {
                System.out.print("Digite la cedula nuevamente, de manera correcta: ");
                entrada.nextInt();
            }
            Cedula = entrada.nextInt();
        } while ((String.valueOf(Cedula).length() != 8) && (String.valueOf(Cedula).length() != 10));

        for (int i = 0; i < cantidadEmpleados; i++) {
            // Verificar si existe
            if (empleados[i].getcedula() == Cedula) {

                // CEDULA
                int nuevaCedula;
                System.out.print("Digite su nueva cedula: ");
                do {

                    while (!entrada.hasNextInt()) {
                        System.out.println("Digite la cedula nuevamente, de manera correcta");
                        entrada.next();
                    }
                    nuevaCedula = entrada.nextInt();
                } while ((String.valueOf(nuevaCedula).length() != 8) && (String.valueOf(nuevaCedula).length() != 10));

                // NOMBRE

                System.out.print("Digite su nuevo nombre: ");

                while (!entrada.hasNext("[a-z-A-Z]+")) {
                    System.out.println("Digite nuevamente su nombre: ");
                    entrada.next();
                }
                String nuevoNombre = entrada.next();

                // CORREO-EMAIL

                System.out.print("Digite su nuevo correo: ");
                String nuevoCorreo = entrada.next();
                while (!nuevoCorreo.contains("@")) {
                    System.out.println("Ingrese el correo de manera correcta");
                    entrada.next();

                }
                // CARGO
                System.out.print("Digite su nuevo cargo: ");
                while (!entrada.hasNext("[a-z-A-Z]+")) {
                    System.out.println("Digite el cargo de manera correcta");
                    entrada.next();
                }
                String nuevoCargo = entrada.next();

                empleados[i].setcedula(nuevaCedula);
                empleados[i].setnombre(nuevoNombre);
                empleados[i].setemail(nuevoCorreo);
                empleados[i].setcargo(nuevoCargo);

                System.out.println("Modificado con exito!");
                return;
            }
        }
    }
    
    public static void eliminarEmpleado(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {
        System.out.print("Digite la cedula a eliminar: ");
        int nuevaCedula = entrada.nextInt();

        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i].getcedula() == nuevaCedula) {
                System.out.println("Se ha encontrado al empleado: "+ empleados[i].getnombre());
                for (int j = i; j < cantidadEmpleados - 1; j++) {
                    empleados[j] = empleados[j + 1];
                }
                empleados[cantidadEmpleados - 1] = null; // Ajusta la ultima posicion del arreglo
                cantidadEmpleados--;
                System.out.println("Empleado eliminado!");
                System.out.println();
                return;
            }
        }
    }
    

    }

