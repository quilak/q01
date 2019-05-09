package q01a.api.interfaces.crud;

import q01a.api.interfaces.Q01ServiceInterface;
import q01f.common.model.Q01PersistableObject;
import q01f.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.services.interfaces.CRUDServicesForModelObject;

public interface Q01CRUDServicesForPersistableModelObjectBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>>
         extends CRUDServicesForModelObject<O,M>,
         		 Q01ServiceInterface {
	// nothing specific
}