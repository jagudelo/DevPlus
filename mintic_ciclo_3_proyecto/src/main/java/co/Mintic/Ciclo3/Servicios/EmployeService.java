package co.Mintic.Ciclo3.Servicios;

import co.Mintic.Ciclo3.modelos.Empleado;
import co.Mintic.Ciclo3.repositorio.EmployeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    
    @Autowired
    EmployeRep employeRep;

    public List<Empleado> getAllEmpleado(){
        List<Empleado> empleadoList= new ArrayList<>();
        employeRep.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    //Metodo para buscar empleados por ID
    public Optional<Empleado> getEmpleadoById(Integer id){ //Existe optional y asi se podria usar

        return employeRep.findById(id);
    }

    //Metodo para buscar empleados por empresa
    public ArrayList<Empleado> obtenerPorEmpresa(Integer id){
        return employeRep.findByEmpresa(id);
    }

    //Metodo para guardar o actualizar registros en Empleados
    public boolean saveOrUpdateEmpleado(Empleado empl){
        Empleado emp=employeRep.save(empl);
        if (employeRep.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }

    //Metodo para eliminar un registro de Empleado por Id
    public boolean deleteEmpleado(Integer id){
        employeRep.deleteById(id);
        if(this.employeRep.findById(id).isPresent()){
            return false;
        }
        return true;
    }




}
