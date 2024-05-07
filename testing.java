import java.util.Scanner;
class Cliente{
    private int cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String pais;
    
    public Cliente (int cedula, String nombre, String apellido, String email, String celular, String pais){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.telefono=celular;
        this.pais=pais;
    }
    public int getcedula(){
     return cedula;
    }
    public void setcedula(int cedula){
        this.cedula=cedula;
    }
    public String getnombre() {
        return nombre;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    public String getapellido(){
        return apellido;
    }
    public void setapellido( String apellido){
        this.apellido=apellido;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String gettelefono() {
        return telefono;
    }
    public void settelefono(String telefono) {
        this.telefono = telefono;
    }   
    public String getpais() {
        return pais;
    }
    public void setpais(String pais) {
        this.pais = pais;
    }


}


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

public class testing {
    public static void main(String[] args) {
        // Menu
        Scanner entrada = new Scanner(System.in);
        Empleado[] empleados = new Empleado[1000];
        Cliente[]clientes= new Cliente[5000];
        int cantidadClientes= 0; 
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
                     gestionarClientes(clientes, cantidadClientes, entrada);
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                System.out.println("Opcion invalida");
                    break;
            }

        } while (true);
           

    }

    public static void gestionarEmpleados(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {
        do {
            System.out.println("1. Añadir empleados");
            System.out.println("2. Listar empleados");
            System.out.println("3. Modificar empleados");
            System.out.println("4. Eliminar empleados");
            System.out.println("5. Salir");
            System.out.println("  Digite una opción"); 
            int opcionGestion = entrada.nextInt();
            System.out.println();
            if (opcionGestion > 5){
                System.out.println("Please enter a valid option and try again.");
            }
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
    

        int cedula = 0;
        boolean EsNumero = false;

        do {
            System.out.println("Enter your ID number");
            String input = entrada.next();

            try {
                cedula = Integer.parseInt (input);
                EsNumero = true;
            } catch (NumberFormatException e){
                System.out.println("ERROR, please enter only numbers");
            } 
            if (EsNumero && cedula > 0){
                break;
            }
        } while (true);


        String nombre = "";
         do {
            System.out.println("Enter your name");
            nombre = entrada.next();

            if (nombre.matches("[a-zA-Z]+")){
                break;
         } else {
            System.out.println("ERROR, please enter only letters for the name");
         }
         }while (true);
            
         
         int numero = 0;
         boolean SiEsNumero = false;
         
         do {
             System.out.println("Enter your phone number");
             String input = entrada.next();
         
             try {
                 numero = Integer.parseInt(input);
                 SiEsNumero = true;
             } catch (NumberFormatException e) {
                 System.out.println("ERROR, please enter only numbers");
             }
         } while (!SiEsNumero || numero <= 0);


        System.out.print("Digite su correo: ");
        String correo = "";

        do {
            correo = entrada.next();
            if (correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
                break;
            } else {
                System.out.println("ERROR, please enter a valid email address");
            }
          
        }while (true);


        System.out.print("Digite su cargo: ");
        String cargo = "";
        do{
            cargo = entrada.next();
            if (cargo.matches ("[a-zA-Z]+")){
            break;
            } else {
                System.out.println("ERROR, please enter only letters for the position");
            }

        }while(true);

        empleados[cantidadEmpleados] = new Empleado(cedula, nombre, correo, cargo);
        System.out.println(" Guardado con exito!");
        System.out.println("");
    
    }

    public static void listarEmpleados(Empleado[] empleados, int cantidadEmpleados) {
        System.out.println("");
        System.out.println("======Lista de empleados======");
        if (cantidadEmpleados<=0) {
            
            System.out.println("No hay empleados");
            System.out.println();
            
        }

        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i]!=null) {
                System.out.println("Nombre: " + empleados[i].getnombre());
                System.out.println("Cedula: " + empleados[i].getcedula());
                System.out.println("Email: " + empleados[i].getemail());
                System.out.println("Cargo: " + empleados[i].getcargo());
                System.out.println(); 
                
            }
            
            

        }
    }

    public static void modificarEmpleado(Empleado[] empleados, int cantidadEmpleados, Scanner entrada) {
        System.out.println();
        
        String CedulaModificar;
        do {
            System.out.println("Digite la cedula a modificar: ");
            CedulaModificar = entrada.next();
            if (CedulaModificar.matches("[0-9]+")){
                break;
            } else {
                System.out.println("Por favor ingrese solo numeros");
            }
        } while (true);
    
        int CedulaModificada = Integer.parseInt(CedulaModificar);
    
        for (int i = 0; i < cantidadEmpleados; i++) {
            int nuevaCedula = 0;
            // Verificar si existe
            if (empleados[i].getcedula() == CedulaModificada) {
                do {
                    System.out.print("Digite la nueva cedula: ");
                    String nuevaCedulaStr = entrada.next();
                    if(nuevaCedulaStr.matches("[0-9]+")) {
                        nuevaCedula = Integer.parseInt(nuevaCedulaStr);
                        break;
                    } else {
                        System.out.println("Por favor ingrese solo numeros");
                    }
                } while (true);
    
                empleados [i].setcedula (nuevaCedula);
                System.out.println("Cedula modificada exitosamente. ");
                
                String nuevoNombre = "";
                do {
                    System.out.print("Digite su nombre: ");
                    nuevoNombre = entrada.next();
                    if (nuevoNombre.matches("[a-zA-Z]+")){
                        break;
                    } else {
                        System.out.println("Por favor ingrese solo letras para el nombre.");
                    }
                } while (true);
               
                String nuevoCorreo = "";
                System.out.print("Digite su correo: ");
                do {
                    nuevoCorreo = entrada.next();
                    if (nuevoCorreo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                        break;
                    } else {
                        System.out.println("Por favor ingrese caracteres validos para el correo");
                    }
                } while (true);
    
                System.out.print("Digite su cargo: ");
                String nuevoCargo = "";
                do {
                    nuevoCargo = entrada.next();
                    if (nuevoCargo.matches("[a-zA-Z]+"))  {
                        break;
                    } else {
                        System.out.println("Por favor ingrese solo letras para el cargo.");
                    }
                } while (true);
    
                empleados[i].setnombre(nuevoNombre);
                empleados[i].setemail(nuevoCorreo);
                empleados[i].setcargo(nuevoCargo);
    
                System.out.println("Empleado modificado con exito!");
                return;
            }
        }
    
        System.out.println("No se encontró ningún empleado con esa cédula.");
    }
    

    

    public static void eliminarEmpleado(Empleado[] empleados, int cantidadEmpleados, Scanner entrada){
        String CedulaBorrar = "";
        do {
            System.out.println("Digite la cedula a eliminar");
            CedulaBorrar = entrada.next();
            if (CedulaBorrar.matches ("[0-9]+")){
                break;
            } else {
                System.out.println("ERROR, por favor ingrese solo numeros");
            }
        } while (true);

        int CedulaBorrar2 = Integer.parseInt(CedulaBorrar);


        for(int i = 0; i < cantidadEmpleados; i++){
            if(empleados[i].getcedula() == CedulaBorrar2){
                for(int j = i; j < cantidadEmpleados - 1; j++){
                    empleados[j] = empleados[j + 1];
                }
                empleados[cantidadEmpleados - 1] = null; // Ajusta la última posicion del arreglo
                cantidadEmpleados--;
                System.out.println("Empleado eliminado!");
                System.out.println();
                return;
            }
        }        

    }
  
    public static void gestionarClientes(Cliente[]clientes, int cantidadClientes, Scanner entrada){
    do {
        System.out.println("1. Añadir cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Modificar clientes");
        System.out.println("4. Eliminar clientes");
        System.out.println("5. Salir");
        System.out.println("  Digite una opción");
        int opcionGestion = entrada.nextInt();
        System.out.println("");

        if (opcionGestion > 5){
            System.out.println("Por favor ingrese una opcion valida");
        }

        switch (opcionGestion) {
            case 1:
            guardarClientes(clientes, cantidadClientes, entrada);
               
                break;
            case 2:
            listarClientes(clientes, cantidadClientes);
                break;
            case 3:
            modificarClientes(clientes, cantidadClientes, entrada);
                break;
            case 4:
            eliminarClientes(clientes, cantidadClientes, entrada);
                break;
            case 5:
                return;
            default:

                break;
        }

    } while (true);
  }  

    public static void guardarClientes(Cliente[]clientes, int cantidadClientes, Scanner entrada){
    System.out.println();
    int cedula = 0;
        boolean EsNumero = false;

        do {
            System.out.println("Enter your ID number");
            String input = entrada.next();

            try {
                cedula = Integer.parseInt (input);
                EsNumero = true;
            } catch (NumberFormatException e){
                System.out.println("ERROR, please enter only numbers");
            }

           
        } while (!EsNumero || cedula <= 0);
    System.out.print("Digite su nombre: ");
    String nombre = entrada.next();

    System.out.print("Digite su apellido: ");
    String apellido= entrada.next();

    System.out.print("Digite su email: ");
    String email= entrada.next();

    System.out.print("Digite su numero celular: ");
    String celular= entrada.next();

    System.out.print("Digite su pais de residencia: ");
    String pais = entrada.next();

    clientes [cantidadClientes] = new Cliente(cedula, nombre, apellido, email, celular, pais);
    System.out.println("¡Cliente añadido con exito!");
    System.out.println();



  }

