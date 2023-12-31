package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@Entity
@Table(name = "mascota")

public class Mascota {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idmascota;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechanacimiento")
    private Date fechanacimiento;
    @Column(name = "nombrepropietario")
    private String nombrepropietario;
    @Column(name = "raza")
    private String raza;

    @ManyToOne
    @JoinColumn(name = "idtipomascota")
    private TipoMascota tipomascota;
    @ManyToOne
    @JoinColumn(name = "idestado")
    private Estado estado;

}
