package pe.edu.cibertec.DAWIICL1RibioVallasCarrasco.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tipomascota")
public class TipoMascota {
    @Id
    private Integer idtipomascota;
    @Column(name = "tipomascota")
    private String tipomascota;
}
