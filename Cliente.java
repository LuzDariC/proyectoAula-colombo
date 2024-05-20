import java.util.Scanner;

class Cliente {
    private int cedula;
    private String nombre;
    private String apellido;
    private String email;

    public Cliente(int cedula, String nombre, String apellido, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
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

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

     public static void AñadirClientes(Cliente[] clientes, int cantidadClientes, Scanner entrada) {
        int cedula;
        do {
            System.out.print("Digite su cedula: ");

            while (!entrada.hasNextInt()) {
                System.out.println("Digite la cedula nuevamente");
                entrada.nextInt();
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

        // APELLIDO
        System.out.print("Digite su apellido: ");

        while (!entrada.hasNext("[a-z-A-Z]+")) {
            System.out.println("Digite nuevamente su apellido: ");
            entrada.next();
        }
        String apellido = entrada.next();

        // EMAIL

        System.out.print("Digite su email: ");
        String email = entrada.next();
        while (!email.contains("@")) {
            System.out.print("Digite el correo nuevamente: ");
            entrada.next();
        }

        clientes[cantidadClientes] = new Cliente(cedula, nombre, apellido, email);
        cantidadClientes++;
        System.out.println("¡Cliente añadido con exito!");
        System.out.println();

    }

    public static void listarClientes(Cliente[] clientes, int cantidadClientes) {
        System.out.println();
        System.out.println("================ Lista de clientes ================");

        if (cantidadClientes <= 0) {
            System.out.println("No hay clientes");
            System.out.println();
        }
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i] != null) {
                System.out.println("Nombre :" + clientes[i].getnombre());
                System.out.println("Apellido :" + clientes[i].getapellido());
                System.out.println("Cedula :" + clientes[i].getcedula());
                System.out.println("Email :" + clientes[i].getemail());

                System.out.println();
            }
        }
    }
    public static void modificarClientes(Cliente[] clientes, int cantidadClientes, Scanner entrada) {
        System.out.println();
    
        int Cedula;
        do {
            System.out.print("Digite la cedula que desea modificar: ");

            while (!entrada.hasNextInt()) {
                System.out.println("Digite la Cedula nuevamente");
                entrada.nextInt();
            }
            Cedula = entrada.nextInt();

        } while ((String.valueOf(Cedula).length() != 8) && (String.valueOf(Cedula).length() != 10));

        for (int i = 0; i < cantidadClientes; i++) {
            // Verificar si existe
            if (clientes[i].getcedula() == Cedula) {

                int nuevoCedula;
                do {
                    System.out.print("Digite la nueva cedula: ");
                    while (!entrada.hasNextInt()) {
                        System.out.println("Digite la cedula nuevamente");
                        entrada.nextInt();
                    }
                    nuevoCedula = entrada.nextInt();

                    while ((String.valueOf(nuevoCedula).length() != 8)
                            && (String.valueOf(nuevoCedula).length() != 10)) {
                        System.out.println("Debe ser de 8 - 10 digitos");
                        nuevoCedula = entrada.nextInt();
                    }
                } while (!entrada.hasNextInt());

                // NOMBRE
                System.out.println("Digite su nuevo nombre");
                while (!entrada.hasNext("[a-z-A-Z]+")) {
                    System.out.println("Digite el nombre de forma correcta");
                    entrada.next();
                }
                String nuevoNombre = entrada.next();

                // APELLIDO
                System.out.print("Digite el nuevo apellido: ");
                while (!entrada.hasNext("[a-z-A-Z]")) {
                    System.out.println("Digite el apellido de forma correcta");

                }
                String nuevoApellido = entrada.next();

                // EMAIL
                System.out.print("Digite su nuevo email: ");
                String nuevoEmail;

                do {
                    nuevoEmail = entrada.next();
                    if (!nuevoEmail.contains("@")) {
                        System.out.print("Digite el correo nuevamente: ");
                    }
                } while (!nuevoEmail.contains("@"));

                clientes[i].setcedula(nuevoCedula);
                clientes[i].setnombre(nuevoNombre);
                clientes[i].setapellido(nuevoApellido);
                clientes[i].setemail(nuevoEmail);
                System.out.println("¡Modificado con exito!");
                return;
            }
        }
    }
    public static void eliminarClientes(Cliente[] clientes, int cantidadClientes, Scanner entrada) {
        System.out.println();
        
        int nuevaCedula;
        do {
            System.out.print("Digite la cedula a eliminar: ");

            while (!entrada.hasNextInt()) {
                System.out.println("Digite la cedula nuevamente, de manera correcta: ");
                entrada.nextInt();
            }
            nuevaCedula = entrada.nextInt();

        } while ((String.valueOf(nuevaCedula).length() != 8) && (String.valueOf(nuevaCedula).length() != 10));

        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getcedula() == nuevaCedula) {
                System.out.println("Se encontró al cliente: "+ clientes[i].getnombre());
                for (int j = i; j < cantidadClientes - 1; j++) {
                    clientes[j] = clientes[j + 1];
                }
                clientes[cantidadClientes - 1] = null;
                cantidadClientes--;
                System.out.println("Cliente eliminado!");
                System.out.println();
                return;
            }
        }

    }

}