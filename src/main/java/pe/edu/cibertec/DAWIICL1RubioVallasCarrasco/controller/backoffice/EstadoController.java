package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.controller.backoffice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Estado;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service.EstadoService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/estado")
public class EstadoController {

    private EstadoService estadoService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Estado> listarEstados(){
        return estadoService.listarEstados();
    }

}
