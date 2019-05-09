package q01c.services.delegates.participant;

import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import q01a.api.interfaces.participant.Q01CRUDServicesForTeam;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import q01c.db.participant.Q01DBCRUDForTeam;
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
public class Q01CRUDServicesDelegateForTeam
	 extends Q01CRUDServicesDelegateForPersistableObjectBase<Q01TeamOID,Q01Team>
  implements Q01CRUDServicesForTeam {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01CRUDServicesDelegateForTeam(final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
										  final Marshaller marshaller,
										  final EventBus eventBus,
										  final EntityManager entityManager) {
		super(coreCfg,
			  Q01Team.class,
			  new Q01DBCRUDForTeam(DBModuleConfigBuilder.dbModuleConfigFrom(coreCfg),
					  			   entityManager,
					  			   marshaller),
			  eventBus);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  PARAMS VALIDATION ON CREATION / UPDATE
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public ObjectValidationResult<Q01Team> validateModelObjBeforeCreateOrUpdate(final SecurityContext securityContext,
																	 	  		final PersistenceRequestedOperation requestedOp,
																	 	  		final Q01Team modelObj) {
		// [1]: Do base validations
		ObjectValidationResult<Q01Team> outValid = super.validateModelObjBeforeCreateOrUpdate(securityContext,
															 			  		       		  requestedOp,
															 			  		       		  modelObj);
		// [2]: Ensure the location exists
		if (outValid.isValid()) {
			// ...
		}
		return outValid;
	}

}
