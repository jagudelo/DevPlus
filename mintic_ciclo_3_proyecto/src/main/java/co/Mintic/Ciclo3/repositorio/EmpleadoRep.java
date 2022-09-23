package co.Mintic.Ciclo3.repositorio;

import co.Mintic.Ciclo3.modelos.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.Mintic.Ciclo3.Servicios.EmpleadoService;
import java.util.Map;

@Repository //Repositorio
public interface EmpleadoRep extends JpaRepository<Empleado, Integer> {


}
