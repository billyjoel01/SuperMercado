package bjo.supermercado.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import bjo.supermercado.model.Producto;
import org.json.JSONObject;

public class ProductosAlmacenados {

    /**
     * Devuelve un mapa con los objectos productos
     * @return 
     */
    public Map<String, Producto> cargarProductos(){
        String content = Utils.getInstance().cargarArchivo(Utils.ARCHIVO_PRODUCTOS);
        JSONObject json = new JSONObject(content);
        Map<String, Producto> productos = new HashMap<>();
        for(Object o : json.getJSONArray("productos")){
            JSONObject p = (JSONObject)o;
            productos.put(p.getString("codigo"), new Producto(p.getString("codigo"), p.getDouble("precio")));
        }
        return productos;
    }

    /**
     * Actualiza los datos de los productos en el archivo 
     * @param productos 
     */
    public void actualizarProductos(Map<String, Producto> productos){
        JSONObject json = new JSONObject();
        List<Producto> array = new ArrayList<>();
        //productos.forEach(p->array.add(p));
        productos.values().forEach(p->array.add(p));
        json.put("productos", array);
        // Modificar el contenido (por ejemplo, agregando nueva información)
        String newContent = json.toString();
        Utils.getInstance().actualizarArchivo(Utils.ARCHIVO_PRODUCTOS, newContent);
    }
}
