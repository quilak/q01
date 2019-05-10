package q01a.model.participant;

import q01a.common.model.Q01PersistableObjectBase;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;
import r01f.objectstreamer.annotations.MarshallType;

@MarshallType(as="person")
@ConvertToDirtyStateTrackable
public class Q01Person
	 extends Q01PersistableObjectBase<Q01PersonOID,Q01Person>
  implements Q01EventParticipant {

	private static final long serialVersionUID = 6551892372485625722L;

}
