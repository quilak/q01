package q01a.client.api.delegates;

import javax.inject.Provider;

import q01a.api.interfaces.crud.Q01CRUDServicesForPersistableModelObjectBase;
import q01f.common.model.Q01PersistableObject;
import q01f.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;
import r01f.services.client.api.delegates.ClientAPIDelegateForModelObjectCRUDServices;

public class Q01ClientAPIDelegateForPersistableModelObjectCRUDServicesBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>>
	 extends ClientAPIDelegateForModelObjectCRUDServices<O,M> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public <CRUD extends Q01CRUDServicesForPersistableModelObjectBase<O,M>> Q01ClientAPIDelegateForPersistableModelObjectCRUDServicesBase(final Provider<SecurityContext> securityContextProvider,
												   											  						   					  final Marshaller modelObjectsMarshaller,
												   											  						   					  final CRUD crudServicesProxy) {
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  crudServicesProxy);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////
}
