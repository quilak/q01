package q01c.services.delegates.participant;

import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import q01a.api.interfaces.participant.Q01FindServicesForPerson;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import q01c.db.participant.Q01DBFindForPerson;
import q01c.services.delegates.find.Q01FindServicesDelegateForPersistableModelObjectBase;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfigBuilder;

/**
 * Service layer delegated type for Find (Create/Read/Update/Delete) operations
 */
public class Q01FindServicesDelegateForPerson
	 extends Q01FindServicesDelegateForPersistableModelObjectBase<Q01PersonOID,Q01Person>
  implements Q01FindServicesForPerson {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01FindServicesDelegateForPerson(final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
											final Marshaller marshaller,
										    final EventBus eventBus,
										    final EntityManager entityManager) {
		super(coreCfg,
			  Q01Person.class,
			  new Q01DBFindForPerson(DBModuleConfigBuilder.dbModuleConfigFrom(coreCfg),
					  				 entityManager,
					  				 marshaller),
			  eventBus);
	}


}
