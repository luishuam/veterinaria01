package ph.edu.cibertec.veterinaria.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Veterinario {
    @Id
    Long id;
    String nombre;
    String apellido;
    String codigoColegio;
}
