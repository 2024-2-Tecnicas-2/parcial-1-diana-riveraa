package com.mycompany.parcial1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaTienda {

    static class Producto {
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
    static class Cliente {
        private String nombre;
        private String direccionEnvio;
        private List<Pedido> listaPedidos;

        public Cliente(String nombre, String direccionEnvio) {
            this.nombre = nombre;
            this.direccionEnvio = direccionEnvio;
            this.listaPedidos = new ArrayList<>();
        }
        public String getNombre() { return nombre; }
        public String getDireccionEnvio() { return direccionEnvio; }

        public void agregarPedido(Pedido pedido) {
            listaPedidos.add(pedido);
        }
    }
    static class Pedido {
        private Cliente cliente;
        private Map<Producto, Integer> productos;
        
        public Pedido(Cliente cliente) {
            this.cliente = cliente;
            this.productos = new HashMap<>();
        }
        public void agregarProducto(Producto producto, int cantidad) {
            productos.put(producto, cantidad);
        }
        public void mostrarPedido() {
            System.out.println("Pedido del Cliente: " + cliente.getNombre());
            for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
                Producto producto = entry.getKey();
                int cantidad = entry.getValue();
                System.out.println("Producto: " + producto.getNombre() + " x " + cantidad);
            }
        }
    }
    private List<Producto> inventario;
    private List<Cliente> clientes;

    public SistemaTienda() {
        this.inventario = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    public void mostrarInventario() {
        System.out.println("Inventario de la tienda: ");
        for (Producto producto : inventario) {
            producto.mostrarInformacion();
        }
    } 
    public static void main(String[] args) {
 
        SistemaTienda tienda = new SistemaTienda();
        Producto telefono = new Producto("IPhone", "Telefono inteligente ", 999.99, 10);
        Producto laptop = new Producto("MacBook", "Laptop con procesador M1 ", 1999.99, 5);
        tienda.agregarProducto(telefono);
        tienda.agregarProducto(laptop);

        tienda.mostrarInventario();

        Cliente cliente = new Cliente("Milena Rivera", "Calle 67, Ciudad Bogota ");
        tienda.agregarCliente(cliente);

        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(telefono, 1);
        pedido.agregarProducto(laptop, 2);

        cliente.agregarPedido(pedido);

        pedido.mostrarPedido();
    }
}