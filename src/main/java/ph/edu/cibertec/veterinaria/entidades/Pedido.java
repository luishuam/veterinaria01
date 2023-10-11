package ph.edu.cibertec.veterinaria.entidades;

public class Pedido {

    // Servicio servicio;
    // Mascota mascota;

    public java.util.List<LineaPedido> lineas;
    public String nombreCliente;

    public double montoTotal() {
        double resultado = 0;
        for (LineaPedido lineaPedido : lineas) {
            resultado += lineaPedido.precio;
        }
        return resultado;
    };

}
