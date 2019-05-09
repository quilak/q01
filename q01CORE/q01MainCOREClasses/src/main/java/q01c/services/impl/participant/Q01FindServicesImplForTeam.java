package q01c.services.impl.participant;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import lombok.Getter;
import lombok.experimental.Accessors;
import q01a.api.interfaces.participant.Q01FindServicesForTeam;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import q01c.services.delegates.participant.Q01FindServicesDelegateForTeam;
import q01c.services.impl.Q01CoreServiceImpl;
import q01c.services.impl.find.Q01FindServicesForPersistableModelObjectImplBase;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.model.annotations.ModelObjectsMarshaller;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;
import r01f.services.persistence.ServiceDelegateProvider;

/**
 * Implements the persistence-related services which in turn are
 * delegated to {@link Q01FindServicesDelegateForTeam}
 */
@Singleton
@Accessors(prefix="_")
public class Q01FindServicesImplForTeam
     extends Q01FindServicesForPersistableModelObjectImplBase<Q01TeamOID,Q01Team>
  implements Q01FindServicesForTeam,
  			 Q01CoreServiceImpl {

/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////
//	DELEGATE PROVIDER: called at every services impl method to create a fresh new 
//					   EntityManager and avoid transactional issues
/////////////////////////////////////////////////////////////////////////////////////////
	@Getter private final ServiceDelegateProvider<Q01FindServicesForTeam> _delegateProvider =
								new ServiceDelegateProvider<Q01FindServicesForTeam>() {
											@Override
											public Q01FindServicesForTeam createDelegate(final SecurityContext securityContext) {
												return new Q01FindServicesDelegateForTeam(_coreConfig,
																						  _modelObjectsMarshaller,
																						  _eventBus,
																						  Q01FindServicesImplForTeam.this.getFreshNewEntityManager(securityContext));
											}
									};
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	@Inject
	public Q01FindServicesImplForTeam(						  final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
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
