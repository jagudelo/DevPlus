package co.Mintic.Ciclo3.repositorio;

import co.Mintic.Ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimientoRep extends JpaRepository <MovimientoDinero,Long>{

}
