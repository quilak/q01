package q01c.services.delegates.find;

import com.google.common.eventbus.EventBus;

import q01a.api.interfaces.find.Q01FindServicesForPersistableModelObjectBase;
import q01f.common.model.Q01PersistableObject;
import q01f.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.persistence.db.DBFindForModelObject;
import r01f.services.delegates.persistence.FindServicesForModelObjectDelegateBase;

/**
 * Service layer delegated type for Find (Create/Read/Update/Delete) operations
 */
public abstract class Q01FindServicesDelegateForPersistableModelObjectBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>>
	          extends FindServicesForModelObjectDelegateBase<O,M>
    	   implements Q01FindServicesForPersistableModelObjectBase<O,M> {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01FindServicesDelegateForPersistableModelObjectBase(final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
												  				final Class<M> modelObjectType,
												  				final DBFindForModelObject<O,M> findServices,
												  				final EventBus eventBus) {
		super(coreCfg,
			  modelObjectType,
			  findServices,
			  eventBus);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////

}
