package co.Mintic.Ciclo3.controladores;


import co.Mintic.Ciclo3.Servicios.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;

@RestController
public class MovimientoControl {
    @Autowired
    CompanyService companyService;

    @GetMapping("/movimientoDinero")
    private List<Id> verId(){
        List<Id> Ids = companyService.verId();
        return Ids;

    }
}
