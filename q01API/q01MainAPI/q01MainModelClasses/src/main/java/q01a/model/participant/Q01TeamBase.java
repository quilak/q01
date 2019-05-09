package q01a.model.participant;

import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01f.common.model.Q01PersistableObjectBase;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;

@ConvertToDirtyStateTrackable
public abstract class Q01TeamBase
	 		  extends Q01PersistableObjectBase<Q01TeamOID,Q01TeamBase>
  		   implements Q01Team {

	private static final long serialVersionUID = 2184029926096961807L;
///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
}
