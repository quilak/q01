package q01a.model.sport;

import lombok.experimental.Accessors;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;

@ConvertToDirtyStateTrackable
@Accessors(prefix="_")
public class Q01Foottball5 
	 extends Q01FoottballBase<Q01Foottball5> {

	private static final long serialVersionUID = -2525213208913443603L;
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////
	@Override
	public int getNumberOfPlayersInEachTeam() {
		return 5;
	}
}