public static void listarClientes (Cliente[]clientes, int cantidadClientes){
  System.out.println();
  System.out.println("================ Lista de clientes ================");

if (cantidadClientes<=0) {
    System.out.println("No hay clientes");
    System.out.println();
}
for (int i=0; i < cantidadClientes; i++){
    if (clientes[i]!=null) {
        System.out.println("Nombre :" + clientes[i].getnombre());
    System.out.println("Apellido :" + clientes[i].getapellido());
    System.out.println("Cedula :" + clientes[i].getcedula());
    System.out.println("Email :" + clientes[i].getemail());
    System.out.println("Telefono :" + clientes[i].gettelefono());
    System.out.println("Pais de residencia :" + clientes[i].getpais());
    System.out.println();
        
    }
    
}

}

    public static void modificarClientes (Cliente[] clientes, int cantidadClientes, Scanner entrada){
 System.out.println();
 System.out.print("Digite la cedula del cliente que desea modificar: ");
 int Cedula = entrada.nextInt();

 for (int i=0; i< cantidadClientes; i++){
    //Verificar si existe 
    if (clientes[i].getcedula()==Cedula){
        System.out.print("Digite la nueva cedula: ");
        int nuevoCedula= entrada.nextInt();
    
        System.out.print("Digite el nuevo nombre: ");
        String nuevoNombre = entrada.next();
    
        System.out.print("Digite el nuevo apellido: ");
        String nuevoApellido= entrada.next();
    
        System.out.print("Digite su nuevo email: ");
        String nuevoEmail= entrada.next();
    
        System.out.print("Digite su nuevo numero celular: ");
        String nuevoCelular= entrada.nextLine();
    
        System.out.print("Digite su nuevo pais de residencia");
        String nuevoPais = entrada.next();

         clientes[i].setcedula(nuevoCedula);
         clientes[i].setnombre(nuevoNombre);
         clientes[i].setapellido(nuevoApellido);
         clientes[i].setemail(nuevoEmail);
         clientes[i].settelefono(nuevoCelular);
         clientes[i].setpais(nuevoPais);
         System.out.println("¡Modificado con exito!");
         return;


    }
 }
}

    public static void eliminarClientes(Cliente[] clientes, int cantidadClientes, Scanner entrada){
        System.out.println("Digite la cedula a eliminar: ");
        int nuevaCedula = entrada.nextInt();
        
        for(int i = 0; i < cantidadClientes; i++){
            if(clientes[i].getcedula() == nuevaCedula){
                for(int j = i; j < cantidadClientes - 1; j++){
                    clientes[j] = clientes[j + 1];
                }
                clientes[cantidadClientes-1]=null;
                cantidadClientes--;
                System.out.println("Cliente eliminado!");
                System.out.println();
                return;
            }
        } 
       
        
        

}
    
}