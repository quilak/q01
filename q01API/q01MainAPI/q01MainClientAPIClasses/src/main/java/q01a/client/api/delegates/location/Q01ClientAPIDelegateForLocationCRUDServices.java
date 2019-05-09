package q01a.client.api.delegates.location;

import javax.inject.Provider;

import q01a.api.interfaces.location.Q01CRUDServicesForLocation;
import q01a.client.api.delegates.Q01ClientAPIDelegateForPersistableModelObjectCRUDServicesBase;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;

public class Q01ClientAPIDelegateForLocationCRUDServices
	 extends Q01ClientAPIDelegateForPersistableModelObjectCRUDServicesBase<Q01LocationOID,Q01Location> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01ClientAPIDelegateForLocationCRUDServices(final Provider<SecurityContext> securityContextProvider,
												       final Marshaller modelObjectsMarshaller,
												       final Q01CRUDServicesForLocation crudServicesProxy) {
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  crudServicesProxy);
	}
}
