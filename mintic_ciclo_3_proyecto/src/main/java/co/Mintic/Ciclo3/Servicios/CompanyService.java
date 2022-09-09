package co.Mintic.Ciclo3.Servicios;

import co.Mintic.Ciclo3.modelos.Empresa;
import co.Mintic.Ciclo3.repositorio.CompanyRep;
import co.Mintic.Ciclo3.repositorio.MovimientoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRep companyRep;

    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        companyRep.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }

    public Empresa getEmpresaById(Integer id){
        return companyRep.findById(id).get();
    }
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=companyRep.save(empresa);
        if(companyRep.findById(emp.getId())!=null){
            return true;
        }
        return  false;
    }

    public List<Id> verId(){
        List<Id> IdList = new ArrayList<>();
        companyRep.addAll(MovimientoRep.findAll());
        return IdList;
    }



}
