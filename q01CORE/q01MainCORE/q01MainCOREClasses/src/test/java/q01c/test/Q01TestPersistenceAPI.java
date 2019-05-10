package q01c.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import q01a.client.api.main.Q01ClientAPI;
import q01c.test.entities.Q01PersistenceForLocationTest;
import q01c.test.entities.Q01PersistenceForPersonTest;
import q01c.test.entities.Q01PersistenceForTeamTest;


/**
 * Run:
 * 		JVM argument: -javaagent:d:/eclipse/local_libs/aspectj/lib/aspectjweaver.jar -Daj.weaving.verbose=true
 * 		Add to the classpath:
 * 			- The MySQL / Posgre / Oracle driver
 * 			- The folders that contains properties:
 * 					- q01fConfig/loc
 * 					- q01aConfig/loc
 * 					- q01cConfig/loc 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q01TestPersistenceAPI
	 extends Q01APITestBase {
/////////////////////////////////////////////////////////////////////////////////////////
//  TEAM MEMBER
/////////////////////////////////////////////////////////////////////////////////////////
	@Test @SuppressWarnings("static-method")
	public void testPersistenceForPerson() {
		Q01ClientAPI clientApi = Q01APITestBase.getClientApi(); 
		final Q01PersistenceForPersonTest test = new Q01PersistenceForPersonTest(clientApi);
		test.doTest();
	}
//	@Test @SuppressWarnings("static-method")
	public void testPersistenceForTeam() {
		Q01ClientAPI clientApi = Q01APITestBase.getClientApi(); 
		final Q01PersistenceForTeamTest test = new Q01PersistenceForTeamTest(clientApi);
		test.doTest();
	}
//	@Test @SuppressWarnings("static-method")
	public void testPersistenceForLocation() {
		Q01ClientAPI clientApi = Q01APITestBase.getClientApi(); 
		final Q01PersistenceForLocationTest test = new Q01PersistenceForLocationTest(clientApi);
		test.doTest();
	}
}
