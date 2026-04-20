package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;

public class FondoInversion extends Cuenta{
    //---------------ATRIBUTOS---------------
    private double interes;
    //---------------CONSTRUCTOR---------------
    public FondoInversion(double saldo, int numeroCuenta,Cliente nombre, double interes){
        super(5000, numeroCuenta, nombre);
        calcularInteres();
    }
    //---------------GETTERS Y SETTERS---------------
     public double getInteres() {
        return interes;
    }
    public void setInteres(double interes) {
        this.interes = interes;
    }
    //---------------METODOS----------------
    private void calcularInteres(){
        if (saldo>=100000) {
            interes=5;
        }else if (saldo>=50000) {
            interes=4;
        }else interes=2;
    }
    public void verDatos(){
        String s = "";
        s += "- FONDO INVERSION -"+"\nNºcuenta: " +numeroCuenta+"\n";
        s += "Titular: " +nombre+ "\n\t Dni:" +nombre.getDni() + "\n\t Nombre:"+ nombre.nombreCompleto() + "\n\t Domicilio:" + nombre.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "---------------MOVIMIENTOS---------------\n";
        mostrarMovimientos();
        System.out.println(s);
    }
    /*public void retirar(double cantidad) {
        if (cantidad < 500 || saldo - cantidad < 3000) {
            System.out.println("ERROR: no se puede retirar esa cantidad");
        } else {
            saldo -= cantidad;
            movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, cantidad, "R"));
            System.out.println("Se ha retirado correctamnete la cantidad de " + cantidad + " $ a la cuenta:"+ numeroCuenta);
        }
    }*/
    public void retiro(double cantidad) throws RetiroNoValidoException {
        if(cantidad <500) throw new RetiroNoValidoException("retiro minimo 500€");
        if(saldo-cantidad <3000) throw new RetiroNoValidoException("saldo insuficiente");
        if(cantidad<500) throw new RetiroNoValidoException("no se puede retirar menos de 500€");
        this.corfirmarRetiro(cantidad);
    }
    public void ingreso(double cantidad) throws IngresoNoValidoException {
        if(cantidad <500) throw new IngresoNoValidoException("ingreso minimo 500€");
        if(cantidad<0) throw new IngresoNoValidoException("ingreso negativo");
        this.corfirmarIngreso(cantidad);
    }
    /*public void ingresar(double cantidad) {
        if (cantidad < 500) {
            System.out.println("ERROR: ingreso mínimo 500€");
        } else {
            saldo += cantidad;
            movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, cantidad, "I"));
            System.out.println("Se ha ingresado correctamnete la cantidad de " + cantidad + " $ a la cuenta:"+ numeroCuenta);
        }
    }*/
}
