package q01c.test.entities;

import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import r01f.locale.Language;
import r01f.locale.LanguageTextsMapBacked;
import r01f.patterns.Factory;

public class Q01MockLocationFactory 
  implements Factory<Q01Location> {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Q01Location create() {
		return _buildMockLocation();
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  ENTITY PROVIDER
/////////////////////////////////////////////////////////////////////////////////////////
	private static Q01Location _buildMockLocation() {
		Q01LocationOID oid = Q01LocationOID.supply();
		Q01Location outObj = new Q01Location();
		outObj.setOid(oid);
		outObj.setName(new LanguageTextsMapBacked()
								.add(Language.DEFAULT,"TEST Location " + oid));
		outObj.setDescription(new LanguageTextsMapBacked()
									.add(Language.DEFAULT,"TEST location " + oid + " description"));
		
		return outObj;
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
}
