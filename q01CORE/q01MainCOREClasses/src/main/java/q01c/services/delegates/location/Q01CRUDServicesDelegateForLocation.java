package q01c.services.delegates.location;

import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import q01a.api.interfaces.location.Q01CRUDServicesForLocation;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import q01c.db.location.Q01DBCRUDForLocation;
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
public class Q01CRUDServicesDelegateForLocation
	 extends Q01CRUDServicesDelegateForPersistableObjectBase<Q01LocationOID,Q01Location>
  implements Q01CRUDServicesForLocation {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01CRUDServicesDelegateForLocation(final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
											  final Marshaller marshaller,
										      final EventBus eventBus,
										      final EntityManager entityManager) {
		super(coreCfg,
			  Q01Location.class,
			  new Q01DBCRUDForLocation(DBModuleConfigBuilder.dbModuleConfigFrom(coreCfg),
					  				   entityManager,
					  				   marshaller),
			  eventBus);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  PARAMS VALIDATION ON CREATION / UPDATE
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public ObjectValidationResult<Q01Location> validateModelObjBeforeCreateOrUpdate(final SecurityContext securityContext,
																	 	  		    final PersistenceRequestedOperation requestedOp,
																	 	  		    final Q01Location modelObj) {
		// [1]: Do base validations
		ObjectValidationResult<Q01Location> outValid = super.validateModelObjBeforeCreateOrUpdate(securityContext,
															 			  		       			  requestedOp,
															 			  		       			  modelObj);
		// [2]: Ensure the location exists
		if (outValid.isValid()) {
			// ...
		}
		return outValid;
	}

}
