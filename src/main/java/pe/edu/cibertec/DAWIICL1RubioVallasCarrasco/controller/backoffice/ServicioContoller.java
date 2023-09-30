package pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.bd.Servicio;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.request.ServicioRequest;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWIICL1RubioVallasCarrasco.service.ServicioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/servicio")
public class ServicioContoller {


    private ServicioService servicioService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaServicios",
                servicioService.listarServicios());
        return "backoffice/servicio/frmMantServicio";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Servicio> listarServicios(){
        return servicioService.listarServicios();
    }



    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarServicio(
            @RequestBody ServicioRequest servicioRequest
    ){
        return servicioService.guardarServicio(servicioRequest);
    }
}
