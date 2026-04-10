package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDate;

public class AppSucursalBancaria {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("1234A", "Juan", "Garcia", "C/ San Juan", "Mostoles", LocalDate.now());
        System.out.println(c1);
        System.out.println(c1.direccionCompleta());
        System.out.println(c1.nombreCompleto());
    }
}
