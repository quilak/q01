package q01c.services.delegates.location;

import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import q01a.api.interfaces.location.Q01FindServicesForLocation;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import q01c.db.location.Q01DBFindForLocation;
import q01c.services.delegates.find.Q01FindServicesDelegateForPersistableModelObjectBase;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfigBuilder;

/**
 * Service layer delegated type for Find (Create/Read/Update/Delete) operations
 */
public class Q01FindServicesDelegateForLocation
	 extends Q01FindServicesDelegateForPersistableModelObjectBase<Q01LocationOID,Q01Location>
  implements Q01FindServicesForLocation {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01FindServicesDelegateForLocation(final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
											  final Marshaller marshaller,
										      final EventBus eventBus,
										      final EntityManager entityManager) {
		super(coreCfg,
			  Q01Location.class,
			  new Q01DBFindForLocation(DBModuleConfigBuilder.dbModuleConfigFrom(coreCfg),
					  				   entityManager,
					  				   marshaller),
			  eventBus);
	}


}
