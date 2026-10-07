package com.inventario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventarioServiceTest {

    @Test
    void debeRegistrarProducto() {

        InventarioService inventario =
                new InventarioService();

        Proveedor proveedor =
                new Proveedor(
                        "P01",
                        "Proveedor",
                        "5555",
                        "correo@test.com"
                );

        Producto producto =
                new Producto(
                        "PROD01",
                        "Mouse",
                        100,
                        10,
                        5,
                        Categoria.ELECTRONICA,
                        proveedor
                );

        inventario.registrarProducto(producto);

        assertEquals(
                1,
                inventario.getProductos().size()
        );
    }

    @Test
    void debeBuscarProductoPorCodigo() {

        InventarioService inventario =
                new InventarioService();

        Proveedor proveedor =
                new Proveedor(
                        "P01",
                        "Proveedor",
                        "5555",
                        "correo@test.com"
                );

        Producto producto =
                new Producto(
                        "PROD01",
                        "Teclado",
                        250,
                        8,
                        3,
                        Categoria.ELECTRONICA,
                        proveedor
                );

        inventario.registrarProducto(producto);

        Producto resultado =
                inventario.buscarProducto("PROD01");

        assertNotNull(resultado);

        assertEquals(
                "Teclado",
                resultado.getNombre()
        );
    }

    @Test
    void debeCalcularValorInventario() {

        InventarioService inventario =
                new InventarioService();

        Proveedor proveedor =
                new Proveedor(
                        "P01",
                        "Proveedor",
                        "5555",
                        "correo@test.com"
                );

        Producto producto =
                new Producto(
                        "PROD01",
                        "Producto",
                        100,
                        5,
                        2,
                        Categoria.OTROS,
                        proveedor
                );

        inventario.registrarProducto(producto);

        assertEquals(
                500,
                inventario.calcularValorInventario()
        );
    }
}
