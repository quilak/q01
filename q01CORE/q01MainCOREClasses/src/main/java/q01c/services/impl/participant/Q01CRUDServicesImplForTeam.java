package q01c.services.impl.participant;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import lombok.Getter;
import lombok.experimental.Accessors;
import q01a.api.interfaces.participant.Q01CRUDServicesForTeam;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import q01c.services.delegates.participant.Q01CRUDServicesDelegateForTeam;
import q01c.services.impl.Q01CoreServiceImpl;
import q01c.services.impl.crud.Q01CRUDServicesForPersistableModelObjectImplBase;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.model.annotations.ModelObjectsMarshaller;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;
import r01f.services.persistence.ServiceDelegateProvider;

/**
 * Implements the persistence-related services which in turn are
 * delegated to {@link Q01CRUDServicesDelegateForTeam}
 */
@Singleton
@Accessors(prefix="_")
public class Q01CRUDServicesImplForTeam
     extends Q01CRUDServicesForPersistableModelObjectImplBase<Q01TeamOID,Q01Team>
  implements Q01CRUDServicesForTeam,
  			 Q01CoreServiceImpl {

/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////
//	DELEGATE PROVIDER: called at every services impl method to create a fresh new 
//					   EntityManager and avoid transactional issues
/////////////////////////////////////////////////////////////////////////////////////////
	@Getter private final ServiceDelegateProvider<Q01CRUDServicesForTeam> _delegateProvider =
								new ServiceDelegateProvider<Q01CRUDServicesForTeam>() {
											@Override
											public Q01CRUDServicesForTeam createDelegate(final SecurityContext securityContext) {
												return new Q01CRUDServicesDelegateForTeam(_coreConfig,
																						  _modelObjectsMarshaller,
																						  _eventBus,
																						  Q01CRUDServicesImplForTeam.this.getFreshNewEntityManager(securityContext));
											}
									};
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	@Inject
	public Q01CRUDServicesImplForTeam(						  final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
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
