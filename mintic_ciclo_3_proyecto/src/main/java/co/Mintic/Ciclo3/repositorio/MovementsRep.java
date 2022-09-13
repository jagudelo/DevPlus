package co.Mintic.Ciclo3.repositorio;

import co.Mintic.Ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovementsRep extends JpaRepository<MovimientoDinero, Integer> {
    @Query(value = "select * from movimientos where empelado_id= ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Integer Id);

    @Query(value="select * from movimientos where empleado_id in (select id from empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Integer id);

    @Query(value="SELECT SUM(monto) from movimientos", nativeQuery = true)
    public abstract Long SumarMonto();

    @Query(value="SELECT SUM(monto) from movimientos where empleado_id=?1", nativeQuery = true)
    public abstract Long MontosPorEmpleado(Integer id);

    @Query(value="select sum(monto) from movimientos where empleado_id in (select id from empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract Long MontosPorEmpresa(Integer id);


}
