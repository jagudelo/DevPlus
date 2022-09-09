package co.Mintic.Ciclo3.controladores;

import co.Mintic.Ciclo3.Servicios.CompanyService;
import co.Mintic.Ciclo3.modelos.Empresa;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class Company {
@Autowired
   CompanyService companyService;

    @GetMapping({"/1","/2"})
    public String vb (Model model){
        List<Empresa> listar2 =companyService.getAllEmpresas();
        model.addAttribute( "listar", listar2);
        return "3";

    }

}
