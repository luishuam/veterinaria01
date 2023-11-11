package ph.edu.cibertec.veterinaria.entidades;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeterinarioRequest {

    @NotBlank
    public String nombre;
    @NotBlank
    public String carnet;
    @NotBlank
    public String dni;
    public BigDecimal salario;
    public Especialidad especialidad_id2;
}
