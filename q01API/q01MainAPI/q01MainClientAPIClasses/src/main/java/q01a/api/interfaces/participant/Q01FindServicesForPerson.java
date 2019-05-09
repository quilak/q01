package q01a.api.interfaces.participant;

import q01a.api.interfaces.Q01ServiceInterface;
import q01a.api.interfaces.find.Q01FindServicesForPersistableModelObjectBase;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import r01f.services.interfaces.ExposedServiceInterface;

@ExposedServiceInterface
public interface Q01FindServicesForPerson
         extends Q01FindServicesForPersistableModelObjectBase<Q01PersonOID,Q01Person>,
         		 Q01ServiceInterface {
	// nothing specific
}