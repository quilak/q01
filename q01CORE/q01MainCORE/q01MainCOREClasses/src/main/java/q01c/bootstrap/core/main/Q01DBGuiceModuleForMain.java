package q01c.bootstrap.core.main;

import lombok.EqualsAndHashCode;
import r01f.bootstrap.persistence.DBGuiceModuleBase;
import r01f.persistence.db.config.DBModuleConfig;


@EqualsAndHashCode(callSuper=true)				// This is important for guice modules
  class Q01DBGuiceModuleForMain
extends DBGuiceModuleBase {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01DBGuiceModuleForMain(final DBModuleConfig config) {
		super(config);
	}
}
