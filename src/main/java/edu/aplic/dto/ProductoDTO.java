package edu.aplic.dto;

/**
 * Clase para el concepto de producto (abstracto)
 * @author BAOZ
 */
public class ProductoDTO{
protected int nClave;
protected String sNombre;
protected String sDescripcion;
protected float nPrecio;
protected String sImagen;
protected MaterialDTO oMaterial=new MaterialDTO();
    
    public int getClave(){
            return this.nClave;
    }
    public void setClave(int val){
            this.nClave = val;
    }

    public String getNombre(){
            return this.sNombre;
    }
    public void setNombre(String val){
            this.sNombre = val;
    }

    public String getDescripcion(){
            return this.sDescripcion;
    }
    public void setDescripcion(String val){
            this.sDescripcion = val;
    }

    public float getPrecio(){
            return this.nPrecio;
    }
    public void setPrecio(float val){
            this.nPrecio = val;
    }

    public String getImagen(){
            return this.sImagen;
    }
    public void setImagen(String val){
            this.sImagen = val;
    }

    public MaterialDTO getMaterial(){
            return this.oMaterial;
    }
    public void setMaterial(MaterialDTO val){
            this.oMaterial = val;
    }
}
