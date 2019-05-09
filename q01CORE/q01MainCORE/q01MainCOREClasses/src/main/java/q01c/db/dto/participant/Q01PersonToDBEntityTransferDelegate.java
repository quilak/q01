package q01c.db.dto.participant;

import lombok.RequiredArgsConstructor;
import q01a.model.participant.Q01Person;
import q01c.db.entities.main.Q01DBEntityForPerson;
import q01c.db.transfer.Q01PersistableModelObjectToDBEntityTransferDelegateBase;
import r01f.model.ModelObject;
import r01f.persistence.db.DBEntity;
import r01f.securitycontext.SecurityContext;

/**
 * Transfers a {@link ModelObject}'s state to a given {@link DBEntity}
 */
@RequiredArgsConstructor
public class Q01PersonToDBEntityTransferDelegate 
     extends Q01PersistableModelObjectToDBEntityTransferDelegateBase<Q01Person,Q01DBEntityForPerson> {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void setDBEntityFieldsFromModelObject(final SecurityContext securityContext,
												 final Q01Person modelObj,final Q01DBEntityForPerson dbEntity) {
		dbEntity.setOid(modelObj.getOid().asString());
		if (modelObj.getName() != null) dbEntity.setName(modelObj.getName().getAny());
		if (modelObj.getDescription() != null) dbEntity.setDescription(modelObj.getDescription().getAny());
	}
}