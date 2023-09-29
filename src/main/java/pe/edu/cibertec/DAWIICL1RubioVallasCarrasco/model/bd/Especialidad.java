package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    private Integer idespecialidad;

    @Column(name = "especialidad")
    private String especialidad;
}
