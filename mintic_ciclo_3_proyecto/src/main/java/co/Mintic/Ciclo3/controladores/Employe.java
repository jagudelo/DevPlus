package co.Mintic.Ciclo3.controladores;

import co.Mintic.Ciclo3.Servicios.EmployeService;
import co.Mintic.Ciclo3.modelos.Empleado;
import co.Mintic.Ciclo3.modelos.Empresa;
import co.Mintic.Ciclo3.Servicios.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import java.util.List;
@Controller
public class Employe {

    @Autowired
    EmployeService employeService;

    @Autowired
    CompanyService companyService;

    @GetMapping("/VerEmpleados")
    public String viewEmpleados(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Empleado> listaEmpleados=employeService.getAllEmpleado();
        model.addAttribute("emplelist",listaEmpleados);
        model.addAttribute("mensaje",mensaje);
        return "verEmpleados"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpleado")
    public String nuevoEmpleado(Model model, @ModelAttribute("mensaje") String mensaje){
        Empleado empl= new Empleado();
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje",mensaje);
        List<Empresa> listaEmpresas= companyService.getAllEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "agregarEmpleado"; //Llamar HTML
    }

    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado empl, RedirectAttributes redirectAttributes){
        if(employeService.saveOrUpdateEmpleado(empl)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpleado";
    }

    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empleado empl=employeService.getEmpleadoById(id).get();
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas= companyService.getAllEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "editarEmpleado";
    }

    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("empl") Empleado empl, RedirectAttributes redirectAttributes){
        if(employeService.saveOrUpdateEmpleado(empl)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpleado/"+empl.getId();

    }

    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (employeService.deleteEmpleado(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleados";
    }

    @GetMapping("/Empresa/{id}/Empleados") //Filtrar los empleados por empresa
    public String verEmpleadosPorEmpresa(@PathVariable("id") Integer id, Model model){
        List<Empleado> listaEmpleados = employeService.obtenerPorEmpresa(id);
        model.addAttribute("emplelist",listaEmpleados);
        return "verEmpleados"; //Llamamos al html con el emplelist de los empleados filtrados
    }


}
