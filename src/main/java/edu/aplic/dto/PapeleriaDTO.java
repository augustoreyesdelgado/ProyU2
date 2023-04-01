package edu.aplic.dto;

import edu.aplic.jpa.model.EnumPresentacion;
/**
 * Clase para mapear el concepto Producto de tipo Papelería
 * @author BAOZ
 */
public class PapeleriaDTO extends ProductoDTO{
private EnumPresentacion nPresentacion;
    public PapeleriaDTO(){}
    
    public PapeleriaDTO(int nCve, String sNom, String sDescrip, float nPre,
            String sImg, MaterialDTO oM, EnumPresentacion nPres){
        this.nClave = nCve;
        this.sNombre = sNom;
        this.sDescripcion = sDescrip;
        this.nPrecio = nPre;
        this.sImagen = sImg;
        this.oMaterial = oM;
        this.nPresentacion = nPres;
    }
    
    public EnumPresentacion getPresentacion(){
        return this.nPresentacion;
    }
    public void setPresentacion(EnumPresentacion val){
        this.nPresentacion = val;
    }
}
