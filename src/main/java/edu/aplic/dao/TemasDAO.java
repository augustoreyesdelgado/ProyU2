/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.dao;

/**
 *
 * @author augus
 */
import edu.aplic.dto.MaterialDTO;
import edu.aplic.dto.PapeleriaDTO;
import edu.aplic.dto.ProductoDTO;
import edu.aplic.dto.TemasDTO;
import edu.aplic.dto.UsoPersonalDTO;
import edu.aplic.jpa.model.Material;
import edu.aplic.jpa.model.Papeleria;
import edu.aplic.jpa.model.Producto;
import edu.aplic.jpa.model.Tema;
import edu.aplic.jpa.model.Temas;
import edu.aplic.jpa.model.UsoPersonal;
import edu.aplic.jpa.repositories.MaterialIRep;
import edu.aplic.jpa.repositories.PapeleriaIRep;
import edu.aplic.jpa.repositories.TemasIRep;
import edu.aplic.jpa.repositories.UsoPersonalIRep;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Intermediario para ocultar uso de repositorios al controlador
 * en el caso de productos
 * @author BAOZ
 */
@Service
public class TemasDAO {
@Autowired
private PapeleriaIRep oRepoPap;
@Autowired
private UsoPersonalIRep oRepoUso;
@Autowired
private TemasIRep oRepotem;

@Autowired
private MaterialIRep oRepoMat;

private static final Logger logger = LoggerFactory.getLogger(TemasDAO.class);
	
    public List<TemasDTO> buscarTodosPorTipo(int nTipo ){
    List<TemasDTO> listaRet=new ArrayList<>();
    PapeleriaDTO oPap;
    TemasDTO oUso;
            Iterable<? extends Temas> arrParcial1;
            arrParcial1 = oRepotem.findAll();
            if (arrParcial1 != null){
                for(Temas p:arrParcial1){
                    oUso = new TemasDTO();
                    oUso.setClave(p.getClave());
                    oUso.setNombre(p.getNombre());
                    oUso.setDescripcion(p.getDescripcion());
                    oUso.setImagen(p.getImagen());
                    listaRet.add(oUso);
                }
            }
        //}
        return listaRet;
    }
	
    public int insertar(TemasDTO oProd){
    int nRet = -1;
    Material oMat;
    
        try{
            if (/*oRepoMat.findById(oProd.getMaterial().getCveMat()).isPresent()*/1==1){
                //oMat = oRepoMat.findById(oProd.getMaterial().getCveMat()).get();
                if (oProd.getClass().equals(PapeleriaDTO.class)){
                    this.oRepotem.save(new Tema(
                            oProd.getNombre(),oProd.getDescripcion(),oProd.getImagen()));
                }else{
                    this.oRepotem.save(new Tema(
                            oProd.getNombre(),oProd.getDescripcion(),oProd.getImagen()));
                    /*this.oRepoUso.save(new UsoPersonal(
                            oProd.getNombre(), oProd.getDescripcion(),
                            oProd.getPrecio(), oProd.getImagen(), oMat,
                            ((UsoPersonalDTO)oProd).getTamanio()));*/
                }
                nRet = 1;
            }
        }catch(Exception e){
            logger.info(e.getMessage());
        }
        return nRet;
    }
    
    public int modificar(ProductoDTO oProd){
    int nRet = -1;
    Material oMat;
    Producto oProdTmp;
    
        try{
            if (oRepoMat.findById(oProd.getMaterial().getCveMat()).isPresent()){
                oMat = oRepoMat.findById(oProd.getMaterial().getCveMat()).get();
                if (oProd.getClass().equals(PapeleriaDTO.class)){
                    oProdTmp = this.oRepoPap.findById(oProd.getClave()).get();
                    ((Papeleria)oProdTmp).setPresentacion(
                            ((PapeleriaDTO)oProd).getPresentacion());
                }else{
                    oProdTmp = this.oRepoUso.findById(oProd.getClave()).get();
                    ((UsoPersonal)oProdTmp).setTamanio(
                            ((UsoPersonalDTO)oProd).getTamanio());
                }
                oProdTmp.setNombre(oProd.getNombre());
                oProdTmp.setDescripcion(oProd.getDescripcion());
                oProdTmp.setPrecio(oProd.getPrecio());
                oProdTmp.setImagen(oProd.getImagen());
                oProdTmp.setMaterial(oMat);
                if (oProd.getClass().equals(PapeleriaDTO.class)){
                    this.oRepoPap.save((Papeleria)oProdTmp);
                }else{
                    this.oRepoUso.save((UsoPersonal)oProdTmp);
                }
                nRet = 1;
            }
        }catch(Exception e){
            logger.info(e.getMessage());
        }
        return nRet;
    }
}