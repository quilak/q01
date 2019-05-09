package q01a.client.api.delegates.location;

import javax.inject.Provider;

import q01a.api.interfaces.location.Q01FindServicesForLocation;
import q01a.client.api.delegates.Q01ClientAPIDelegateForPersistableModelObjectFindServicesBase;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;

public class Q01ClientAPIDelegateForLocationFindServices
	 extends Q01ClientAPIDelegateForPersistableModelObjectFindServicesBase<Q01LocationOID,Q01Location> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01ClientAPIDelegateForLocationFindServices(final Provider<SecurityContext> securityContextProvider,
												       final Marshaller modelObjectsMarshaller,
												       final Q01FindServicesForLocation crudServicesProxy) {
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  crudServicesProxy);
	}
}
