package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.request;

import lombok.Data;

import java.util.Date;
@Data
public class MascotaRequest {
    private Integer idmascota;
    private String nombre;
    private Date fechanacimiento;
    private String nombrepropietario;
    private String raza;
    private Integer idtipomascota;
    private Integer idestado;
}
