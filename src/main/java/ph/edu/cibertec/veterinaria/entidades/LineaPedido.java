package ph.edu.cibertec.veterinaria.entidades;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LineaPedido {

    Servicio servicio;
    Mascota mascota;
    Veterinario veterinario;
    double precio;

}
