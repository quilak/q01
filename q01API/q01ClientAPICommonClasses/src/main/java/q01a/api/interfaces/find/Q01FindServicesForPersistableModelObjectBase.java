package q01a.api.interfaces.find;

import q01a.api.interfaces.Q01ServiceInterface;
import q01a.common.model.Q01PersistableObject;
import q01a.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.services.interfaces.FindServicesForModelObject;

public interface Q01FindServicesForPersistableModelObjectBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>>
         extends FindServicesForModelObject<O,M>,
         		 Q01ServiceInterface {
	// nothing specific
}