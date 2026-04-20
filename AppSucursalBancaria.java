package Herencia.Excepciones.SucursalBancaria;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppSucursalBancaria {

    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Cuenta> cuentas = new ArrayList<>();
    //cuenta seleccionada para operar con ella
    private static Cuenta cuentaActiva = null;
    private static int contadorCuenta = 1;

    public static void main(String[] args) {

        try {
            int opcion = 0;
            while (opcion != 4) {
                menuPrincipal();
                opcion = Integer.parseInt(entrada.nextLine()); 
                switch (opcion) {
                    case 1:
                        crearCliente();
                        break;
                    case 2:
                        crearCuenta();
                        break;
                    case 3:
                        seleccionarCuenta();
                        break;
                    case 4:
                        System.out.println("Fin del programa");
                        break;
                    default:
                        System.out.println("Opción no válida, selecciona una opción entre 1 y 4");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        entrada.close();
    }

    static void crearCliente() {

        System.out.println("Dime el dni del cliente");
        //COMPROBAR QUE EL CLIENTE NO EXISTE
        String dni = validarDni();
        System.out.println("Dime el nombre del cliente");
        String nombre = entrada.nextLine();
        System.out.println("Dime los apellidos del cliente");
        String apellidos = entrada.nextLine();
        System.out.println("Dime la dirección del cliente");
        String direccion = entrada.nextLine();
        System.out.println("Dime la ciudad de residencia del cliente");
        String ciudad = entrada.nextLine();
        System.out.println("Dime la fecha de nacimiento del cliente AAAA-MM-DD");
        LocalDate fecha = validarFecha();

        clientes.add(new Cliente(dni,nombre, apellidos, direccion, ciudad, fecha));
        System.out.println("El cliente de nombre "+nombre+" "+apellidos+" se ha creado correctamente");
    }

    static void crearCuenta() {

        // si no hay clientes, no se puede crear cuenta
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes en la sucursal, primero debes crear uno");
            return;
        }
        //obtener el cliente
        Cliente cliente = validarCliente();
        //obtener cuenta
        Cuenta cuenta = validarCuenta(cliente);
        //añadimos la cuenta al array de cuentas
        cuentas.add(cuenta);
        System.out.println("La cuenta a nombre de "+cliente.nombreCompleto()+" se ha creado correctamente");
    }
    static String validarDni(){
        while(true){
            try{ 
                String s = entrada.nextLine();
                //recorremos el array de clientes
                for(Cliente c : clientes){
                    if (c.getDni().equals(s)) {
                        throw new ClienteExisteExcepciones(c);
                    }
                }
                return s;
            }catch(ClienteExisteExcepciones e){
                System.out.println(e);
            }
        }
    }
    static LocalDate validarFecha(){
        while (true) {
            try{
                return LocalDate.parse(entrada.nextLine());
            } catch(Exception e){
                System.out.println("Fecha erronea: debe meter una fecha valida(AAAA-MM-DDa )");
                
            }   
        }
    }
    static Cliente validarCliente() {
        String dni;
        while(true){
            System.out.println("Dime el dni del cliente que quiere abrir una cuenta");
            //mostrar la lista de los clientes
            for (Cliente c : clientes) {
                System.out.println(c.clienteCompleto());
            }
            dni = entrada.nextLine();
            for (Cliente c : clientes) {
                if (c.getDni().equals(dni)) {
                    return c;
                }
            }
        }
    }        

        
    static Cuenta validarCuenta(Cliente cliente){
        try {
            int opcion;
            while(true){
                 menuTipoCuenta();
                 opcion = Integer.parseInt(entrada.nextLine());
                 switch (opcion) {
                    case 1:
                        return new CuentaCorriente(contadorCuenta++, opcion, cliente);
                    case 2:
                        return new CuentaVivienda(contadorCuenta++, opcion, cliente);
                    case 3:
                        return new FondoInversion(contadorCuenta++, opcion, cliente, opcion);
                 }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return cuentaActiva;
    }

    static void seleccionarCuenta() {

        // si no hay cuentas, mostramos mensaje
        if (cuentas.isEmpty()) {
            System.out.println("No hay ninguna cuenta en la sucursal, primero debes crear alguna");
            return;
        }

        // seleccionamos una cuenta
        int numCuenta;
        do {
            System.out.println("Selecciona un número de cuenta");
            for (Cuenta c : cuentas) {
                System.out.println(c.toString());
            }
            numCuenta = Integer.parseInt(entrada.nextLine());  
        } while (!validarCuenta(numCuenta));

        // mostramos el menú de la cuenta
        seleccionarOpcionCuenta();
    }

    static boolean validarCuenta(int numCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() == numCuenta) {
                cuentaActiva = c;
                return true;
            }
        }
        return false;
    }

    static void seleccionarOpcionCuenta() {

        try {
            int opcionCuenta = 0;
            while (opcionCuenta != 4) {
                menuCuenta();
                opcionCuenta = Integer.parseInt(entrada.nextLine());  
                switch (opcionCuenta) {
                    case 1:
                        ingresar();
                        break;
                    case 2:
                        retirar();
                        break;
                    case 3:
                        cuentaActiva.verDatos();
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    static void ingresar() {
        System.out.println("Indica la cantidad a ingresar");
        int cantidad = Integer.parseInt(entrada.nextLine());        
        try {
            cuentaActiva.ingreso(cantidad);
        }catch (NumberFormatException e) { 
            System.out.println("Indique una cantidad númerica válida");
        }catch (IngresoNoValidoException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    static void retirar() {
        System.out.println("Indica la cantidad a retirar");
        int cantidad = Integer.parseInt(entrada.nextLine());          
        try {
            cuentaActiva.retiro(cantidad);
        }catch (NumberFormatException e) { 
            System.out.println("Indique una cantidad númerica válida"); 
        }catch (RetiroNoValidoException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    static void menuPrincipal() {

        String s = """

                MENU PRINCIPAL
                1 - Crear Cliente
                2 - Crear Cuenta
                3 - Mantenimiento de cuenta
                4 - Salir

                """;
        System.out.println(s);
    }

    static void menuCuenta() {

        String s = """

                MENU CUENTA
                1 - Ingresar
                2 - Retirar
                3 - Ver datos cuenta
                4 - Volver al menú principal

                """;
        System.out.println(s);
    }
    static void menuTipoCuenta() {

        String s = """

                ELIJA EL TIPO CUENTA QUE QUIERE CREAR
                1 - Cuenta Corriente
                2 - Cuenta Vivienda
                3 - Fondo Inversión

                """;
        System.out.println(s);
    }
}