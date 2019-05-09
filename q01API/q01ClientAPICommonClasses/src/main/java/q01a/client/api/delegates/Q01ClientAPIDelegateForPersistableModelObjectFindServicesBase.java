package q01a.client.api.delegates;

import javax.inject.Provider;

import q01a.api.interfaces.find.Q01FindServicesForPersistableModelObjectBase;
import q01f.common.model.Q01PersistableObject;
import q01f.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;
import r01f.services.client.api.delegates.ClientAPIDelegateForModelObjectFindServices;

public class Q01ClientAPIDelegateForPersistableModelObjectFindServicesBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>>
	 extends ClientAPIDelegateForModelObjectFindServices<O,M> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public <FIND extends Q01FindServicesForPersistableModelObjectBase<O,M>> Q01ClientAPIDelegateForPersistableModelObjectFindServicesBase(final Provider<SecurityContext> securityContextProvider,
												   											  						   					  final Marshaller modelObjectsMarshaller,
												   											  						   					  final FIND crudServicesProxy) {
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  crudServicesProxy);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////
}
