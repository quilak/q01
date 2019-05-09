package q01c.db.dto.location;

import lombok.RequiredArgsConstructor;
import q01a.model.location.Q01Location;
import q01c.db.entities.main.Q01DBEntityForLocation;
import q01c.db.transfer.Q01PersistableModelObjectToDBEntityTransferDelegateBase;
import r01f.model.ModelObject;
import r01f.persistence.db.DBEntity;
import r01f.securitycontext.SecurityContext;

/**
 * Transfers a {@link ModelObject}'s state to a given {@link DBEntity}
 */
@RequiredArgsConstructor
public class Q01LocationToDBEntityTransferDelegate 
     extends Q01PersistableModelObjectToDBEntityTransferDelegateBase<Q01Location,Q01DBEntityForLocation> {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void setDBEntityFieldsFromModelObject(final SecurityContext securityContext,
												 final Q01Location modelObj,final Q01DBEntityForLocation dbEntity) {
		dbEntity.setOid(modelObj.getOid().asString());
		if (modelObj.getName() != null) dbEntity.setName(modelObj.getName().getAny());
		if (modelObj.getDescription() != null) dbEntity.setDescription(modelObj.getDescription().getAny());
	}
}