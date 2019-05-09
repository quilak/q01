package q01a.client.api.delegates.participant;

import javax.inject.Provider;

import q01a.api.interfaces.participant.Q01FindServicesForPerson;
import q01a.client.api.delegates.Q01ClientAPIDelegateForPersistableModelObjectFindServicesBase;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;

public class Q01ClientAPIDelegateForPersonFindServices
	 extends Q01ClientAPIDelegateForPersistableModelObjectFindServicesBase<Q01PersonOID,Q01Person> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01ClientAPIDelegateForPersonFindServices(final Provider<SecurityContext> securityContextProvider,
												     final Marshaller modelObjectsMarshaller,
												     final Q01FindServicesForPerson crudServicesProxy) {
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  crudServicesProxy);
	}
}
