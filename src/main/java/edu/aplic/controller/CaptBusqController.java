package edu.aplic.controller;

import edu.aplic.dao.MaterialDAO;
import edu.aplic.dao.MenusDAO;
import edu.aplic.dao.ProductoDAO;
import edu.aplic.dao.TemasDAO;
import edu.aplic.dao.UsuariosDAO;
import edu.aplic.fbo.BuscaDatosFrm;
import edu.aplic.dto.MaterialDTO;
import edu.aplic.dto.PapeleriaDTO;
import edu.aplic.dto.UsuarioDTO;
import edu.aplic.dto.ProductoDTO;
import edu.aplic.dto.UsoPersonalDTO;
import edu.aplic.dto.UsuariosDTO;
import edu.aplic.jpa.model.Papeleria;
import edu.aplic.jpa.model.Usuario;
import edu.aplic.jpa.model.UsoPersonal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para responder a dos solicitudes (index y procesamiento de formulario),
 * el manejo de Internacionalización (i18n) sólo afecta a la vista
 * @author BAOZ
 */
@Controller  
public class CaptBusqController {
@Autowired
private MaterialDAO oServMat;
@Autowired
private UsuariosDAO oServProd;
@Autowired
private TemasDAO oServProd1;
@Autowired
private MenusDAO oServProd2;
@Autowired
private ApplicationContext appContext;

    
    private Map<Integer, String> llenaLista() {
     Map<Integer, String> listaValores;
        listaValores = new LinkedHashMap<>();
        List<MaterialDTO> listaMat = oServMat.buscarTodos();
        for(MaterialDTO m: listaMat){
            listaValores.put(m.getCveMat(), m.getNombre());
        }
        return listaValores;
    }

    @GetMapping("/")
    public ModelAndView inicia() {
    ModelAndView oRet=null;
    BuscaDatosFrm oDat=new BuscaDatosFrm();
        oRet = new ModelAndView("index", "datos", oDat);
        return oRet;
    }
    
    @RequestMapping("/banquete")  
    public ModelAndView mostrarOtra()  
    {  
        ModelAndView oMV = new ModelAndView();
        oMV.setViewName("banquetes");
        return oMV;  
    }
    
    @RequestMapping("/proceso")  
    public ModelAndView mostrarProceso()  
    {  
        ModelAndView oMV = new ModelAndView();
        oMV.setViewName("proceso");
        return oMV;  
    }
    
    @RequestMapping("/registro")  
    public ModelAndView mostrarregistro()  
    {  
        ModelAndView oMV = new ModelAndView();
        oMV.setViewName("registro");
        return oMV;  
    }
    @RequestMapping("/login")  
    public ModelAndView mostrarlogin()  
    {  
        ModelAndView oMV = new ModelAndView();
        oMV.setViewName("login");
        return oMV;  
    }
    
    @RequestMapping("/menusc")
    public ModelAndView buscamenus(@Valid @ModelAttribute("datos")BuscaDatosFrm oDat, BindingResult oResultado, ModelMap oModeloVista) {
    ModelAndView oRet=null;
                oDat.setListaMenus(
                    oServProd2.buscarTodosPorTipo(UsoPersonal.TIPO_USO_PERSONAL));
            oRet = new ModelAndView("menus", "datos", oDat);
        
        return oRet;
    }
    @RequestMapping("/temasc")
    public ModelAndView buscatemas(@Valid @ModelAttribute("datos")BuscaDatosFrm oDat1, BindingResult oResultado, ModelMap oModeloVista) {
    ModelAndView oRet=null;
                oDat1.setListaTemas(
                    oServProd1.buscarTodosPorTipo(UsoPersonal.TIPO_USO_PERSONAL));
            oRet = new ModelAndView("temas", "datos", oDat1);
        
        return oRet;
    }
    
    @RequestMapping("/acercade")  
    public ModelAndView mostraracercade()  
    {  
        ModelAndView oMV = new ModelAndView();
        oMV.setViewName("acercade");
        return oMV;  
    }
    
    @RequestMapping("/registro1")  
    public ModelAndView mostrarregistro1()  
    {  
        ModelAndView oMV = new ModelAndView();
        oMV.setViewName("edproductos");
        return oMV;  
    }

    @RequestMapping("/catprod1")
    public ModelAndView buscaProdPorTipo1(@Valid @ModelAttribute("datos")BuscaDatosFrm oDat, BindingResult oResultado, ModelMap oModeloVista) {
    ModelAndView oRet=null;
                oDat.setListaProductos(
                    oServProd.buscarTodosPorTipo(UsoPersonal.TIPO_USO_PERSONAL));
            oRet = new ModelAndView("catproductos", "datos", oDat);
        
        return oRet;
    }
    
