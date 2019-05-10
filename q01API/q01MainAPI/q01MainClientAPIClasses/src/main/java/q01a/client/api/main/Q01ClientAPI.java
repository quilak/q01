package q01a.client.api.main;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Provider;

import com.google.inject.Inject;

import lombok.Getter;
import lombok.experimental.Accessors;
import q01a.api.interfaces.location.Q01CRUDServicesForLocation;
import q01a.api.interfaces.location.Q01FindServicesForLocation;
import q01a.api.interfaces.participant.Q01CRUDServicesForPerson;
import q01a.api.interfaces.participant.Q01CRUDServicesForTeam;
import q01a.api.interfaces.participant.Q01FindServicesForPerson;
import q01a.api.interfaces.participant.Q01FindServicesForTeam;
import q01a.client.api.delegates.location.Q01ClientAPIDelegateForLocationCRUDServices;
import q01a.client.api.delegates.location.Q01ClientAPIDelegateForLocationFindServices;
import q01a.client.api.delegates.participant.Q01ClientAPIDelegateForPersonCRUDServices;
import q01a.client.api.delegates.participant.Q01ClientAPIDelegateForPersonFindServices;
import q01a.client.api.delegates.participant.Q01ClientAPIDelegateForTeamCRUDServices;
import q01a.client.api.delegates.participant.Q01ClientAPIDelegateForTeamFindServices;
import q01a.common.internal.Q01AppCodes;
import r01f.model.annotations.ModelObjectsMarshaller;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;
import r01f.services.client.ClientAPIImplBase;
import r01f.services.client.ClientSubAPIBase;
import r01f.services.interfaces.ServiceInterface;



/**
 * Base type for every API implementation of appointments service.
 */
@Accessors(prefix="_")
public class Q01ClientAPI
     extends ClientAPIImplBase {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	@Inject @SuppressWarnings("rawtypes")
	public Q01ClientAPI(						final Provider<SecurityContext>  securityContextProvider,
						@ModelObjectsMarshaller final Marshaller modelObjectsMarshaller,
			@Named(Q01AppCodes.API_APPCODE_STR) final Map<Class,ServiceInterface> srvcIfaceMappings) {
		// Services proxy
		super(securityContextProvider,
			  modelObjectsMarshaller,
			  srvcIfaceMappings);

		// Build every sub-api
		_pesonAPI = new Q01ClientAPIForPerson(securityContextProvider,
											  modelObjectsMarshaller,
											  srvcIfaceMappings);
		_teamAPI = new Q01ClientAPIForTeam(securityContextProvider,
										   modelObjectsMarshaller,
										   srvcIfaceMappings);
		_locationAPI = new Q01ClientAPIForLocation(securityContextProvider,
												   modelObjectsMarshaller,
												   srvcIfaceMappings);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  PERSON SUB-API
/////////////////////////////////////////////////////////////////////////////////////////
	private Q01ClientAPIForPerson _pesonAPI;

	@Accessors(prefix="_")
	public class Q01ClientAPIForPerson
	     extends ClientSubAPIBase {

		@Getter private final Q01ClientAPIDelegateForPersonCRUDServices _forCRUD;
		@Getter private final Q01ClientAPIDelegateForPersonFindServices _forFind;

		@SuppressWarnings("rawtypes")
		public Q01ClientAPIForPerson(final Provider<SecurityContext> securityContextProvider,
									 final Marshaller modelObjectsMarshaller,
									 final Map<Class,ServiceInterface> srvcIfaceMappings) {
			super(securityContextProvider,
				  modelObjectsMarshaller,
				  srvcIfaceMappings);	// reference to other client apis

			_forCRUD = new Q01ClientAPIDelegateForPersonCRUDServices(securityContextProvider,
																	 this.getModelObjectsMarshaller(),
															 		 this.getServiceInterfaceCoreImplOrProxy(Q01CRUDServicesForPerson.class));
			_forFind = new Q01ClientAPIDelegateForPersonFindServices(securityContextProvider,
																	 this.getModelObjectsMarshaller(),
															 		 this.getServiceInterfaceCoreImplOrProxy(Q01FindServicesForPerson.class));
		}
	}
	public Q01ClientAPIForPerson personAPI() {
		return _pesonAPI;
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  TEAM SUB-API
/////////////////////////////////////////////////////////////////////////////////////////
	private Q01ClientAPIForTeam _teamAPI;

	@Accessors(prefix="_")
	public class Q01ClientAPIForTeam
	     extends ClientSubAPIBase {

		@Getter private final Q01ClientAPIDelegateForTeamCRUDServices _forCRUD;
		@Getter private final Q01ClientAPIDelegateForTeamFindServices _forFind;

		@SuppressWarnings("rawtypes")
		public Q01ClientAPIForTeam(final Provider<SecurityContext> securityContextProvider,
								   final Marshaller modelObjectsMarshaller,
								   final Map<Class,ServiceInterface> srvcIfaceMappings) {
			super(securityContextProvider,
				  modelObjectsMarshaller,
				  srvcIfaceMappings);	// reference to other client apis

			_forCRUD = new Q01ClientAPIDelegateForTeamCRUDServices(securityContextProvider,
																   this.getModelObjectsMarshaller(),
															 	   this.getServiceInterfaceCoreImplOrProxy(Q01CRUDServicesForTeam.class));
			_forFind = new Q01ClientAPIDelegateForTeamFindServices(securityContextProvider,
																   this.getModelObjectsMarshaller(),
															 	   this.getServiceInterfaceCoreImplOrProxy(Q01FindServicesForTeam.class));
		}
	}
	public Q01ClientAPIForTeam teamAPI() {
		return _teamAPI;
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  LOCATION SUB-API
/////////////////////////////////////////////////////////////////////////////////////////
	private Q01ClientAPIForLocation _locationAPI;

	@Accessors(prefix="_")
	public class Q01ClientAPIForLocation
	     extends ClientSubAPIBase {

		@Getter private final Q01ClientAPIDelegateForLocationCRUDServices _forCRUD;
		@Getter private final Q01ClientAPIDelegateForLocationFindServices _forFind;

		@SuppressWarnings("rawtypes")
		public Q01ClientAPIForLocation(final Provider<SecurityContext> securityContextProvider,
								   	   final Marshaller modelObjectsMarshaller,
								   	   final Map<Class,ServiceInterface> srvcIfaceMappings) {
			super(securityContextProvider,
				  modelObjectsMarshaller,
				  srvcIfaceMappings);	// reference to other client apis

			_forCRUD = new Q01ClientAPIDelegateForLocationCRUDServices(securityContextProvider,
																   	   this.getModelObjectsMarshaller(),
																   	   this.getServiceInterfaceCoreImplOrProxy(Q01CRUDServicesForLocation.class));
			_forFind = new Q01ClientAPIDelegateForLocationFindServices(securityContextProvider,
																   	   this.getModelObjectsMarshaller(),
																   	   this.getServiceInterfaceCoreImplOrProxy(Q01FindServicesForLocation.class));
		}
	}
	public Q01ClientAPIForLocation locationAPI() {
		return _locationAPI;
	}
}
