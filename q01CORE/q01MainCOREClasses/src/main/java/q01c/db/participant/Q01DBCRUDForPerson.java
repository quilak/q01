package q01c.db.participant;

import javax.persistence.EntityManager;

import q01a.api.interfaces.participant.Q01CRUDServicesForPerson;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import q01c.db.crud.Q01DBCRUDForPersistableModelObjectBase;
import q01c.db.dto.participant.Q01PersonToDBEntityTransferDelegate;
import q01c.db.entities.main.Q01DBEntityForPerson;
import r01f.model.persistence.PersistencePerformedOperation;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfig;
import r01f.securitycontext.SecurityContext;

/**
 * Persistence layer
 */
public class Q01DBCRUDForPerson
	 extends Q01DBCRUDForPersistableModelObjectBase<Q01PersonOID,Q01Person,
	 				   	   				 	   		Q01DBEntityForPerson>
  implements Q01CRUDServicesForPerson {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	private final Q01PersonToDBEntityTransferDelegate _transfersModelObjectToDBEntity = new Q01PersonToDBEntityTransferDelegate();

/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBCRUDForPerson(final DBModuleConfig dbCfg,
						 	  final EntityManager entityManager,
						 	  final Marshaller marshaller) {
		super(Q01Person.class,Q01DBEntityForPerson.class,
			  dbCfg,
			  entityManager,
			  marshaller);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void setDBEntityFieldsFromModelObject(final SecurityContext securityContext,
												 final Q01Person modelObj,final Q01DBEntityForPerson dbEntity) {
		_transfersModelObjectToDBEntity.setDBEntityFieldsFromModelObject(securityContext,
																		 modelObj,dbEntity);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void completeDBEntityBeforeCreateOrUpdate(final SecurityContext securityContext,
													 final PersistencePerformedOperation performedOp,
													 final Q01Person modelObj,final Q01DBEntityForPerson dbEntity) {
		// nothing now
	}
}
