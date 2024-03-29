package ph.edu.cibertec.veterinaria.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;
    public String dni;
    public String carnet;
    public BigDecimal salario;

    // Join
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = true, insertable = true, updatable = true)
    public Especialidad especialidad;
}
