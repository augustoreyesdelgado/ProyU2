package edu.aplic.jpa.repositories;

import edu.aplic.jpa.model.Material;
import edu.aplic.jpa.model.UsoPersonal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author BAOZ
 */
public interface UsoPersonalIRep extends CrudRepository<UsoPersonal, Integer>{
    @Query(value = "SELECT p " +
            " FROM UsoPersonal p WHERE p.oMaterial.nCveMat = :par1 ")
    List<UsoPersonal> findAllByMaterial(@Param("par1") int oMat);
}
