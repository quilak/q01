package q01c.db.find;

import javax.persistence.EntityManager;

import q01a.api.interfaces.find.Q01FindServicesForPersistableModelObjectBase;
import q01a.common.model.Q01PersistableObject;
import q01a.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.objectstreamer.Marshaller;
import r01f.persistence.db.DBFindForModelObjectBase;
import r01f.persistence.db.config.DBModuleConfig;
import r01f.persistence.db.entities.DBEntityForModelObject;
import r01f.persistence.db.entities.primarykeys.DBPrimaryKeyForModelObject;

/**
 * Persistence layer
 */
public abstract class Q01DBFindForPersistableModelObjectBase<O extends Q01PersistableObjectOID,M extends Q01PersistableObject<O>,
							 			                     DB extends DBEntityForModelObject<DBPrimaryKeyForModelObject>>
	   		  extends DBFindForModelObjectBase<O,M,
	 								    	   DBPrimaryKeyForModelObject,DB>
    	   implements Q01FindServicesForPersistableModelObjectBase<O,M> {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBFindForPersistableModelObjectBase(final Class<M> modelObjectType,final Class<DB> dbEntityType,
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
