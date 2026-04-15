package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppSucursalBancaria {

    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Cuenta> cuentas = new ArrayList<>();
    private static Cuenta cuentaActiva = null;
    private static int contadorCuenta = 1;

    public static void main(String[] args) {

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
                    System.out.println("Opción no válida");
            }
        }
        entrada.close();
    }

    static void crearCliente() {
        System.out.println("Dni:");
        String dni = entrada.nextLine();

        System.out.println("Nombre:");
        String nombre = entrada.nextLine();

        System.out.println("Apellidos:");
        String apellidos = entrada.nextLine();

        System.out.println("Dirección:");
        String direccion = entrada.nextLine();

        System.out.println("Localidad:");
        String Localidad = entrada.nextLine();

        System.out.println("Fecha nacimiento (AAAA-MM-DD):");
        String fecha = entrada.nextLine();

        clientes.add(new Cliente(dni,nombre, apellidos, direccion, Localidad, LocalDate.parse(fecha)));

        System.out.println("Cliente creado correctamente"+"\n");
    }

    static void crearCuenta() {

        if (clientes.isEmpty()) {
            System.out.println("\nPrimero crea un cliente");
            return;
        }

        Cliente cliente;
        do {
            System.out.println("Selecciona cliente: ");
            int i=0;
            for (Cliente c : clientes) {
                System.out.println(i+".-"+c.getNombre());
                i++;
            }

            String nombre = entrada.nextLine();
            cliente = validarCliente(nombre);

        } while (cliente == null);

        System.out.println("""
                    ----------Tipo cuenta---------- 
                    1- Cuenta Corriente 
                    2- Cuenta Vivienda 
                    3- Fondo Inversion
                    """);
        int tipo = Integer.parseInt(entrada.nextLine());

        switch (tipo) {
            case 1:
                cuentas.add(new CuentaCorriente(contadorCuenta++, tipo, cliente));
                break;

            case 2:
                cuentas.add(new CuentaVivienda(contadorCuenta++, tipo, cliente));
                break;

            case 3:
                System.out.println("Interés:");
                double interes = Double.parseDouble(entrada.nextLine());
                cuentas.add(new FondoInversion(contadorCuenta++, tipo, cliente, interes));
                break;

            default:
                System.out.println("Tipo no válido");
        }

        System.out.println("Cuenta creada correctamente"+"\n");
    }

    static Cliente validarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    static void seleccionarCuenta() {

        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas");
            return;
        }

        int numCuenta;
        do {
            System.out.println("Selecciona cuenta:");
            for (Cuenta c : cuentas) {
                System.out.println(c);
            }

            numCuenta = Integer.parseInt(entrada.nextLine());

        } while (!validarCuenta(numCuenta));

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

        int opcion = 0;
        while (opcion != 4) {

            menuCuenta();
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
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
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    static void ingresar() {
        System.out.println("Cantidad:");
        double cantidad = Double.parseDouble(entrada.nextLine());
        cuentaActiva.ingresar(cantidad);
    }

    static void retirar() {
        System.out.println("Cantidad:");
        double cantidad = Double.parseDouble(entrada.nextLine());
        cuentaActiva.retirar(cantidad);
    }

    static void menuPrincipal() {
        System.out.println("""
                ----------MENU PRINCIPAL----------
                1 - Crear Cliente
                2 - Crear Cuenta
                3 - Mantenimiento cuenta
                4 - Salir
                """);
    }

    static void menuCuenta() {
        System.out.println("""
                ----------MENU CUENTA----------
                1 - Ingresar
                2 - Retirar
                3 - Ver datos
                4 - Volver
                """);
    }
}