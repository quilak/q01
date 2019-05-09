package q01c.db.location;

import javax.persistence.EntityManager;

import q01a.api.interfaces.location.Q01CRUDServicesForLocation;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import q01c.db.crud.Q01DBCRUDForPersistableModelObjectBase;
import q01c.db.dto.location.Q01LocationToDBEntityTransferDelegate;
import q01c.db.entities.main.Q01DBEntityForLocation;
import r01f.model.persistence.PersistencePerformedOperation;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.config.DBModuleConfig;
import r01f.securitycontext.SecurityContext;

/**
 * Persistence layer
 */
public class Q01DBCRUDForLocation
	 extends Q01DBCRUDForPersistableModelObjectBase<Q01LocationOID,Q01Location,
	 				   	   				 	   		Q01DBEntityForLocation>
  implements Q01CRUDServicesForLocation {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	private final Q01LocationToDBEntityTransferDelegate _transfersModelObjectToDBEntity = new Q01LocationToDBEntityTransferDelegate();

/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBCRUDForLocation(final DBModuleConfig dbCfg,
						 	    final EntityManager entityManager,
						 		final Marshaller marshaller) {
		super(Q01Location.class,Q01DBEntityForLocation.class,
			  dbCfg,
			  entityManager,
			  marshaller);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void setDBEntityFieldsFromModelObject(final SecurityContext securityContext,
												 final Q01Location modelObj,final Q01DBEntityForLocation dbEntity) {
		_transfersModelObjectToDBEntity.setDBEntityFieldsFromModelObject(securityContext,
																		 modelObj,dbEntity);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION METHODS
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void completeDBEntityBeforeCreateOrUpdate(final SecurityContext securityContext,
													 final PersistencePerformedOperation performedOp,
													 final Q01Location modelObj,final Q01DBEntityForLocation dbEntity) {
		// nothing now
	}
}
