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

}

public class Main {
    public static void main(String[] args) {
        // Menu
        Scanner entrada = new Scanner(System.in);
        Empleado[] empleados = new Empleado[1000];

        int cantidadEmpleados = 0;
        int opcion;

        do {
            System.out.println("Menú");
            System.out.println("1. Gestionar empleados");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Gestionar servicios");
            System.out.println("4. Reservas");
            System.out.println("5. Salir");
            System.out.println("Digite una opcion");
            opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1:
                    gestionarEmpleados(empleados, cantidadEmpleados, entrada);
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    break;
            }

        } while (opcion<1 || opcion>5);

    }

    public static void gestionarEmpleados(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {
        do {
            System.out.println("1. Añadir empleados");
            System.out.println("2. Listar empleados");
            System.out.println("3. Modificar empleados");
            System.out.println("4. Actualizar empleados");
            System.out.println("5. Salir");
            System.out.println("  Digite una opción");
            int opcionGestion = entrada.nextInt();
            System.out.println("");

            switch (opcionGestion) {
                case 1:
                    if (cantidadEmpleados < empleados.length) {
                        guardarEmpleados(empleados, cantidadEmpleados, entrada);
                        cantidadEmpleados++;
                    } else {

                    }
                    break;
                case 2:
                    listarEmpleados(empleados, cantidadEmpleados);
                    break;
                case 3:
                modificarEmpleado(empleados, cantidadEmpleados, entrada);
                    break;
                case 4:
                eliminarEmpleado(empleados, cantidadEmpleados, entrada);
                    break;
                case 5:
                    break;
                default:
                    break;
            }

        } while (true);
    }

    public static void guardarEmpleados(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {
        System.out.println("");
        System.out.print("Digite su cedula: ");
        int cedula = entrada.nextInt();

        System.out.print("Digite su nombre: ");
        String nombre = entrada.next();

        System.out.print("Digite su correo: ");
        String correo = entrada.next();

        System.out.print("Digite su cargo: ");
        String cargo = entrada.next();

        empleados[cantidadEmpleados] = new Empleado(cedula, nombre, correo, cargo);
        System.out.println(" Guardado con exito!");
        System.out.println("");
    }

    public static void listarEmpleados(Empleado[] empleados, int cantidadEmpleados) {
        System.out.println("");
        System.out.println("======Lista de empleados======");

        for (int i = 0; i < cantidadEmpleados; i++) {
            System.out.println("Nombre: " + empleados[i].getnombre());
            System.out.println("Cedula: " + empleados[i].getcedula());
            System.out.println("Email: " + empleados[i].getemail());
            System.out.println("Cargo: " + empleados[i].getcargo());
            System.out.println();

        }
    }

    public static void modificarEmpleado(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {
        System.out.println("");
        System.out.println("Digite la cedula: ");
        int Cedula = entrada.nextInt();
        for (int i = 0; i < cantidadEmpleados; i++) {
            // Verificar si existe
            if (empleados[i].getcedula() == Cedula) {
                System.out.print("Digite su cedula: ");
                int nuevaCedula = entrada.nextInt();

                System.out.print("Digite su nombre: ");
                String nuevoNombre = entrada.next();

                System.out.print("Digite su correo: ");
                String nuevoCorreo = entrada.next();

                System.out.print("Digite su cargo: ");
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

    public static void eliminarEmpleado(Empleado[] empleados, int cantidadEmpleados, Scanner entrada){
        System.out.print("Digite la cedula a eliminar: ");
        int nuevaCedula = entrada.nextInt();

        for(int i = 0; i < cantidadEmpleados; i++){
            if(empleados[i].getcedula() == nuevaCedula){
                for(int j = i; j < cantidadEmpleados - 1; j++){
                    empleados[j] = empleados[j + 1];
                }
                System.out.println("Empleado eliminado!");
                return;
            }
        }        

    }
}
