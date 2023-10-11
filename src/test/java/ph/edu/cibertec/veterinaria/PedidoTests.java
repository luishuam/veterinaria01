package ph.edu.cibertec.veterinaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ph.edu.cibertec.veterinaria.entidades.LineaPedido;
import ph.edu.cibertec.veterinaria.entidades.Mascota;
import ph.edu.cibertec.veterinaria.entidades.Pedido;
import ph.edu.cibertec.veterinaria.entidades.Servicio;
import ph.edu.cibertec.veterinaria.entidades.Veterinario;

public class PedidoTests {

    @Test
    void probarMontoTotal() {

        Mascota mascota = new Mascota();
        mascota.setName("manolo");
        mascota.setOwner("Manuel");

        Veterinario veterinario = new Veterinario();
        veterinario.setNombre("Dr. Choy");

        Pedido pedido = new Pedido();
        pedido.nombreCliente = "Arthur";
        pedido.lineas = new ArrayList<>();
        pedido.lineas.add(new LineaPedido(Servicio.LAVADO, mascota, veterinario, 66.0));

        assertEquals(pedido.montoTotal(), 66.0);
    }
}
