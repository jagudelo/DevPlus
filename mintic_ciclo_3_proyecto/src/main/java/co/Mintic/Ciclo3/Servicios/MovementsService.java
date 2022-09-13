package co.Mintic.Ciclo3.Servicios;

import co.Mintic.Ciclo3.modelos.MovimientoDinero;
import co.Mintic.Ciclo3.repositorio.MovementsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovementsService {
    
    @Autowired
    MovementsRep movementsRep;

    public List<MovimientoDinero> getAllMovimientos(){ //Metodo que me muestra todos los movimientos sin ningn filtro
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movementsRep.findAll().forEach(movimiento -> movimientosList.add(movimiento));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return movimientosList;
    }

    public MovimientoDinero getMovimientoById(Integer id){ //Ver movimientos por id
        return movementsRep.findById(id).get();
    }

    public boolean saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){ //Guardar o actualizar elementos
        MovimientoDinero mov=movementsRep.save(movimientoDinero);
        if (movementsRep.findById(mov.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteMovimiento(Integer id){
        movementsRep.deleteById(id);
        if(this.movementsRep.findById(id).isPresent()){
            return false;
        }
        return true;
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) {
        return movementsRep.findByEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) {
        return movementsRep.findByEmpresa(id);
    }


    public Long obtenerSumaMontos(){
        return movementsRep.SumarMonto();
    }

    public Long MontosPorEmpleado(Integer id){
        return movementsRep.MontosPorEmpleado(id);
    }

    public Long MontosPorEmpresa(Integer id){
        return movementsRep.MontosPorEmpresa(id);
    }
    
}
