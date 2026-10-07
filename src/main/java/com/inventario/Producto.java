package com.inventario;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private int stockMinimo;
    private Categoria categoria;
    private Proveedor proveedor;

    public Producto(
            String codigo,
            String nombre,
            double precio,
            int stock,
            int stockMinimo,
            Categoria categoria,
            Proveedor proveedor) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean tieneStockBajo() {
        return stock <= stockMinimo;
    }

    @Override
    public String toString() {

        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categoria=" + categoria +
                '}';
    }
}