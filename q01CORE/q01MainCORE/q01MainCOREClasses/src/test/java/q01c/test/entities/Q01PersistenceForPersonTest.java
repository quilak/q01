package q01c.test.entities;

import q01a.client.api.main.Q01ClientAPI;
import q01a.model.oids.Q01MainOIDs.Q01PersonOID;
import q01a.model.participant.Q01Person;
import r01f.locale.Language;
import r01f.patterns.CommandOn;
import r01f.test.persistence.TestPersistableModelObjectBase;
import r01f.test.persistence.TestPersistableModelObjectManager;

public class Q01PersistenceForPersonTest 
	 extends TestPersistableModelObjectBase<Q01PersonOID,Q01Person> {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01PersistenceForPersonTest(final Q01ClientAPI api) {
		super(TestPersistableModelObjectManager.create(Q01Person.class,new Q01MockPersonFactory(),
													   api.personAPI().getForCRUD(),
													   1000l),		// sleep 1000 milis before deleting DB records to give time to background jobs (notifications) to complete
			  api.personAPI().getForCRUD(),api.personAPI().getForFind());
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  MANAGER FACTORY
/////////////////////////////////////////////////////////////////////////////////////////
	public static TestPersistableModelObjectManager<Q01PersonOID,Q01Person> createMockObjsManager(final Q01ClientAPI api) {
		return TestPersistableModelObjectManager.create(Q01Person.class,new Q01MockPersonFactory(),
														api.personAPI().getForCRUD());
	}
	public static TestPersistableModelObjectManager<Q01PersonOID,Q01Person> createMockObjsManager(final Q01ClientAPI api,
																								  final Q01Person person) {
		return TestPersistableModelObjectManager.create(person,
														api.personAPI().getForCRUD());
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  CRUD
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected CommandOn<Q01Person> _modelObjectStateUpdateCommand() {
		return new CommandOn<Q01Person>() {
						@Override
						public void executeOn(final Q01Person obj) {
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
