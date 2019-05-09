package q01c.db.participant;

import javax.persistence.EntityManager;

import q01a.api.interfaces.participant.Q01CRUDServicesForTeam;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import q01c.db.crud.Q01DBCRUDForPersistableModelObjectBase;
import q01c.db.dto.participant.Q01TeamToDBEntityTransferDelegate;
import q01c.db.entities.main.Q01DBEntityForTeam;
import r01f.model.persistence.PersistencePerformedOperation;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfig;
import r01f.securitycontext.SecurityContext;

/**
 * Persistence layer
 */
public class Q01DBCRUDForTeam
	 extends Q01DBCRUDForPersistableModelObjectBase<Q01TeamOID,Q01Team,
	 				   	   				 	   		Q01DBEntityForTeam>
  implements Q01CRUDServicesForTeam {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	private final Q01TeamToDBEntityTransferDelegate _transfersModelObjectToDBEntity = new Q01TeamToDBEntityTransferDelegate();

/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBCRUDForTeam(final DBModuleConfig dbCfg,
						    final EntityManager entityManager,
						 	final Marshaller marshaller) {
		super(Q01Team.class,Q01DBEntityForTeam.class,
			  dbCfg,
			  entityManager,
			  marshaller);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void setDBEntityFieldsFromModelObject(final SecurityContext securityContext,
												 final Q01Team modelObj,final Q01DBEntityForTeam dbEntity) {
		_transfersModelObjectToDBEntity.setDBEntityFieldsFromModelObject(securityContext,
																		 modelObj,dbEntity);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void completeDBEntityBeforeCreateOrUpdate(final SecurityContext securityContext,
													 final PersistencePerformedOperation performedOp,
													 final Q01Team modelObj,final Q01DBEntityForTeam dbEntity) {
		// nothing now
	}
}
