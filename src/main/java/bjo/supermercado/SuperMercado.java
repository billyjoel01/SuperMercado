package bjo.supermercado;

import java.util.Map;
import javax.swing.JFrame;
import bjo.supermercado.gui.Principal;
import bjo.supermercado.model.Producto;
import bjo.supermercado.utils.ProductosAlmacenados;

public class SuperMercado {

    public static void main(String[] args) {
//        ProductosAlmacenados p = new ProductosAlmacenados();
//        Map<String, Producto> productos = p.cargarProductos();
////        productos.put("bjo", new Producto("bjo", 3.25));
//        productos.remove("bjo");
//        p.actualizarProductos(productos);

        Principal w = new Principal();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setVisible(true);
    }
}
