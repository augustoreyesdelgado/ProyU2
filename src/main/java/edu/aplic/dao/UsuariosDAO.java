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
import edu.aplic.dto.UsoPersonalDTO;
import edu.aplic.dto.UsuarioDTO;
import edu.aplic.dto.UsuariosDTO;
import edu.aplic.jpa.model.Material;
import edu.aplic.jpa.model.Papeleria;
import edu.aplic.jpa.model.Usuario;
import edu.aplic.jpa.model.Usuarios;
import edu.aplic.jpa.model.Producto;
import edu.aplic.jpa.model.UsoPersonal;
import edu.aplic.jpa.repositories.MaterialIRep;
import edu.aplic.jpa.repositories.PapeleriaIRep;
import edu.aplic.jpa.repositories.UsoPersonalIRep;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.aplic.jpa.repositories.UsuarioIRep;

/**
 * Intermediario para ocultar uso de repositorios al controlador
 * en el caso de productos
 * @author BAOZ
 */
@Service
public class UsuariosDAO {
@Autowired
private PapeleriaIRep oRepoPap;
@Autowired
private UsoPersonalIRep oRepoUso;
@Autowired
private UsuarioIRep oRepoUsu;

@Autowired
private MaterialIRep oRepoMat;

private static final Logger logger = LoggerFactory.getLogger(UsuariosDAO.class);

public ProductoDTO buscar(int nTipo, int nCve ){
ProductoDTO oRet=null;
Producto p;
        if (nTipo == Papeleria.TIPO_PAPELERIA){
            if (oRepoPap.findById(nCve).isPresent()){
                p = oRepoPap.findById(nCve).get();
                oRet = new PapeleriaDTO();
                oRet.setClave(p.getClave());
                oRet.setNombre(p.getNombre());
                oRet.setDescripcion(p.getDescripcion());
                oRet.setPrecio(p.getPrecio());
                oRet.setImagen(p.getImagen());
                oRet.setMaterial(new MaterialDTO(
                        p.getMaterial().getCveMat(), 
                        p.getMaterial().getNombre()));
                ((PapeleriaDTO)oRet).setPresentacion(
                        ((Papeleria)p).getPresentacion());
            }
        }else{
            if (oRepoUso.findById(nCve).isPresent()){
                p = oRepoUso.findById(nCve).get();
                oRet = new UsoPersonalDTO();
                oRet.setClave(p.getClave());
                oRet.setNombre(p.getNombre());
                oRet.setDescripcion(p.getDescripcion());
                oRet.setPrecio(p.getPrecio());
                oRet.setImagen(p.getImagen());
                oRet.setMaterial(new MaterialDTO(
                        p.getMaterial().getCveMat(), 
                        p.getMaterial().getNombre()));
                ((UsoPersonalDTO)oRet).setTamanio(
                        ((UsoPersonal)p).getTamanio());
            }
        }
        return oRet;
    }
	
    public List<UsuariosDTO> buscarTodosPorTipo(int nTipo ){
    List<UsuariosDTO> listaRet=new ArrayList<>();
    PapeleriaDTO oPap;
    UsuariosDTO oUso;
        /*if (nTipo == Papeleria.TIPO_PAPELERIA){
            arrParcial = oRepoPap.findAll();
            if (arrParcial != null){
                for(Producto p:arrParcial){
                    oPap = new PapeleriaDTO();
                    oPap.setClave(p.getClave());
                    oPap.setNombre(p.getNombre());
                    oPap.setDescripcion(p.getDescripcion());
                    oPap.setPrecio(p.getPrecio());
                    oPap.setImagen(p.getImagen());
                    oPap.setMaterial(new MaterialDTO(
                        p.getMaterial().getCveMat(), 
                        p.getMaterial().getNombre()));
                    oPap.setPresentacion(((Papeleria)p).getPresentacion());
                    listaRet.add(oPap);
                }
            }
        }
        else{*/
            Iterable<? extends Usuarios> arrParcial1;
            arrParcial1 = oRepoUsu.findAll();
            if (arrParcial1 != null){
                for(Usuarios p:arrParcial1){
                    oUso = new UsuariosDTO();
                    oUso.setClave(p.getClave());
                    oUso.setNombre(p.getNombre());
                    oUso.setApellidop(p.getApellidop());
                    oUso.setApellidom(p.getApellidom());
                    oUso.setDireccion(p.getDireccion());
                    oUso.setTelefono(p.getTelefono());
                    oUso.setCorreo(p.getCorreo());
                    oUso.setContrasenia(p.getContrasenia());
                    listaRet.add(oUso);
                }
            }
        //}
        return listaRet;
    }
	
    public int insertar(UsuariosDTO oProd){
    int nRet = -1;
    Material oMat;
    
        try{
            if (/*oRepoMat.findById(oProd.getMaterial().getCveMat()).isPresent()*/1==1){
                //oMat = oRepoMat.findById(oProd.getMaterial().getCveMat()).get();
                if (oProd.getClass().equals(PapeleriaDTO.class)){
                    this.oRepoUsu.save(new Usuario(
                            oProd.getNombre(),oProd.getApellidop(),oProd.getApellidom(), oProd.getDireccion(),oProd.getTelefono(), oProd.getCorreo(), oProd.getContrasenia()));
                }else{
                    this.oRepoUsu.save(new Usuario(
                            oProd.getNombre(),oProd.getApellidop(),oProd.getApellidom(), oProd.getDireccion(), oProd.getTelefono(), oProd.getCorreo(), oProd.getContrasenia()));
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
