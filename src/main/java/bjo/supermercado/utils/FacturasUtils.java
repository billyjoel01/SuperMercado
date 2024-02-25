package bjo.supermercado.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import bjo.supermercado.model.Detalle;
import bjo.supermercado.model.Factura;
import org.json.JSONObject;

public class FacturasUtils {

    /**
     * Devuelve una lista con los objectos facturas
     * @return 
     */
    public List<Factura> cargarFacturas(){
        String content = Utils.getInstance().cargarArchivo(Utils.ARCHIVO_FACTURAS);
        JSONObject json = new JSONObject(content);
        List<Factura> facturas = new ArrayList<>();
        for(Object o : json.getJSONArray("facturas")){
            JSONObject f = (JSONObject)o;
            LinkedList<Detalle> detalles = new LinkedList<>();
            for(Object oo : f.getJSONArray("detalles")){
                JSONObject d = (JSONObject)oo;
                detalles.add(new Detalle(d.getString("codigo"), d.getDouble("precio"), d.getInt("cantidad"), d.getDouble("total")));
            }
            facturas.add(new Factura(detalles, f.getString("fecha"), f.getDouble("total")));
        }
        return facturas;
    }

    /**
     * Actualiza los datos de las facturas en el archivo 
     * @param facturas 
     */
    public void actualizarFacturas(List<Factura> facturas){
        JSONObject json = new JSONObject();
        List<Factura> array = new ArrayList<>();
        facturas.forEach(f->array.add(f));
        json.put("facturas", array);
        // Modificar el contenido (por ejemplo, agregando nueva información)
        String newContent = json.toString();
        Utils.getInstance().actualizarArchivo(Utils.ARCHIVO_FACTURAS, newContent);
    }
}
