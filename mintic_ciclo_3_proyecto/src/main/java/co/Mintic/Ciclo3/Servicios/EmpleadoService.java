package co.Mintic.Ciclo3.Servicios;

import co.Mintic.Ciclo3.modelos.Empleado;
import co.Mintic.Ciclo3.repositorio.EmpleadoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Servicio
public class EmpleadoService {

    @Autowired
    EmpleadoRep empleadoRep;
    private Empleado empleado;

    public List<Empleado> getAllEmpleados() {
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRep.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    public Optional <Empleado> getEmpleadoById(Integer id) {
        return empleadoRep.findById(id);
    }

    public boolean saveOrUpdateEmpresa(Empleado empleado) {
        Empleado emp = empleadoRep.save(empleado);
        if (empleadoRep.findById(emp.getId()) != null) {
            return true;
        }
        return false;
    }

    public boolean deleteEmpleado(Integer id){
        empleadoRep.deleteById(id);
        if(getEmpleadoById(id)!=null){
            return false;
        }
        return true;
    }
}
