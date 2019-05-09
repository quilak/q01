package q01c.services.impl.participant;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import lombok.Getter;
import lombok.experimental.Accessors;
import q01a.api.interfaces.participant.Q01CRUDServicesForPerson;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import q01c.services.delegates.participant.Q01CRUDServicesDelegateForPerson;
import q01c.services.impl.Q01CoreServiceImpl;
import q01c.services.impl.crud.Q01CRUDServicesForPersistableModelObjectImplBase;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.model.annotations.ModelObjectsMarshaller;
import r01f.objectstreamer.Marshaller;
import r01f.securitycontext.SecurityContext;
import r01f.services.persistence.ServiceDelegateProvider;

/**
 * Implements the persistence-related services which in turn are
 * delegated to {@link Q01CRUDServicesDelegateForPerson}
 */
@Singleton
@Accessors(prefix="_")
public class Q01CRUDServicesImplForPerson
     extends Q01CRUDServicesForPersistableModelObjectImplBase<Q01PersonOID,Q01Person>
  implements Q01CRUDServicesForPerson,
  			 Q01CoreServiceImpl {

/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////
//	DELEGATE PROVIDER: called at every services impl method to create a fresh new 
//					   EntityManager and avoid transactional issues
/////////////////////////////////////////////////////////////////////////////////////////
	@Getter private final ServiceDelegateProvider<Q01CRUDServicesForPerson> _delegateProvider =
								new ServiceDelegateProvider<Q01CRUDServicesForPerson>() {
											@Override
											public Q01CRUDServicesForPerson createDelegate(final SecurityContext securityContext) {
												return new Q01CRUDServicesDelegateForPerson(_coreConfig,
																							_modelObjectsMarshaller,
																							_eventBus,
																							Q01CRUDServicesImplForPerson.this.getFreshNewEntityManager(securityContext));
											}
									};
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	@Inject
	public Q01CRUDServicesImplForPerson(						final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
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
