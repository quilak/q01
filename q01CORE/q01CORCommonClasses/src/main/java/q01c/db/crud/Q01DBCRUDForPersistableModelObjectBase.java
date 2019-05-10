package q01c.db.crud;

import javax.persistence.EntityManager;

import q01a.api.interfaces.crud.Q01CRUDServicesForPersistableModelObjectBase;
import q01a.common.model.Q01PersistableObject;
import q01a.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import q01c.db.entities.Q01DBEntityBase;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.CompletesDBEntityBeforeCreateOrUpdate;
import r01f.persistence.db.DBCRUDForModelObjectBase;
import r01f.persistence.db.config.DBModuleConfig;
import r01f.persistence.db.entities.primarykeys.DBPrimaryKeyForModelObject;

/**
 * Persistence layer
 */
public abstract class Q01DBCRUDForPersistableModelObjectBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>,
							 			                     DB extends Q01DBEntityBase>
	   		  extends DBCRUDForModelObjectBase<O,M,
	 								    	   DBPrimaryKeyForModelObject,DB>
    	   implements CompletesDBEntityBeforeCreateOrUpdate<M,DB>,
    		   		  Q01CRUDServicesForPersistableModelObjectBase<O,M> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBCRUDForPersistableModelObjectBase(final Class<M> modelObjectType,final Class<DB> dbEntityType,
						 			   			  final DBModuleConfig dbCfg,
						 			   			  final EntityManager entityManager,
						 			   			  final Marshaller marshaller) {
		super(modelObjectType,dbEntityType,
			  dbCfg,
			  entityManager,
			  marshaller);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  EXTENSION
/////////////////////////////////////////////////////////////////////////////////////////
}
