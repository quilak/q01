package q01c.services.impl.find;

import javax.inject.Provider;
import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import lombok.experimental.Accessors;
import q01a.api.interfaces.find.Q01FindServicesForPersistableModelObjectBase;
import q01a.common.model.Q01PersistableObject;
import q01a.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.objectstreamer.Marshaller;
import r01f.services.persistence.CoreFindServicesForModelObjectBase;

@Accessors(prefix="_")
public abstract class Q01FindServicesForPersistableModelObjectImplBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>>
 	   		  extends CoreFindServicesForModelObjectBase<O,M>
    	   implements Q01FindServicesForPersistableModelObjectBase<O,M> {
/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01FindServicesForPersistableModelObjectImplBase(final ServicesCoreBootstrapConfigWhenBeanExposed cfg,
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
