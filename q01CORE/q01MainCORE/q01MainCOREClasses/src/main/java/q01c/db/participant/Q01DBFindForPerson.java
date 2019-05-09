package q01c.db.participant;

import javax.persistence.EntityManager;

import q01a.api.interfaces.participant.Q01FindServicesForPerson;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import q01c.db.entities.main.Q01DBEntityForPerson;
import q01c.db.find.Q01DBFindForPersistableModelObjectBase;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfig;

/**
 * Persistence layer
 */
public class Q01DBFindForPerson
	 extends Q01DBFindForPersistableModelObjectBase<Q01PersonOID,Q01Person,
	 					   				 	   		Q01DBEntityForPerson>
  implements Q01FindServicesForPerson {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBFindForPerson(final DBModuleConfig dbCfg,
						 	  final EntityManager entityManager,
						 	  final Marshaller marshaller) {
		super(Q01Person.class,Q01DBEntityForPerson.class,
			  dbCfg,
			  entityManager,
			  marshaller);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////

}
