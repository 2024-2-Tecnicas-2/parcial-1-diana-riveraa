import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public static class TestSistemaTienda {

        @org.junit.Test
        public void testCrearProducto() {
            Producto producto = new Producto("IPhone", "Telefono inteligente", 999.99, 10);

            org.junit.Assert.assertEquals("IPhone", producto.getNombre());
            org.junit.Assert.assertEquals("Telefono inteligente", producto.getDescripcion());
            org.junit.Assert.assertEquals(999.99, producto.getPrecio(), 0.01);
            org.junit.Assert.assertEquals(10, producto.getCantidadInventario());
        }
        @org.junit.Test
        public void testActualizarInventario() {
            Producto producto = new Producto("IPhone", "Teléfono inteligente", 999.99, 10);
            producto.setCantidadInventario(20);

            org.junit.Assert.assertEquals(20, producto.getCantidadInventario());
        }
        @org.junit.Test
        public void testAgregarProductoAlPedido() {
            Cliente cliente = new Cliente("Milena Rivera", "Calle 67, Ciudad Bogota ");
            Pedido pedido = new Pedido(cliente);
            Producto telefono = new Producto("IPhone", "Telefono inteligente", 999.99, 10);

            pedido.agregarProducto(telefono, 2);

            Map<Producto, Integer> productos = pedido.productos;
            org.junit.Assert.assertEquals(1, productos.size()); 
            org.junit.Assert.assertEquals(2, (int) productos.get(telefono)); 
        }
        @org.junit.Test
        public void testClienteEnPedido() {
            Cliente cliente = new Cliente("Milena Rivera", "Calle 67, Ciudad Bogota ");
            Pedido pedido = new Pedido(cliente);

            org.junit.Assert.assertEquals("Milena Rivera", pedido.cliente.getNombre());
        }
    }