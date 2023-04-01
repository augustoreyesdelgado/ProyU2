package edu.aplic.dto;

import edu.aplic.jpa.model.EnumTamanio;

/**
 * Clase para mapear el concepto Producto de Uso Personal
 * @author BAOZ
 */
public class UsoPersonalDTO extends ProductoDTO{
private EnumTamanio nTamanio;
private String nAuxiliar;
    public UsoPersonalDTO(){}
    
    public UsoPersonalDTO(int nCve, String sNom, String sDescrip, float nPre,
            String sImg, MaterialDTO oM, EnumTamanio nTam){
        this.nClave = nCve;
        this.sNombre = sNom;
        this.sDescripcion = sDescrip;
        this.nPrecio = nPre;
        this.sImagen = sImg;
        this.oMaterial = oM;
        this.nTamanio = nTam;
        this.nAuxiliar = "ses";
    }
    
    public EnumTamanio getTamanio(){
        return this.nTamanio;
    }
    public void setTamanio(EnumTamanio val){
        this.nTamanio = val;
    }
    public String getAux(){
        return this.nAuxiliar;
    }
    public void setAux(String val){
        this.nAuxiliar = val;
    }
}
