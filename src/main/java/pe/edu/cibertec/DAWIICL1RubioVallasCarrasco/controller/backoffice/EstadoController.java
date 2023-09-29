package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.controller.backoffice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "estado")
public class EstadoController {
    @Id
    private Integer idestado;
    @Column(name = "estado")
    private String estado;

}
