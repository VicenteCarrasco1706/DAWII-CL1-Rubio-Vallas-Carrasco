package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idservicio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "idestado")
    private Estado estado;

}
