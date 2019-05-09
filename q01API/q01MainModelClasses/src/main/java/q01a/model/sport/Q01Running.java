package q01a.model.sport;

import lombok.experimental.Accessors;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;

@ConvertToDirtyStateTrackable
@Accessors(prefix="_")
public class Q01Running 
	 extends Q01SportBase<Q01Running> 
  implements Q01IndividualSport {

	private static final long serialVersionUID = -1267818870860106153L;
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////
}
