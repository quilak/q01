package q01c.db.participant;

import javax.persistence.EntityManager;

import q01a.api.interfaces.participant.Q01FindServicesForTeam;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import q01c.db.entities.main.Q01DBEntityForTeam;
import q01c.db.find.Q01DBFindForPersistableModelObjectBase;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfig;

/**
 * Persistence layer
 */
public class Q01DBFindForTeam
	 extends Q01DBFindForPersistableModelObjectBase<Q01TeamOID,Q01Team,
	 					   				 	   		Q01DBEntityForTeam>
  implements Q01FindServicesForTeam {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBFindForTeam(final DBModuleConfig dbCfg,
						    final EntityManager entityManager,
						    final Marshaller marshaller) {
		super(Q01Team.class,Q01DBEntityForTeam.class,
			  dbCfg,
			  entityManager,
			  marshaller);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////

}
