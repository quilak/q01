package q01c.services.delegates.crud;

import com.google.common.eventbus.EventBus;

import q01a.api.interfaces.crud.Q01CRUDServicesForPersistableModelObjectBase;
import q01f.common.model.Q01PersistableObject;
import q01f.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.model.persistence.PersistenceRequestedOperation;
import r01f.persistence.db.DBCRUDForModelObject;
import r01f.securitycontext.SecurityContext;
import r01f.services.delegates.persistence.CRUDServicesForModelObjectDelegateBase;
import r01f.services.delegates.persistence.CompletesModelObjectBeforeCreateOrUpdate;
import r01f.services.delegates.persistence.ValidatesModelObjectBeforeCreateOrUpdate;
import r01f.validation.ObjectValidationResult;
import r01f.validation.ObjectValidationResultBuilder;
import r01f.validation.SelfValidates;

/**
 * Service layer delegated type for CRUD (Create/Read/Update/Delete) operations
 */
public abstract class Q01CRUDServicesDelegateForPersistableObjectBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>>
	   		  extends CRUDServicesForModelObjectDelegateBase<O,M>
    	   implements Q01CRUDServicesForPersistableModelObjectBase<O,M>,
    	   			  ValidatesModelObjectBeforeCreateOrUpdate<M>,
    	   			  CompletesModelObjectBeforeCreateOrUpdate<M> {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01CRUDServicesDelegateForPersistableObjectBase(final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
												  		   final Class<M> modelObjectType,
												  		   final DBCRUDForModelObject<O,M> dbCrud,
												  		   final EventBus eventBus) {
		super(coreCfg,
			  modelObjectType,
			  dbCrud,
			  eventBus);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
//  PARAMS VALIDATION ON CREATION / UPDATE
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public M completeModelObjBeforeCreateOrUpdate(final SecurityContext securityContext, 
												  final PersistenceRequestedOperation requestedOp,
												  final M modelObj) {
		return modelObj;
	}
	@Override @SuppressWarnings("unchecked")
	public ObjectValidationResult<M> validateModelObjBeforeCreateOrUpdate(final SecurityContext securityContext,
																	 	  final PersistenceRequestedOperation requestedOp,
																	 	  final M entity) {
		ObjectValidationResult<M> outValid = null;

		// if the model object self-validates...
		if (entity instanceof SelfValidates) {
			outValid = ((SelfValidates<M>)entity).validate();
		}
		// no errors... it's valid
		if (outValid == null) {
			outValid = ObjectValidationResultBuilder.on(entity)
						   						 	.isValid();
		}
		return outValid;
	}
}
