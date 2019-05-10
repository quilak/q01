package q01c.test.entities;

import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import r01f.locale.Language;
import r01f.locale.LanguageTextsMapBacked;
import r01f.patterns.Factory;

public class Q01MockPersonFactory 
  implements Factory<Q01Person> {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Q01Person create() {
		return _buildMockPerson();
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  ENTITY PROVIDER
/////////////////////////////////////////////////////////////////////////////////////////
	private static Q01Person _buildMockPerson() {
		Q01PersonOID oid = Q01PersonOID.supply();
		Q01Person outObj = new Q01Person();
		outObj.setOid(oid);
		outObj.setName(new LanguageTextsMapBacked()
								.add(Language.DEFAULT,"TEST Person " + oid));
		outObj.setDescription(new LanguageTextsMapBacked()
									.add(Language.DEFAULT,"TEST person " + oid + " description"));
		
		return outObj;
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
}
