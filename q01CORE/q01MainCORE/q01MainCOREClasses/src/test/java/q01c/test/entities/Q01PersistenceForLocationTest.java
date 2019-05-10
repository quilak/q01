package q01c.test.entities;

import q01a.client.api.main.Q01ClientAPI;
import q01a.model.location.Q01Location;
import q01a.model.oids.Q01MainOIDs.Q01LocationOID;
import r01f.locale.Language;
import r01f.patterns.CommandOn;
import r01f.test.persistence.TestPersistableModelObjectBase;
import r01f.test.persistence.TestPersistableModelObjectManager;

public class Q01PersistenceForLocationTest 
	 extends TestPersistableModelObjectBase<Q01LocationOID,Q01Location> {
/////////////////////////////////////////////////////////////////////////////////////////
//  FIELDS
/////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01PersistenceForLocationTest(final Q01ClientAPI api) {
		super(TestPersistableModelObjectManager.create(Q01Location.class,new Q01MockLocationFactory(),
													   api.locationAPI().getForCRUD(),
													   1000l),		// sleep 1000 milis before deleting DB records to give time to background jobs (notifications) to complete
			  api.locationAPI().getForCRUD(),api.locationAPI().getForFind());
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  MANAGER FACTORY
/////////////////////////////////////////////////////////////////////////////////////////
	public static TestPersistableModelObjectManager<Q01LocationOID,Q01Location> createMockObjsManager(final Q01ClientAPI api) {
		return TestPersistableModelObjectManager.create(Q01Location.class,new Q01MockLocationFactory(),
														api.locationAPI().getForCRUD());
	}
	public static TestPersistableModelObjectManager<Q01LocationOID,Q01Location> createMockObjsManager(final Q01ClientAPI api,
																								  	  final Q01Location person) {
		return TestPersistableModelObjectManager.create(person,
														api.locationAPI().getForCRUD());
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  CRUD
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected CommandOn<Q01Location> _modelObjectStateUpdateCommand() {
		return new CommandOn<Q01Location>() {
						@Override
						public void executeOn(final Q01Location obj) {
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
