package edu.aplic.fbo;

import edu.aplic.dto.MenusDTO;
import edu.aplic.dto.ProductoDTO;
import edu.aplic.dto.TemasDTO;
import edu.aplic.dto.UsuariosDTO;
import java.util.List;
import java.util.Map;
import jakarta.validation.constraints.Min;
import edu.aplic.jpa.model.EnumPresentacion;
import edu.aplic.jpa.model.EnumTamanio;
import java.util.EnumMap;

/**
 * Clase que representa los elementos de captura del formulario y sus resultados
 * @author BAOZ
 */
public class BuscaDatosFrm {
private int nTipoProd=-1;

private Map<Integer, String> listaMateriales;
private List<ProductoDTO> listaProductos;
private List<UsuariosDTO> listaUsuarios;
private List<TemasDTO> listaTemas;
private List<MenusDTO> listaMenus;
private ProductoDTO oProdCapt;
private UsuariosDTO oProdCapt1;
private TemasDTO oProdCapt2;
private MenusDTO oProdCapt3;
private EnumPresentacion oPres;
private EnumTamanio oTam;
private String sOpeSelec="a";
private int nClaveSelec=0;

private static final EnumMap<EnumPresentacion, String> mapPres =
        new EnumMap<>(EnumPresentacion.class);
private static final EnumMap<EnumTamanio, String> mapTam =
        new EnumMap<>(EnumTamanio.class);
    static{
        mapPres.put(EnumPresentacion.DE_LUJO, "De lujo");
        mapPres.put(EnumPresentacion.SENCILLA, "Sencilla");
        mapTam.put(EnumTamanio.CHICO, "Chico");
        mapTam.put(EnumTamanio.MEDIANO, "Mediano");
        mapTam.put(EnumTamanio.GRANDE, "Grande");
    }

    public Map<Integer, String> getListaMateriales() {
        return listaMateriales;
    }
    
    public Map<EnumPresentacion, String> getListaPresentaciones(){
        return mapPres;
    }
    
    public Map<EnumTamanio,String> getListaTamanios(){
        return mapTam;
    }

    public void setListaMateriales(Map<Integer, String> val) {
        this.listaMateriales = val;
    }

    public List<UsuariosDTO> getListaProductos() {
        return listaUsuarios;
    }

    public void setListaProductos(List<UsuariosDTO> val) {
        this.listaUsuarios = val;
    }
    
    public List<TemasDTO> getListaTemas() {
        return listaTemas;
    }

    public void setListaTemas(List<TemasDTO> val) {
        this.listaTemas = val;
    }
    
    public List<MenusDTO> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<MenusDTO> val) {
        this.listaMenus = val;
    }
    
    public int getTipoProd(){
        return this.nTipoProd;
    }
    public void setTipoProd(int val){
        this.nTipoProd = val;
    }

    public ProductoDTO getProdCapt(){
        return this.oProdCapt;
    }
    public void setProdCapt(ProductoDTO val){
        this.oProdCapt = val;
    }
    
    public UsuariosDTO getProdCapt1(){
        return this.oProdCapt1;
    }
    public void setProdCapt1(UsuariosDTO val){
        this.oProdCapt1 = val;
    }
    
    public TemasDTO getProdCapt2(){
        return this.oProdCapt2;
    }
    public void setProdCapt2(TemasDTO val){
        this.oProdCapt2 = val;
    }
    
    public MenusDTO getProdCapt3(){
        return this.oProdCapt3;
    }
    public void setProdCapt3(MenusDTO val){
        this.oProdCapt3 = val;
    }

    public EnumPresentacion getPres(){
        return this.oPres;
    }
    public void setPres(EnumPresentacion val){
        this.oPres = val;
    }

    public EnumTamanio getTam(){
        return this.oTam;
    }
    public void setTam(EnumTamanio val){
        this.oTam = val;
    }
	
	public String getOpeSelec(){
		return this.sOpeSelec;
	}
	public void setOpeSelec(String val){
		this.sOpeSelec = val;
	}
    
    public int getClaveSelec(){
        return this.nClaveSelec;
    }
    public void setClaveSelec(int val){
        this.nClaveSelec = val;
    }

    public EnumTamanio getTamanio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
