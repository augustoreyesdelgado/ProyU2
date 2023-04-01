/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.jpa.repositories;

import edu.aplic.jpa.model.Menus;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author augus
 */
public interface MenusIRep extends CrudRepository<Menus, Integer>{
	@Query(value = "SELECT p " +
            " FROM Menus p",
                nativeQuery=true)
    List<Menus> findAllByMaterial(@Param("par1") int oMat);
}