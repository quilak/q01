package q01f.common.model;

import q01f.common.model.oids.Q01CommonOIDs.Q01ModelObjectOID;
import r01f.model.IndexableModelObject;
import r01f.model.PersistableModelObject;
import r01f.validation.Validates;

/**
 * Interface for every persistable model object
 * @param <O>
 */
//@ModelObjectData(P01MetaDataForModelObject.class)
public interface Q01PersistableModelObject<O extends Q01ModelObjectOID> 
		 extends PersistableModelObject<O>,	// is persistable
     	 		 IndexableModelObject,		// is indexable
		 		 Q01ModelObject {
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////
	public <M extends Q01PersistableModelObject<?>> Validates<M> asValidates();
}
