public class Usuario {
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String tipo;

    public Usuario(String nombre, String apellido, int edad, String telefono, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getTelefono() { return telefono; }
    public String getTipo() { return tipo; }
}
