package q01c.db.location;

import javax.persistence.EntityManager;

import q01a.api.interfaces.location.Q01FindServicesForLocation;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import q01c.db.entities.main.Q01DBEntityForLocation;
import q01c.db.find.Q01DBFindForPersistableModelObjectBase;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfig;

/**
 * Persistence layer
 */
public class Q01DBFindForLocation
	 extends Q01DBFindForPersistableModelObjectBase<Q01LocationOID,Q01Location,
	 					   				 	   		Q01DBEntityForLocation>
  implements Q01FindServicesForLocation {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBFindForLocation(final DBModuleConfig dbCfg,
						 	    final EntityManager entityManager,
						 		final Marshaller marshaller) {
		super(Q01Location.class,Q01DBEntityForLocation.class,
			  dbCfg,
			  entityManager,
			  marshaller);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////

}
