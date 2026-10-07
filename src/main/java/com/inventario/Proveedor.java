package com.inventario;

public class Proveedor {
    private String codigo;
    private String nombre;
    private String telefono;
    private String correo;

    public Proveedor(String codigo, String nombre, String telefono, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
