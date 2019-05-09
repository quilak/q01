package q01c.services.impl.location;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import lombok.Getter;
import lombok.experimental.Accessors;
import q01a.api.interfaces.location.Q01FindServicesForLocation;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import q01c.services.delegates.location.Q01FindServicesDelegateForLocation;
import q01c.services.impl.Q01CoreServiceImpl;
import q01c.services.impl.find.Q01FindServicesForPersistableModelObjectImplBase;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.model.annotations.ModelObjectsMarshaller;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;
import r01f.services.persistence.ServiceDelegateProvider;

/**
 * Implements the persistence-related services which in turn are
 * delegated to {@link Q01FindServicesDelegateForLocations}
 */
@Singleton
@Accessors(prefix="_")
public class Q01FindServicesImplForLocation
     extends Q01FindServicesForPersistableModelObjectImplBase<Q01LocationOID,Q01Location>
  implements Q01FindServicesForLocation,
  			 Q01CoreServiceImpl {

/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////
//	DELEGATE PROVIDER: called at every services impl method to create a fresh new 
//					   EntityManager and avoid transactional issues
/////////////////////////////////////////////////////////////////////////////////////////
	@Getter private final ServiceDelegateProvider<Q01FindServicesForLocation> _delegateProvider =
								new ServiceDelegateProvider<Q01FindServicesForLocation>() {
											@Override
											public Q01FindServicesForLocation createDelegate(final SecurityContext securityContext) {
												return new Q01FindServicesDelegateForLocation(_coreConfig,
																							  _modelObjectsMarshaller,
																							  _eventBus,
																							  Q01FindServicesImplForLocation.this.getFreshNewEntityManager(securityContext));
											}
									};
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	@Inject
	public Q01FindServicesImplForLocation(						  final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
									   	  @ModelObjectsMarshaller final Marshaller modelObjectsMarshaller,
									   		  					  final EventBus eventBus,
									   		  					  final Provider<EntityManager> entityManagerProvider) {
		super(coreCfg,
			  modelObjectsMarshaller,
			  eventBus,
			  entityManagerProvider);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//	SERVICES EXTENSION
// 	IMPORTANT!!! Do NOT put any logic in these methods ONLY DELEGATE!!!
/////////////////////////////////////////////////////////////////////////////////////////
}
