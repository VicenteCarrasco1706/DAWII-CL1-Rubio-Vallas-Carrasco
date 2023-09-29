package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.request;

import lombok.Data;

@Data
public class VeterinarioRequest {

    private Integer idveterinario;
    private String nombrecompleto;
    private String numerodocumento;
    private String correo;
    private Integer idespecialidad;
    private Integer idestado;
}
