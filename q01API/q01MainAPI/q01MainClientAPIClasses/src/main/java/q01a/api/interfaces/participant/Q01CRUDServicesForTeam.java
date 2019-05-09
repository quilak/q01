package q01a.api.interfaces.participant;

import q01a.api.interfaces.Q01ServiceInterface;
import q01a.api.interfaces.crud.Q01CRUDServicesForPersistableModelObjectBase;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import r01f.services.interfaces.ExposedServiceInterface;

@ExposedServiceInterface
public interface Q01CRUDServicesForTeam
         extends Q01CRUDServicesForPersistableModelObjectBase<Q01TeamOID,Q01Team>,
         		 Q01ServiceInterface {
	// nothing specific
}