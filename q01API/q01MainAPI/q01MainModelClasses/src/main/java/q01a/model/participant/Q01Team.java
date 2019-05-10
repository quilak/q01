package q01a.model.participant;

import q01a.common.model.Q01PersistableObject;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import r01f.locale.LanguageTexts;

public interface Q01Team
		 extends Q01PersistableObject<Q01TeamOID>,
		 		 Q01EventParticipant {
///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
	public LanguageTexts getName();
	public void setName(final LanguageTexts name);

	public LanguageTexts getDescription();
	public void setDescription(final LanguageTexts name);
}
