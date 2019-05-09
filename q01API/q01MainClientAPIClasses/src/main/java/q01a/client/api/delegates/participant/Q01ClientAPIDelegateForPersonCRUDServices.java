package q01a.client.api.delegates.participant;

import javax.inject.Provider;

import q01a.api.interfaces.participant.Q01CRUDServicesForPerson;
import q01a.client.api.delegates.Q01ClientAPIDelegateForPersistableModelObjectCRUDServicesBase;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;

public class Q01ClientAPIDelegateForPersonCRUDServices
	 extends Q01ClientAPIDelegateForPersistableModelObjectCRUDServicesBase<Q01PersonOID,Q01Person> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01ClientAPIDelegateForPersonCRUDServices(final Provider<SecurityContext> securityContextProvider,
												     final Marshaller modelObjectsMarshaller,
												     final Q01CRUDServicesForPerson crudServicesProxy) {
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  crudServicesProxy);
	}
}
