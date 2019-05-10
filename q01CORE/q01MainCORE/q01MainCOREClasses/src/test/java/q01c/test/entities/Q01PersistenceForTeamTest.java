package q01c.test.entities;

import q01a.client.api.main.Q01ClientAPI;
import q01a.model.oids.Q01MainOIDs.Q01TeamOID;
import q01a.model.participant.Q01Team;
import r01f.locale.Language;
import r01f.patterns.CommandOn;
import r01f.test.persistence.TestPersistableModelObjectBase;
import r01f.test.persistence.TestPersistableModelObjectManager;

public class Q01PersistenceForTeamTest 
	 extends TestPersistableModelObjectBase<Q01TeamOID,Q01Team> {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01PersistenceForTeamTest(final Q01ClientAPI api) {
		super(TestPersistableModelObjectManager.create(Q01Team.class,new Q01MockTeamFactory(),
													   api.teamAPI().getForCRUD(),
													   1000l),		// sleep 1000 milis before deleting DB records to give time to background jobs (notifications) to complete
			  api.teamAPI().getForCRUD(),api.teamAPI().getForFind());
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  MANAGER FACTORY
/////////////////////////////////////////////////////////////////////////////////////////
	public static TestPersistableModelObjectManager<Q01TeamOID,Q01Team> createMockObjsManager(final Q01ClientAPI api) {
		return TestPersistableModelObjectManager.create(Q01Team.class,new Q01MockTeamFactory(),
														api.teamAPI().getForCRUD());
	}
	public static TestPersistableModelObjectManager<Q01TeamOID,Q01Team> createMockObjsManager(final Q01ClientAPI api,
																							  final Q01Team team) {
		return TestPersistableModelObjectManager.create(team,
														api.teamAPI().getForCRUD());
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  CRUD
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected CommandOn<Q01Team> _modelObjectStateUpdateCommand() {
		return new CommandOn<Q01Team>() {
						@Override
						public void executeOn(final Q01Team obj) {
						obj.getName()
								.set(Language.DEFAULT,obj.getName() + " (MODIFIED)");
						}
			   };
	}
/////////////////////////////////////////////////////////////////////////////////////////
//
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected void testOtherFindMethods() {
		// nothing
	}
	@Override
	public void testOtherMethods() {
		// nothing
	}
	@Override
	protected void testOtherCRUDMethods() {
		// TODO Auto-generated method stub
	}
}
