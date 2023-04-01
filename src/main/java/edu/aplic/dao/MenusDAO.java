/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.dao;

/**
 *
 * @author augus
 */
import edu.aplic.dto.MenusDTO;
import edu.aplic.jpa.model.Menus;
import edu.aplic.jpa.repositories.MenusIRep;
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
public class MenusDAO {
@Autowired
private MenusIRep oRepotem;

private static final Logger logger = LoggerFactory.getLogger(MenusDAO.class);
	
    public List<MenusDTO> buscarTodosPorTipo(int nTipo ){
    List<MenusDTO> listaRet=new ArrayList<>();
    MenusDTO oUso;
            Iterable<? extends Menus> arrParcial1;
            arrParcial1 = oRepotem.findAll();
            if (arrParcial1 != null){
                for(Menus p:arrParcial1){
                    oUso = new MenusDTO();
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
}