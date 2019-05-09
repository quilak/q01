package q01a.model.sport;

import java.util.Map;

import com.google.common.collect.Maps;

import lombok.experimental.Accessors;
import r01f.aspects.interfaces.dirtytrack.ConvertToDirtyStateTrackable;
import r01f.locale.Language;
import r01f.locale.LanguageTexts;
import r01f.locale.LanguageTextsMapBacked;

@ConvertToDirtyStateTrackable
@Accessors(prefix="_")
public abstract class Q01FoottballBase<SELF_TYPE extends Q01FoottballBase<SELF_TYPE>> 
	 		  extends Q01SportBase<SELF_TYPE> 
  		   implements Q01TeamSport {

	private static final long serialVersionUID = 3020461791291508539L;

///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////
	@Override
	public Map<Q01SportTeamPosition,LanguageTexts> getPositionNames() {
		Map<Q01SportTeamPosition,LanguageTexts> positionNames = Maps.newHashMapWithExpectedSize(Q01FootballPosition.values().length);
		positionNames.put(Q01FootballPosition.GOALKEEPER,
						  new LanguageTextsMapBacked()
						  			.add(Language.SPANISH,"Portería")
						  			.add(Language.ENGLISH,"Goalkeeper"));
		positionNames.put(Q01FootballPosition.DEFENDER,
						  new LanguageTextsMapBacked()
						  			.add(Language.SPANISH,"Defensa")
						  			.add(Language.ENGLISH,"Defender"));
		positionNames.put(Q01FootballPosition.MIDDLEFIELDER,
						  new LanguageTextsMapBacked()
						  			.add(Language.SPANISH,"Centro del campo")
						  			.add(Language.ENGLISH,"Middle field"));
		positionNames.put(Q01FootballPosition.FORWARD,
						  new LanguageTextsMapBacked()
						  			.add(Language.SPANISH,"Delantera")
						  			.add(Language.ENGLISH,"Forward"));
		return positionNames;
	}
}
