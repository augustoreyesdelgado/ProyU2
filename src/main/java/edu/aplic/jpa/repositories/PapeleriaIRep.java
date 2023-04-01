package edu.aplic.jpa.repositories;

import edu.aplic.jpa.model.Papeleria;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author BAOZ
 */
public interface PapeleriaIRep extends CrudRepository<Papeleria, Integer>{
	@Query(value = "SELECT t1.nCveProd, t1.sNombre, t1.sDescripcion, " +
            " t1.nPrecio, t1.sImagen, t1.nCveMat, t1.nPresentacion " +
            " FROM producto t1 WHERE t1.nTipoProd=1 AND t1.nCveMat = :par1 ",
                nativeQuery=true)
    List<Papeleria> findAllByMaterial(@Param("par1") int oMat);
}
