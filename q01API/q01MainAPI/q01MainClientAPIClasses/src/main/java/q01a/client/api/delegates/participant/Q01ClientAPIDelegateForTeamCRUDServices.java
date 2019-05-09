package q01a.client.api.delegates.participant;

import javax.inject.Provider;

import q01a.api.interfaces.participant.Q01CRUDServicesForTeam;
import q01a.client.api.delegates.Q01ClientAPIDelegateForPersistableModelObjectCRUDServicesBase;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;

public class Q01ClientAPIDelegateForTeamCRUDServices
	 extends Q01ClientAPIDelegateForPersistableModelObjectCRUDServicesBase<Q01TeamOID,Q01Team> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01ClientAPIDelegateForTeamCRUDServices(final Provider<SecurityContext> securityContextProvider,
												   final Marshaller modelObjectsMarshaller,
												   final Q01CRUDServicesForTeam crudServicesProxy) {
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  crudServicesProxy);
	}
}
