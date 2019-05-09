package q01a.client.api.delegates.participant;

import javax.inject.Provider;

import q01a.api.interfaces.participant.Q01FindServicesForTeam;
import q01a.client.api.delegates.Q01ClientAPIDelegateForPersistableModelObjectFindServicesBase;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;

public class Q01ClientAPIDelegateForTeamFindServices
	 extends Q01ClientAPIDelegateForPersistableModelObjectFindServicesBase<Q01TeamOID,Q01Team> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01ClientAPIDelegateForTeamFindServices(final Provider<SecurityContext> securityContextProvider,
												   final Marshaller modelObjectsMarshaller,
												   final Q01FindServicesForTeam crudServicesProxy) {
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  crudServicesProxy);
	}
}
