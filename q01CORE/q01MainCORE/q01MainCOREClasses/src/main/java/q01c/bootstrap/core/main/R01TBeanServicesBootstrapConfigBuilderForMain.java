package q01c.bootstrap.core.main;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import q01a.common.internal.Q01AppCodes;
import q01c.services.impl.Q01CoreServiceImpl;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigBuilder;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.bootstrap.services.config.core.ServicesCoreSubModuleBootstrapConfig;
import r01f.guids.CommonOIDs.AppComponent;
import r01f.patterns.IsBuilder;
import r01f.persistence.db.config.DBModuleForPoolConnectionConfig;
import r01f.services.ids.ServiceIDs.CoreModule;
import r01f.xmlproperties.XMLPropertiesForApp;
import r01f.xmlproperties.XMLPropertiesForAppComponent;

/**
 * Builds bootstrap config
 */
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public abstract class R01TBeanServicesBootstrapConfigBuilderForMain
		   implements IsBuilder {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	public static ServicesCoreBootstrapConfigWhenBeanExposed buildCoreBootstrapConfig(final XMLPropertiesForApp xmlProps) {
		XMLPropertiesForAppComponent servicesProps = xmlProps.forComponent(AppComponent.compose(Q01AppCodes.MAIN_CORE_MOD,
																							 	CoreModule.SERVICES));
		XMLPropertiesForAppComponent dbXmlProps = xmlProps.forComponent(AppComponent.compose(Q01AppCodes.MAIN_CORE_MOD,
																							 CoreModule.DBPERSISTENCE));
//		XMLPropertiesForAppComponent searchXmlProps = xmlProps.forComponent(AppComponent.compose(Q01AppCodes.MAIN_CORE_MOD,
//																							     CoreModule.SEARCHPERSISTENCE));
//		
//		Path luceneIndexFilesPath = searchXmlProps.propertyAt("persistence/search/lucene/indexStore")
//										      	  .asPath(Path.from(Strings.customized("d:/temp_dev/{}/lucene",
//										    				  					   			 xmlProps.getAppCode())));
//		boolean luceneEnabled = searchXmlProps.propertyAt("persistence/search/lucene/@enabled")
//						   							.asBoolean(true);
//		
		return ServicesCoreBootstrapConfigBuilder.forCoreAppAndModule(Q01AppCodes.CORE_APPCODE,Q01AppCodes.MAIN_CORE_MOD)
	   				.beanImplemented()
	   					.bootstrappedBy(Q01ServicesBootstrapGuiceModuleForMain.class)
	   					.findServicesExtending(Q01CoreServiceImpl.class)
	   					.withSubModulesConfigs(
	   							// db config
	   							ServicesCoreSubModuleBootstrapConfig.createForDBPersistenceSubModule(new DBModuleForPoolConnectionConfig(dbXmlProps))
	   							
	   							// search config
//	   							ServicesCoreSubModuleBootstrapConfig.createForSearchPersistenceSubModule(LuceneSearchModuleConfig.storingIndexAt(luceneIndexFilesPath))	
	   					).build();
	}
}
