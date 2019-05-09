package q01c.bootstrap.core.main;

import com.google.inject.Binder;

import lombok.EqualsAndHashCode;
import r01f.bootstrap.BeanImplementedPersistenceServicesCoreBootstrapGuiceModuleBase;
import r01f.bootstrap.ServicesBootstrapGuiceModuleBindsCRUDEventListeners;
import r01f.bootstrap.services.config.core.ServicesCoreBootstrapConfigWhenBeanExposed;
import r01f.inject.HasMoreBindings;
import r01f.persistence.db.config.DBModuleConfigBuilder;


@EqualsAndHashCode(callSuper=true)				// This is important for guice modules
public class Q01ServicesBootstrapGuiceModuleForMain
     extends BeanImplementedPersistenceServicesCoreBootstrapGuiceModuleBase
  implements ServicesBootstrapGuiceModuleBindsCRUDEventListeners,
  			 HasMoreBindings {
/////////////////////////////////////////////////////////////////////////////////////////
//
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01ServicesBootstrapGuiceModuleForMain(final ServicesCoreBootstrapConfigWhenBeanExposed coreBootstrapCfg) {
		super(coreBootstrapCfg,
			  new Q01DBGuiceModuleForMain(DBModuleConfigBuilder.dbModuleConfigFrom(coreBootstrapCfg))		// db
			  );		
	}
/////////////////////////////////////////////////////////////////////////////////////////
//
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void configureMoreBindings(final Binder binder) {

	}
	@Override
	public void bindCRUDEventListeners(final Binder binder) {
		// Bind notifiers event listeners
		// ... messaging (latinia)
	}
}
