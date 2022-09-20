package co.Mintic.Ciclo3.repositorio;

import co.Mintic.Ciclo3.modelos.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

    @Repository
    public interface EmployeRep extends CrudRepository<Empleado, Integer> {
        @Query(value="SELECT * FROM empleado where empresa_id= ?1", nativeQuery=true)
        public abstract ArrayList<Empleado> findByEmpresa(Integer id);
    }


