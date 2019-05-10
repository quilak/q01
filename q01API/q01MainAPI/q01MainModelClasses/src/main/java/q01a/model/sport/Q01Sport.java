package q01a.model.sport;

import q01a.common.model.Q01PersistableObject;
import q01a.model.oids.Q01MainOIDs.Q01SportOID;

public interface Q01Sport 
         extends Q01PersistableObject<Q01SportOID> {
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////
	public boolean isForTeams();
	
	public boolean isForIndividuals();
}
