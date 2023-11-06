package ph.edu.cibertec.veterinaria.entidades;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MascotaRequest {

    @NotBlank
    public String nombre;
    @NotBlank
    public String duenho;

    // @PositiveOrZero
    // @Min(1)
    // @Max(25)
    // int edad;

    // @Email
    // String email;

}
