package Herencia.Excepciones.SucursalBancaria;
//COMENTARIO AÑADIDO DESDE GITHUB
import java.time.LocalDate;

public class Cliente {
    //---------------ATRIBUTOS---------------
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String localidad;
    private LocalDate fechaDeNacimiento;
    //---------------CONSTRUCTORES---------------
    public Cliente(String dni){
        this.dni=dni;
    }
    public Cliente(String dni, String nombre, String apellidos, String direccion, String localidad, LocalDate fechaDeNacimiento){
        this.dni=dni;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.direccion=direccion;
        this.localidad=localidad;
        this.fechaDeNacimiento=fechaDeNacimiento;
    }
    //---------------GETTERS Y SETTERS---------------
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    //---------------METODOS---------------
    public String direccionCompleta(){
        return "La direccion completa es: "+direccion+" " +localidad;
    }
    public String nombreCompleto(){
        return "El nombre completo es: "+nombre+" "+apellidos;
    }
    @Override
    public String toString() {
        return "---------------CLIENTE---------------"
            +"\n\t-Dni: "+dni+"\n\t-Nombre: " +nombre+ "\n\t-Apellidos: " +apellidos+ "\n\t-Direccion: " +direccion+ "\n\t-Localidad: " +localidad+ "\n\t-FechaDeNacimiento: " +fechaDeNacimiento;
    }
}
