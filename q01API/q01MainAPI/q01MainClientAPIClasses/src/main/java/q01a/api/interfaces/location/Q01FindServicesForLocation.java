package q01a.api.interfaces.location;

import q01a.api.interfaces.Q01ServiceInterface;
import q01a.api.interfaces.find.Q01FindServicesForPersistableModelObjectBase;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import r01f.services.interfaces.ExposedServiceInterface;

@ExposedServiceInterface
public interface Q01FindServicesForLocation
         extends Q01FindServicesForPersistableModelObjectBase<Q01LocationOID,Q01Location>,
         		 Q01ServiceInterface {
	// nothing specific
}