package bjo.supermercado.model;

public class Detalle extends Producto {

    private Integer cantidad;
    private Double total;

    public Detalle(String codigo, double precio, int cantidad, double total) {
        super(codigo, precio);
        this.cantidad = cantidad;
        this.total = total;
    }

    @Override
    public String toString() {
        return getCodigo() + "\t\t" + cantidad + "\t\t" + getPrecio() + "\t\t" + total;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
