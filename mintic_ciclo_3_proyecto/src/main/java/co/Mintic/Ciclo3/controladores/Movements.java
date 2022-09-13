package co.Mintic.Ciclo3.controladores;

import co.Mintic.Ciclo3.Servicios.EmployeService;
import co.Mintic.Ciclo3.modelos.Empleado;
import co.Mintic.Ciclo3.modelos.MovimientoDinero;
import co.Mintic.Ciclo3.Servicios.MovementsService;
import co.Mintic.Ciclo3.repositorio.MovementsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class Movements {

    @Autowired
    MovementsRep movementsRep;

    @Autowired
    MovementsService movementsService;

    @Autowired
    EmployeService employeService;

    @RequestMapping("/VerMovimientos")// Controlador que nos lleva al template donde veremos todos los movimientos
    public String viewMovimientos(@RequestParam(value="pagina", required=false, defaultValue = "1") int NumeroPagina,
                                  @RequestParam(value="medida", required=false, defaultValue = "5") int medida,
                                  Model model, @ModelAttribute("mensaje") String mensaje){
        Page<MovimientoDinero> paginaMovimientos= movementsRep.findAll(PageRequest.of(NumeroPagina,medida));
        model.addAttribute("movlist",paginaMovimientos.getContent());
        model.addAttribute("paginas",new int[paginaMovimientos.getTotalPages()]);
        model.addAttribute("paginaActual", NumeroPagina);
        model.addAttribute("mensaje",mensaje);
        Long sumaMonto=movementsService.obtenerSumaMontos();
        model.addAttribute("SumaMontos",sumaMonto);//Mandamos la suma de todos los montos a la plantilla
        return "verMovimientos"; //Llamamos al HTML
    }

    @GetMapping("/AgregarMovimiento") //Controlador que nos lleva al template donde podremos crear un nuevo movimiento
    public String nuevoMovimiento(Model model, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero movimiento= new MovimientoDinero();
        model.addAttribute("mov",movimiento);
        model.addAttribute("mensaje",mensaje);
        List<Empleado> listaEmpleados= employeService.getAllEmpleado();
        model.addAttribute("emplelist",listaEmpleados);
        return "agregarMovimiento"; //Llamar HTML
    }

    @PostMapping("/GuardarMovimiento")
    public String guardarMovimiento(MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movementsService.saveOrUpdateMovimiento(mov)){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarMovimiento";
    }

    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimento(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero mov=movementsService.getMovimientoById(id);
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("mov",mov);
        model.addAttribute("mensaje", mensaje);
        List<Empleado> listaEmpleados= employeService.getAllEmpleado();
        model.addAttribute("emplelist",listaEmpleados);
        return "editarMovimiento";
    }

    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(@ModelAttribute("mov") MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movementsService.saveOrUpdateMovimiento(mov)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarMovimiemto/"+mov.getId();

    }

    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (movementsService.deleteMovimiento(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos";
    }

    @GetMapping("/Empleado/{id}/Movimientos") //Filtro de movimientos por empleados
    public String movimientosPorEmpleado(@PathVariable("id")Integer id, Model model){
        List<MovimientoDinero> movlist = movementsService.obtenerPorEmpleado(id);
        model.addAttribute("movlist",movlist);
        Long sumaMonto=movementsService.MontosPorEmpleado(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "verMovimientos"; //Llamamos al HTML
    }

    @GetMapping("/Empresa/{id}/Movimientos") //Filtro de movimientos por empresa
    public String movimientosPorEmpresa(@PathVariable("id")Integer id, Model model){
        List<MovimientoDinero> movlist = movementsService.obtenerPorEmpresa(id);
        model.addAttribute("movlist",movlist);
        Long sumaMonto=movementsService.MontosPorEmpresa(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "verMovimientos"; //Llamamos al HTML
    }
}
