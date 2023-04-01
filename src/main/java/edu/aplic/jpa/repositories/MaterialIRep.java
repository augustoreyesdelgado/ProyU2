package edu.aplic.jpa.repositories;

import edu.aplic.jpa.model.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que Spring utiliza para trabajar el CRUD de Material
 * @author BAOZ
 */
@Repository
public interface MaterialIRep extends CrudRepository<Material, Integer>{
}
