package co.Mintic.Ciclo3.repositorio;


import co.Mintic.Ciclo3.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Anotación le indica a spring que la clase es un repositorio
public interface CompanyRep extends JpaRepository<Empresa, Integer> {
}
