package bjo.supermercado.model;

import java.util.LinkedList;

public class Factura {
    
    private LinkedList<Detalle> detalles;
    private String fecha;
    private double total;

    public Factura(LinkedList<Detalle> detalles, String fecha, double total) {
        this.detalles = detalles;
        this.fecha = fecha;
        this.total = total;
    }

    /**
     * @return the detalles
     */
    public LinkedList<Detalle> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(LinkedList<Detalle> detalles) {
        this.detalles = detalles;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    

}
