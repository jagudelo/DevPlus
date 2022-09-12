package co.Mintic.Ciclo3.controladores;


import co.Mintic.Ciclo3.Servicios.CompanyService;
import co.Mintic.Ciclo3.modelos.MovimientoDinero;
import co.Mintic.Ciclo3.repositorio.MovimientoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
public class MovimientoControl {
    @Autowired
    CompanyService companyService;

    @PostMapping("/movimientoDinero")
    private void crearId(@RequestBody MovimientoDinero)

    }
}
