package q01a.api.interfaces.participant;

import q01a.api.interfaces.Q01ServiceInterface;
import q01a.api.interfaces.crud.Q01CRUDServicesForPersistableModelObjectBase;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import r01f.services.interfaces.ExposedServiceInterface;

@ExposedServiceInterface
public interface Q01CRUDServicesForPerson
         extends Q01CRUDServicesForPersistableModelObjectBase<Q01PersonOID,Q01Person>,
         		 Q01ServiceInterface {
	// nothing specific
}