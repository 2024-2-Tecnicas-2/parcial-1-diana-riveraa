package com.mycompany.parcial1;

public class Principal {

    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadInventario;

    public Producto(String nombre, String descripcion, double precio, int cantidadInventario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadInventario = cantidadInventario;
    }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getCantidadInventario() { return cantidadInventario; }
    public void setCantidadInventario(int cantidad) {
        this.cantidadInventario = cantidad;
    }
    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre + ", Precio: " + precio + ", Inventario: " + cantidadInventario);
    }
}