package co.Mintic.Ciclo3.Servicios;

import co.Mintic.Ciclo3.modelos.Empresa;
import co.Mintic.Ciclo3.repositorio.CompanyRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean deleteEmpresa(Integer id){
        companyRep.deleteById(id);
        if(companyRep.findById(id)!=null){
            return true;
        }
        return false;
    }





}
