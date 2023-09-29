package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.request;

import lombok.Data;

@Data
public class ServicioRequest {

    private Integer idservicio;
    private String descripcion;
    private Double precio;
    private Integer idestado;

}
