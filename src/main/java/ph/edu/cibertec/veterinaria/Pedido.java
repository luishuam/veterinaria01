package ph.edu.cibertec.veterinaria;

public class Pedido {
    
    Motivo motivo;
    Mascota mascota;
    Veterinario veterinario;

    enum Motivo { //Invocacion rapida
        LAVADO, ANTIPARASITOS, ANTIPULGAS;
    }
}
