package q01c.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.google.common.collect.Lists;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import q01a.bootstrap.client.main.R01MClientBootstrapConfigBuilderForMain;
import q01a.client.api.main.Q01ClientAPI;
import q01a.common.internal.Q01AppCodes;
import q01c.bootstrap.core.main.R01TBeanServicesBootstrapConfigBuilderForMain;
import r01f.bootstrap.services.config.ServicesBootstrapConfig;
import r01f.bootstrap.services.config.ServicesBootstrapConfigBuilder;
import r01f.exceptions.Throwables;
import r01f.test.api.TestAPIBase;
import r01f.xmlproperties.XMLPropertiesBuilder;
import r01f.xmlproperties.XMLPropertiesForApp;

/**
 * JVM arguments:
 * -javaagent:/work/eclipse/local_libs/aspectj/lib/aspectjweaver.jar -Daj.weaving.verbose=true
 */
@Accessors(prefix="_")
@RequiredArgsConstructor
public abstract class Q01APITestBase 
              extends TestAPIBase {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	public static Q01ClientAPI getClientApi() {
		Q01ClientAPI clientApi = TestAPIBase.getClientApi(Q01ClientAPI.class);
		return clientApi;
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  JUnit
/////////////////////////////////////////////////////////////////////////////////////////
	@BeforeClass
	public static void setUpBeforeClass() {
		try {
			// [0] - Load properties
			XMLPropertiesForApp xmlProps = XMLPropertiesBuilder.createForApp(Q01AppCodes.CORE_APPCODE)
															   .notUsingCache();
			
			// [1] - Create the modules bootstrap config
			ServicesBootstrapConfig bootCfg = ServicesBootstrapConfigBuilder
													.forClient(R01MClientBootstrapConfigBuilderForMain.buildClientBootstrapConfig())
					 							   	.ofCoreModules(R01TBeanServicesBootstrapConfigBuilderForMain.buildCoreBootstrapConfig(xmlProps))
					 							   	.build();
			// [2] - Setup
			 _setUpBeforeClass(Lists.newArrayList(bootCfg));
			 
		} catch(Exception ex) {
			ex.printStackTrace(System.out);
			Throwables.throwUnchecked(ex);
		}
	}
	@AfterClass
	public static void tearDownAfterClass()  {
		// [99]-Tear things down
		try {
			_tearDownAfterClass();
		} catch(Exception ex) {
			ex.printStackTrace(System.out);
			Throwables.throwUnchecked(ex);
		}
	}
}
