package q01a.model.sport;

import lombok.experimental.Accessors;
import q01a.model.oids.Q01MainOIDs.Q01SportOID;
import q01f.common.model.Q01PersistableObjectBase;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;

@ConvertToDirtyStateTrackable
@Accessors(prefix="_")
public abstract class Q01SportBase<SELF_TYPE extends Q01SportBase<SELF_TYPE>>
	 		  extends Q01PersistableObjectBase<Q01SportOID,SELF_TYPE>  
  		   implements Q01Sport {

	private static final long serialVersionUID = 7350187913996092761L;
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean isForTeams() {
		return this instanceof Q01TeamSport;
	}
	@Override
	public boolean isForIndividuals() {
		return this instanceof Q01IndividualSport;
	}
}
