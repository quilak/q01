package q01a.model.sport;

import java.util.Map;

import r01f.locale.LanguageTexts;

public interface Q01TeamSport {
///////////////////////////////////////////////////////////////////////////////
// 	
///////////////////////////////////////////////////////////////////////////////	
	public int getNumberOfPlayersInEachTeam();
	public Map<Q01SportTeamPosition,LanguageTexts> getPositionNames();
}
