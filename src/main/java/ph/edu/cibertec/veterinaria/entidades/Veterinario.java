package ph.edu.cibertec.veterinaria.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Veterinario {
    Long id;
    String nombre;
    String apellido;
    String codigoColegio;
}
