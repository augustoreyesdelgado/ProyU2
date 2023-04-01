/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.jpa.repositories;

import edu.aplic.jpa.model.Temas;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author augus
 */
public interface TemasIRep extends CrudRepository<Temas, Integer>{
	@Query(value = "SELECT p " +
            " FROM Tema p",
                nativeQuery=true)
    List<Temas> findAllByMaterial(@Param("par1") int oMat);
}