    @PostMapping("/catprod")
    public ModelAndView buscaProdPorTipo(@Valid @ModelAttribute("datos")BuscaDatosFrm oDat, BindingResult oResultado, ModelMap oModeloVista) {
    ModelAndView oRet=null;
	if (oResultado.hasErrors()) {
            oModeloVista.addAttribute("textoError", 
                appContext.getMessage("error.captura", null, 
                        LocaleContextHolder.getLocale()));
            oRet = new ModelAndView("index", "datos", oDat);
        }else{
            if (oDat.getTipoProd() == Papeleria.TIPO_PAPELERIA){
                oDat.setListaProductos(
                    oServProd.buscarTodosPorTipo(Papeleria.TIPO_PAPELERIA));
            }else if (oDat.getTipoProd() == Usuario.TIPO_USUARIO){
                oDat.setListaProductos(
                    oServProd.buscarTodosPorTipo(Papeleria.TIPO_PAPELERIA));}
            else
                oDat.setListaProductos(
                    oServProd.buscarTodosPorTipo(UsoPersonal.TIPO_USO_PERSONAL));
            oRet = new ModelAndView("catproductos", "datos", oDat);
        }
        return oRet;
    }
    
    @PostMapping("/editaprod")
    public ModelAndView editaProducto(@Valid @ModelAttribute("datos")BuscaDatosFrm oDat, BindingResult oResultado, ModelMap oModeloVista) {
    ModelAndView oRet=null;
    ProductoDTO oProd=null;
    UsuariosDTO oProd1=null;
		if (oResultado.hasErrors()) {
            oModeloVista.addAttribute("textoError", 
                appContext.getMessage("error.captura", null, 
                        LocaleContextHolder.getLocale()));
            oRet = new ModelAndView("index", "datos", oDat);
        }else{
            oDat.setListaMateriales(llenaLista());
            if (oDat.getOpeSelec().equals("a")){
                if (oDat.getTipoProd() == Papeleria.TIPO_PAPELERIA){
                    oProd = new PapeleriaDTO();}
                if (oDat.getTipoProd() == Usuario.TIPO_USUARIO){
                    oProd1 = new UsuarioDTO();
                }
                else
                    oProd = new UsoPersonalDTO();
            }else{
                oProd = oServProd.buscar(oDat.getTipoProd(), 
                        oDat.getClaveSelec());
                if (oDat.getTipoProd() == Papeleria.TIPO_PAPELERIA)
                    oDat.setPres(((PapeleriaDTO)oProd).getPresentacion());
                else
                    oDat.setTam(((UsoPersonalDTO)oProd).getTamanio());
            }
            oDat.setProdCapt(oProd);
            oRet = new ModelAndView("edproductos", "datos", oDat);
        }
        return oRet;
    }
    
    @RequestMapping("/editaprod1")
    public ModelAndView editaProducto1(@Valid @ModelAttribute("datos")BuscaDatosFrm oDat, BindingResult oResultado, ModelMap oModeloVista) {
    ModelAndView oRet=null;
    ProductoDTO oProd=null;
    
            oRet = new ModelAndView("edproductos", "datos", oDat);
        
        return oRet;
    }
    
    @PostMapping("/guardaprod")
    public ModelAndView editar(
        @Valid @ModelAttribute("datos")BuscaDatosFrm oDat, 
	BindingResult oResultado, ModelMap oModeloVista){
    ModelAndView oRet=null;
    UsuariosDTO oNuevo;
    int nAfectados;
        if (oResultado.hasErrors()) {
            oModeloVista.addAttribute("textoError", 
                appContext.getMessage("error.captura", null, 
                        LocaleContextHolder.getLocale()));
            oRet = new ModelAndView("edproductos", "datos", oDat);
        }else{
            if (oDat.getTipoProd() == Papeleria.TIPO_PAPELERIA){
                oNuevo = new UsuarioDTO(oDat.getProdCapt1().getClave(),
                    oDat.getProdCapt1().getNombre(),oDat.getProdCapt1().getApellidop(),oDat.getProdCapt1().getApellidom(), 
                    oDat.getProdCapt1().getDireccion(),oDat.getProdCapt1().getTelefono(),oDat.getProdCapt1().getCorreo(),oDat.getProdCapt1().getContrasenia());
            }
            else{
                oNuevo = new UsuarioDTO(oDat.getProdCapt1().getClave(),
                    oDat.getProdCapt1().getNombre(),oDat.getProdCapt1().getApellidop(),oDat.getProdCapt1().getApellidom(), 
                    oDat.getProdCapt1().getDireccion(),
                    oDat.getProdCapt1().getTelefono(),oDat.getProdCapt1().getCorreo(),oDat.getProdCapt1().getContrasenia());
            }
            if (oDat.getOpeSelec().equals("a"))
                nAfectados = oServProd.insertar(oNuevo);
            else
                //nAfectados = oServProd.modificar(oNuevo);
                nAfectados = oServProd.insertar(oNuevo);
                
            if (nAfectados == 1){
                oDat.setListaProductos(null);
                oDat.setProdCapt(null);
                oRet = new ModelAndView("forward:/catprod", "datos", oDat);
            }else{
                oModeloVista.addAttribute("textoError", 
                    appContext.getMessage("error.guardar", null, 
                        LocaleContextHolder.getLocale()));
                oRet = new ModelAndView("edproductos", "datos", oDat);
            }
        }
        return oRet;
    }
}
