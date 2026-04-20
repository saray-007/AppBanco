package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;

public class CuentaVivienda extends Cuenta{
    private int interes;
    //---------------CONSTRUCTOR---------------
    public CuentaVivienda(double saldo, int numeroCuenta, Cliente nombre){
        super(1000, numeroCuenta, nombre);
        calcularIntereses();
    }
    //---------------METODOS---------------
    public void verDatos(){
        String s = "";
        s += "- CUENTA VIVIENDA -"+"\nNºcuenta: " +numeroCuenta+"\n";
        s += "Titular: " +nombre+ "\n\t Dni:" +nombre.getDni() + "\n\t Nombre:"+ nombre.nombreCompleto() + "\n\t Domicilio:" + nombre.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "---------------MOVIMIENTOS---------------\n";
        mostrarMovimientos();
        System.out.println(s);
    }
    private void calcularIntereses(){
        if(saldo>=100000) interes = 5;
        else if(saldo>=50000) interes= 4;
        else interes =2;
    }
    /*public void retirar(double cantidad) {
        if (cantidad > 500 || saldo - cantidad < 0) {
            System.out.println("ERROR: no se puede retirar esa cantidad");
        } else {
            saldo -= cantidad;
            movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, cantidad, "R"));
            System.out.println("Se ha retirado correctamnete la cantidad de " + cantidad + " $ a la cuenta:"+ numeroCuenta);
        }
    }*/
   public void retiro(double cantidad) throws RetiroNoValidoException {
        if(cantidad >500) throw new RetiroNoValidoException("no se puede retirar más de 500€");
        if(cantidad >saldo) throw new RetiroNoValidoException("saldo insuficiente");
        if(cantidad<0) throw new RetiroNoValidoException("retiro negativo");
        this.corfirmarRetiro(cantidad);
    }
    public void ingreso(double cantidad) throws IngresoNoValidoException {
        if(cantidad >10) throw new IngresoNoValidoException("no se puede ingreso más de 10€");
        if(cantidad<0) throw new IngresoNoValidoException("ingreso negativo");
        this.corfirmarIngreso(cantidad);
        this.calcularIntereses();
    }
    /*public void ingresar(double cantidad) {
        if (cantidad < 10) {
            System.out.println("ERROR: ingreso mínimo 10€");
        } else {
            saldo += cantidad;
            movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, cantidad, "I"));
            System.out.println("Se ha ingresado correctamnete la cantidad de " + cantidad + " $ a la cuenta:"+ numeroCuenta);
        }
    }*/
}
