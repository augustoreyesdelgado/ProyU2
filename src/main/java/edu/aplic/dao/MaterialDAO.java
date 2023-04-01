package edu.aplic.dao;

import edu.aplic.dto.MaterialDTO;
import edu.aplic.jpa.model.Material;
import edu.aplic.jpa.repositories.MaterialIRep;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Intermediario para ocultar uso de repositorios al controlador
 * @author BAOZ
 */
@Service
public class MaterialDAO {
@Autowired
MaterialIRep oRepo;

    public MaterialDTO buscar(int nCve ){
    MaterialDTO oRet=null;
	Material oEnt = null;
        if (oRepo.findById(nCve).isPresent()){
            oEnt = oRepo.findById(nCve).get();
            oRet = new MaterialDTO(nCve, oEnt.getNombre());
        }
        return oRet;
    }
	
    public List<MaterialDTO> buscarTodos(){
    List<MaterialDTO> listaRet=new ArrayList<>();
    Iterable<Material> arrMat;
    MaterialDTO oMat;
        arrMat = oRepo.findAll();
        if (arrMat != null){
            for(Material m: arrMat){
                oMat = new MaterialDTO();
                oMat.setCveMat(m.getCveMat());
                oMat.setNombre(m.getNombre());
                listaRet.add(oMat);
            }
        }
        return listaRet;
    }
}
