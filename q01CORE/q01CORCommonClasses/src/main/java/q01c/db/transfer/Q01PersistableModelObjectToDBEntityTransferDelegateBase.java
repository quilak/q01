package q01c.db.transfer;

import lombok.RequiredArgsConstructor;
import q01c.db.entities.Q01DBEntityBase;
import q01f.common.model.Q01PersistableObject;
import q01f.common.model.oids.Q01CommonOIDs.Q01PersistableObjectOID;
import r01f.model.ModelObject;
import r01f.persistence.db.DBEntity;
import r01f.persistence.db.TransfersModelObjectStateToDBEntity;

/**
 * Transfers a {@link ModelObject}'s state to a given {@link DBEntity}
 */
@RequiredArgsConstructor
public abstract class Q01PersistableModelObjectToDBEntityTransferDelegateBase<M extends Q01PersistableObject<? extends Q01PersistableObjectOID>,
													 	      		 		  DB extends Q01DBEntityBase> 
  		   implements TransfersModelObjectStateToDBEntity<M,DB> {
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////	
}