package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
    private Boolean respuesta;
    private String mensaje;
}
