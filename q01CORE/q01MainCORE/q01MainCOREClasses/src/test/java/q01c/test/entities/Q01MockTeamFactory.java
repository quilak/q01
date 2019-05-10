package q01c.test.entities;

import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Futbol5Team;
import q01a.model.participant.Q01Team;
import r01f.locale.Language;
import r01f.locale.LanguageTextsMapBacked;
import r01f.patterns.Factory;

public class Q01MockTeamFactory 
  implements Factory<Q01Team> {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Q01Team create() {
		return _buildMockTeam();
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  ENTITY PROVIDER
/////////////////////////////////////////////////////////////////////////////////////////
	private static Q01Team _buildMockTeam() {
		Q01TeamOID oid = Q01TeamOID.supply();
		Q01Futbol5Team outObj = new Q01Futbol5Team();
		outObj.setOid(oid);
		outObj.setName(new LanguageTextsMapBacked()
								.add(Language.DEFAULT,"TEST Team " + oid));
		outObj.setDescription(new LanguageTextsMapBacked()
									.add(Language.DEFAULT,"TEST Team " + oid + " description"));
		
		return outObj;
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
}
