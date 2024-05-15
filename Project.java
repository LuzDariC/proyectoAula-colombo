import java.util.Scanner;

class Client {
    private int id;
    private String name;
    private String lastName;
    private String email;

    public Client(int id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Reservation {
    private String room;
    private String buffets;
    private String lounge;

    public Reservation(String room, String buffets, String lounge) {
        this.room = room;
        this.buffets = buffets;
        this.lounge = lounge;
    }

    public Reservation(int roomOption) {
    }
}

class Employee {
    private int id;
    private String name;
    private String email;
    private String position;

    public Employee(int id, String name, String email, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.position = position;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

public class Project {
    public static void main(String[] args) {
        clearScreen();
        // Menu
        Scanner input = new Scanner(System.in);
        Employee[] employees = new Employee[10];
        Client[] clients = new Client[5];
        Reservation[] reservations = new Reservation[10];
        int numberOfClients = 0;
        int numberOfEmployees = 0;
        int numberOfReservations = 0;

        do {
            System.out.println("---------------------------------");
            System.out.println("               MENU              ");
            System.out.println("---------------------------------");
            System.out.println("1. Manage employees");
            System.out.println("2. Manage clients");
            System.out.println("3. Manage Reservation");
            System.out.println("4. Exit");

            int option = 0;
            while (true) {
                System.out.print("Enter an option: ");
                if (input.hasNextInt()) {
                    option = input.nextInt();
                    if (option >= 1 && option <= 4) {
                        break;
                    } else {
                        System.out.println("Please enter a valid option (1-4).");
                    }
                } else {
                    System.out.println("Please enter an integer number.");
                    input.nextLine();

                }
            }
            switch (option) {
                case 1:
                    clearScreen();
                    manageEmployees(employees, numberOfEmployees, input);
                    break;

                case 2:
                    clearScreen();
                    manageClients(clients, numberOfClients, input);
                    break;

                case 3:
                    clearScreen();
                    manageReservation(reservations, clients, numberOfReservations, numberOfClients, input);

                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (true);

    }

    public static void clearScreen() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void manageEmployees(Employee[] employees, int numberOfEmployees, Scanner input) {
        do {
            System.out.println(" ----------------------------------");
            System.out.println("|        MANAGE EMPLOYEES          |");
            System.out.println(" ----------------------------------");
            System.out.println("1. Add employees");
            System.out.println("2. List employees");
            System.out.println("3. Modify employees");
            System.out.println("4. Delete employees");
            System.out.println("5. Exit");
            int managementOption = 0;

            while (true) {
                System.out.print("Enter an option: ");
                if (input.hasNextInt()) {
                    managementOption = input.nextInt();
                    if (managementOption >= 1 && managementOption <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a valid option (1-5).");
                    }
                } else {
                    System.out.println("Please enter an integer number.");
                    input.nextLine();

                }
            }
            switch (managementOption) {
                case 1:
                    clearScreen();
                    if (numberOfEmployees < employees.length) {
                        System.out.println("---------------------------------");
                        System.out.println("        ADD EMPLOYEES            ");
                        System.out.println("---------------------------------");
                        addEmployees(employees, numberOfEmployees, input);
                        numberOfEmployees++;
                    } else {
                    }
                    break;
                case 2:
                    clearScreen();
                    System.out.println("---------------------------------");
                    System.out.println("        LIST EMPLOYEES           ");
                    System.out.println("---------------------------------");
                    listEmployees(employees, numberOfEmployees);
                    break;
                case 3:
                    clearScreen();
                    System.out.println("---------------------------------");
                    System.out.println("        MODIFY EMPLOYEES         ");
                    System.out.println("---------------------------------");
                    modifyEmployee(employees, numberOfEmployees, input);
                    break;
                case 4:
                    clearScreen();
                    System.out.println("---------------------------------");
                    System.out.println("        DELETE EMPLOYEES         ");
                    System.out.println("---------------------------------");
                    deleteEmployee(employees, numberOfEmployees, input);
                    break;
                case 5:
                    clearScreen();
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while (true);
    }

    public static void addEmployees(Employee[] employees, int numberOfEmployees, Scanner input) {

        // ID
        int id;
        System.out.print("Enter your ID: ");
        do {

            while (!input.hasNextInt()) {
                System.out.println("Enter the ID correctly");
                input.next();
            }
            id = input.nextInt();
        } while ((String.valueOf(id).length() != 8) && (String.valueOf(id).length() != 10));

        // NAME
        System.out.print("Enter your name: ");

        while (!input.hasNext("[a-z-A-Z]+")) {
            System.out.println("Enter your name again: ");
            input.next();
        }
        String name = input.next();

        // EMAIL

        System.out.print("Enter your email: ");
        String email = input.next();
        while (!email.contains("@")) {
            System.out.print("Enter the email again: ");
            input.next();
        }

        // POSITION
        System.out.print
        ("Enter your position: ");

        while (!input.hasNext("[a-z-A-Z]+")) {
            System.out.println("Enter your position again: ");
            input.next();
        }
        String position = input.next();

        employees[numberOfEmployees] = new Employee(id, name, email, position);
        System.out.println(" Successfully saved!");
        System.out.println();
    }
    // LIST EMPLOYEES

    public static void listEmployees(Employee[] employees, int numberOfEmployees) {
        clearScreen();
        System.out.println();
        if (numberOfEmployees <= 0) {
            System.out.println("No employees");
            System.out.println();
        } else
            System.out.println("                              Employee list                                     ");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Name          ID                  Position                   Email                ");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < numberOfEmployees; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getName() + "\t\t" + employees[i].getId() + "\t\t"  + employees[i].getPosition() + "\t\t" + employees[i].getEmail());
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    // MODIFY EMPLOYEES
    public static void modifyEmployee(Employee[] employees, int numberOfEmployees, Scanner input) {
        int ID;

        do {
            System.out.print("Enter the ID to modify : ");
            while (!input.hasNextInt()) {
                System.out.print("Enter the ID correctly: ");
                input.nextInt();
            }
            ID = input.nextInt();
        } while ((String.valueOf(ID).length() != 8) && (String.valueOf(ID).length() != 10));

        for (int i = 0; i < numberOfEmployees; i++) {
            // Check if it exists
            if (employees[i].getId() == ID) {

                // ID
                int newId;
                System.out.print("Enter your new ID: ");
                do {

                    while (!input.hasNextInt()) {
                        System.out.println("Enter the ID correctly");
                        input.next();
                    }
                    newId = input.nextInt();
                } while ((String.valueOf(newId).length() != 8) && (String.valueOf(newId).length() != 10));

                // NAME

                System.out.print("Enter your new name: ");

                while (!input.hasNext("[a-z-A-Z]+")) {
                    System.out.println("Enter your name again: ");
                    input.next();
                }
                String newName = input.next();

                // EMAIL
                System.out.print("Enter your new email: ");
                String newEmail = input.next();
                while (!newEmail.contains("@")) {
                    System.out.println("Enter the email correctly");
                    input.next();

                }
                // POSITION
                System.out.print("Enter your new position: ");
                while (!input.hasNext("[a-z-A-Z]+")) {
                    System.out.println("Enter the position correctly");
                    input.next();
                }
                String newPosition = input.next();

                employees[i].setId(newId);
                employees[i].setName(newName);
                employees[i].setEmail(newEmail);
                employees[i].setPosition(newPosition);

                System.out.println("Successfully modified!");
                return;
            }
        }
    }

    public static void deleteEmployee(Employee[] employees, int numberOfEmployees, Scanner input) {
        System.out.print("Enter the ID to delete: ");
        int newId = input.nextInt();

        for (int i = 0; i < numberOfEmployees; i++) {
            if (employees[i].getId() == newId) {
                for (int j = i; j < numberOfEmployees - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[numberOfEmployees - 1] = null; // Adjust the last position of the array
                numberOfEmployees--;
                System.out.println("Employee deleted!");
                System.out.println();
                return;
            }
        }
    }

    public static void manageClients(Client[] clients, int numberOfClients, Scanner input) {
        do {
            System.out.println("-----------------------------");
            System.out.println("     MANAGE CLIENTS          ");
            System.out.println("-----------------------------");
            System.out.println("1. Add client");
            System.out.println("2. List clients");
            System.out.println("3. Modify clients");
            System.out.println("4. Delete clients");
            System.out.println("5. Exit");
            int managementOption = 0;
            while (true) {
                System.out.print("Enter an option: ");
                if (input.hasNextInt()) {
                    managementOption = input.nextInt();
                    if (managementOption >= 1 && managementOption <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a valid option (1-5).");
                    }
                } else {
                    System.out.println("Please enter an integer number.");
                    input.nextLine();
                }
            }

            switch (managementOption) {
                case 1:
                    clearScreen();
                    if (numberOfClients < clients.length) {
                        addClients(clients, numberOfClients, input);
                        numberOfClients++;
                    }
                    System.out.println("Cannot add more clients, the limit has been reached.");
                    break;
                case 2:
                    clearScreen();
                    listClients(clients, numberOfClients);
                    break;
                case 3
                :
                clearScreen();
                modifyClient(clients, numberOfClients, input);
                break;
            case 4:
                clearScreen();
                deleteClient(clients, numberOfClients, input);
                break;
            case 5:
                return;
            default:
                break;
        }

    } while (true);
}

public static void addClients(Client[] clients, int numberOfClients, Scanner input) {
    int id;
    do {
        System.out.print("Enter your ID: ");

        while (!input.hasNextInt()) {
            System.out.println("Enter the ID again");
            input.nextInt();
        }
        id = input.nextInt();

    } while ((String.valueOf(id).length() != 8) && (String.valueOf(id).length() != 10));

    // NAME
    System.out.print("Enter your name: ");

    while (!input.hasNext("[a-z-A-Z]+")) {
        System.out.println("Enter your name again: ");
        input.next();
    }
    String name = input.next();

    // LASTNAME
    System.out.print("Enter your lastname: ");

    while (!input.hasNext("[a-z-A-Z]+")) {
        System.out.println("Enter your last name again: ");
        input.next();
    }
    String lastName = input.next();

    // EMAIL

    System.out.print("Enter your email: ");
    String email = input.next();
    while (!email.contains("@")) {
        System.out.print("Enter the email again: ");
        input.next();
    }

    clients[numberOfClients] = new Client(id, name, lastName, email);
    System.out.println("Client added successfully!");
    System.out.println();

}

public static void listClients(Client[] clients, int numberOfClients) {
    System.out.println();
    System.out.println("================ Client List ================");

    if (numberOfClients <= 0) {
        System.out.println("No clients");
        System.out.println();
    }
    for (int i = 0; i < numberOfClients; i++) {
        if (clients[i] != null) {
            System.out.println("Name :" + clients[i].getName());
            System.out.println("Lastname :" + clients[i].getLastName());
            System.out.println("ID :" + clients[i].getId());
            System.out.println("Email :" + clients[i].getEmail());

            System.out.println();
        }
    }
}

public static void modifyClient(Client[] clients, int numberOfClients, Scanner input) {
    System.out.println();
    System.out.print("Enter the ID of the client you want to modify: ");
    int id = input.nextInt();

    for (int i = 0; i < numberOfClients; i++) {
        // Check if it exists
        if (clients[i].getId() == id) {

            int newId;
            do {
                System.out.print("Enter the new ID: ");
                while (!input.hasNextInt()) {
                    System.out.println("Enter the ID again");
                    input.next();
                }
                newId = input.nextInt();

                while ((String.valueOf(newId).length() != 8)
                        && (String.valueOf(newId).length() != 10)) {
                    System.out.println("It must be 8 - 10 digits");
                    newId = input.nextInt();
                }
            } while (!input.hasNextInt());

            // NAME
            System.out.println("Enter your new name");
            while (!input.hasNext("[a-z-A-Z]+")) {
                System.out.println("Enter your name correctly");
                input.next();
            }
            String newName = input.next();

            // LASTNAME
            System.out.print("Enter your new lastname: ");
            while (!input.hasNext("[a-z-A-Z]")) {
                System.out.println("Enter your last name correctly");

            }
            String newLastName = input.next();

            // EMAIL
            System.out.print("Enter your new email: ");
            String newEmail;

            do {
                newEmail = input.next();
                if (!newEmail.contains("@")) {
                    System.out.print("Enter the email again: ");
                }
            } while (!newEmail.contains("@"));

            clients[i].setId(newId);
            clients[i].setName(newName);
            clients[i].setLastName(newLastName);
            clients[i].setEmail(newEmail);
            System.out.println("Modified successfully!");
            return;
        }
    }
}
public static void deleteClient(Client[] clients, int numberOfClients, Scanner input) {
    System.out.print("Enter the ID to delete: ");
    int newId = input.nextInt();

    for (int i = 0; i < numberOfClients; i++) {
        if (clients[i].getId() == newId) {
            for (int j = i; j < numberOfClients - 1; j++) {
                clients[j] = clients[j + 1];
            }
            clients[numberOfClients - 1] = null;
            numberOfClients--;
            System.out.println("Client deleted!");
            System.out.println();
            return;
        }
    }

}

private static void manageReservations(Reservation[] reservations, Client[] clients, int numberOfReservations,int numberOfClients, Scanner input) {
    System.out.println("Verify that the client is registered");
    System.out.println();
    System.out.print("Enter your ID number: ");
    int id = input.nextInt();
    Client clientReservation = null;

    for (int i = 0; i < numberOfClients; i++) {
        if (clients[i].getId() == id) {
            clientReservation = clients[i];
            break;
        }
    }
    if (clientReservation == null) {
        System.out.println(
                "The client with the entered ID is not registered, register before making a reservation");
        return;
    }

    do {
        System.out.println("------------------------");
        System.out.println("    MANAGE RESERVATION  ");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("1. Add reservation");
        System.out.println("2. List reservation");
        System.out.println("3. Modify reservation");
        System.out.println("4. Delete reservation");
        System.out.println("5. Exit");
        System.out.println(" Enter an option");
        int managementOption = input.nextInt();
        System.out.println();

        switch (managementOption) {
            case 1:
                if (numberOfReservations < reservations.length) {
                    addReservation(reservations, numberOfReservations, input);
                    numberOfReservations++;
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

public static void addReservation(Reservation[] reservations, int numberOfReservations, Scanner input) {
    System.out.println();
    clearScreen();
    do {
        System.out.println("------------------------");
        System.out.println("     RESERVATION SERVICES  ");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("1. Room reservation");
        System.out.println("2. Buffet reservation");
        System.out.println("3. Event room reservation");
        System.out.println("4. Exit");
        System.out.println();
        System.out.println("Choose an option");
        int reservationOption = input.nextInt();

        switch (reservationOption) {
            case 1:
                clearScreen();
                rooms(reservations, numberOfReservations, null, numberOfReservations, reservationOption, input);
                break;

            case 2:
                clearScreen();
                buffets(input);
                break;

            case 3:
                clearScreen();
                eventRoom(input);
                break;
            case 4:
                return;
        }

    } while (true);

}

public static void rooms(Reservation[] reservations, int numberOfReservations, Client[] clients,
        int numberOfClients, int reservationOption, Scanner input) {

    clearScreen();
    String[] options = { "Single Room", "Double Room", "Family Room" };

    do {
        System.out.println("-----------------------");
        System.out.println("     ROOMS      ");
        System.out.println("-----------------------");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println((options.length + 1) + ". Exit");

        System.out.print("Choose an option: ");
        reservationOption = input.nextInt();
        System.out.println();

        if (reservationOption >= 1 && reservationOption <= options.length) {
            System.out.println("          INVOICE           ");
            System.out.println("____________________________");
            System.out.println();
            System.out.println("Service reserved: " + options[reservationOption - 1]);

            System.out.println();
        } else if (reservationOption == options.length + 1) {
            System.out.println("Exiting the program...");
        } else {
            System.out.println("Invalid option. Try again.");
        }
        break;

    } while (reservationOption != options.length + 1);
}

public static void buffets(Scanner input) {
    clearScreen();
    do {
        System.out.println("-------------------------------");
        System.out.println("        BUFFET       ");
        System.out.println("-------------------------------");
        System.out.println("1. Table service buffet");
        System.out.println("2. Self-service buffet");
        System.out.println("3. Exit");
        System.out.println();
        int salonOption = input.nextInt();

        switch (salonOption) {
            case 1:

                break;

            default:
                break;
        }

    } while (true);

}

public static void eventRoom(Scanner input) {
    do {
        clearScreen();
        System.out.println("------------------------------");
        System.out.println("       EVENT ROOM       ");
        System.out.println("------------------------------");
        System.out.println("1. For work conferences");
        System.out.println("2. Social event room");
        int salonOption = input.nextInt();

        switch (salonOption) {
            case 1:
                break;
        }

    } while (true);

}

public static void listReservations(Reservation[] reservations, int numberOfReservations) {
    System.out.println("-------------------------------");
    System.out.println("          RESERVATION LIST     ");
    System.out.println("-------------------------------");
    if (numberOfReservations <= 0) {

        System.out.println("No reservations");
        System.out.println();

    }
    for (int i = 0; i < numberOfReservations; i++) {
        if (reservations[i] != null) {
            System.out.println();

        }
    }
}
}
