package q01c.services.impl.crud;

import javax.inject.Provider;
import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import lombok.experimental.Accessors;
import q01a.api.interfaces.crud.Q01CRUDServicesForPersistableModelObjectBase;
import q01f.common.model.Q01PersistableObject;
import q01f.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.objectstreamer.Marshaller;
import r01f.services.persistence.CoreCRUDServicesForModelObjectBase;

@Accessors(prefix="_")
public abstract class Q01CRUDServicesForPersistableModelObjectImplBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>>
 	   		  extends CoreCRUDServicesForModelObjectBase<O,M>
    	   implements Q01CRUDServicesForPersistableModelObjectBase<O,M> {
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01CRUDServicesForPersistableModelObjectImplBase(final ServicesCoreBootstrapConfigWhenBeanExposed cfg,
									   		  				final Marshaller modelObjectsMarshaller,
									   		  				final EventBus eventBus,
									   		  				final Provider<EntityManager> entityManagerProvider) {
		super(cfg,
			  modelObjectsMarshaller,
			  eventBus,
			  entityManagerProvider);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//	SERVICES EXTENSION
// 	IMPORTANT!!! Do NOT put any logic in these methods ONLY DELEGATE!!!
/////////////////////////////////////////////////////////////////////////////////////////

}
