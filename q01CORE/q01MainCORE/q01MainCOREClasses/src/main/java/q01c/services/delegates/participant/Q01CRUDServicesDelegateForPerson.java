package q01c.services.delegates.participant;

import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import q01a.api.interfaces.participant.Q01CRUDServicesForPerson;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import q01c.db.participant.Q01DBCRUDForPerson;
import q01c.services.delegates.crud.Q01CRUDServicesDelegateForPersistableObjectBase;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.model.persistence.PersistenceRequestedOperation;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfigBuilder;
import r01f.securitycontext.SecurityContext;
import r01f.validation.ObjectValidationResult;

/**
 * Service layer delegated type for CRUD (Create/Read/Update/Delete) operations
 */
public class Q01CRUDServicesDelegateForPerson
	 extends Q01CRUDServicesDelegateForPersistableObjectBase<Q01PersonOID,Q01Person>
  implements Q01CRUDServicesForPerson {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01CRUDServicesDelegateForPerson(final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
											final Marshaller marshaller,
										    final EventBus eventBus,
										    final EntityManager entityManager) {
		super(coreCfg,
			  Q01Person.class,
			  new Q01DBCRUDForPerson(DBModuleConfigBuilder.dbModuleConfigFrom(coreCfg),
					  				 entityManager,
					  				 marshaller),
			  eventBus);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  PARAMS VALIDATION ON CREATION / UPDATE
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public ObjectValidationResult<Q01Person> validateModelObjBeforeCreateOrUpdate(final SecurityContext securityContext,
																	 	  		  final PersistenceRequestedOperation requestedOp,
																	 	  		  final Q01Person modelObj) {
		// [1]: Do base validations
		ObjectValidationResult<Q01Person> outValid = super.validateModelObjBeforeCreateOrUpdate(securityContext,
															 			  		       			requestedOp,
															 			  		       			modelObj);
		// [2]: Ensure the location exists
		if (outValid.isValid()) {
			// ...
		}
		return outValid;
	}

}
