package com.inventario;

public class ValidacionService {
    public boolean validarProducto(Producto producto) {

        if (producto == null) {
            System.out.println("Producto inválido");
            return false;
        }

        if (producto.getCodigo() == null) {
            System.out.println("Código inválido");
            return false;
        }

        if (producto.getNombre() == null) {
            System.out.println("Nombre inválido");
            return false;
        }

        if (producto.getPrecio() < 0) {
            System.out.println("Precio inválido");
            return false;
        }

        if (producto.getStock() < 0) {
            System.out.println("Stock inválido");
            return false;
        }

        return true;
    }

    public boolean validarStock(int stock) {

        if (stock < 0) {
            System.out.println("Stock inválido");
            return false;
        }

        return true;
    }
}
