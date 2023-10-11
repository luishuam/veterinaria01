package ph.edu.cibertec.veterinaria.entidades;

public enum Servicio { // Invocacion rapida
    LAVADO(60),
    ANTIPARASITOS(50),
    ANTIPULGAS(30);

    double precio;

    Servicio(double precio) {
        this.precio = precio;
    }
}