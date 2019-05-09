package q01c.services.delegates.participant;

import javax.persistence.EntityManager;

import com.google.common.eventbus.EventBus;

import q01a.api.interfaces.participant.Q01FindServicesForTeam;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import q01c.db.participant.Q01DBFindForTeam;
import q01c.services.delegates.find.Q01FindServicesDelegateForPersistableModelObjectBase;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfigBuilder;

/**
 * Service layer delegated type for Find (Create/Read/Update/Delete) operations
 */
public class Q01FindServicesDelegateForTeam
	 extends Q01FindServicesDelegateForPersistableModelObjectBase<Q01TeamOID,Q01Team>
  implements Q01FindServicesForTeam {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01FindServicesDelegateForTeam(final ServicesCoreBootstrapConfigWhenBeanExposed coreCfg,
										  final Marshaller marshaller,
										  final EventBus eventBus,
										  final EntityManager entityManager) {
		super(coreCfg,
			  Q01Team.class,
			  new Q01DBFindForTeam(DBModuleConfigBuilder.dbModuleConfigFrom(coreCfg),
					  			   entityManager,
					  			   marshaller),
			  eventBus);
	}


}
