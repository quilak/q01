package q01a.bootstrap.client.main;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import q01a.api.interfaces.Q01ServiceInterface;
import q01a.client.api.main.Q01ClientAPI;
import q01a.common.internal.Q01AppCodes;
import r01f.bootstrap.services.config.client.ServicesClientBootstrapConfig;
import r01f.bootstrap.services.config.client.ServicesClientBootstrapConfigBuilder;
import r01f.patterns.IsBuilder;

/**
 * Builds bootstrap confif
 */
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public abstract class R01MClientBootstrapConfigBuilderForMain
		   implements IsBuilder {
/////////////////////////////////////////////////////////////////////////////////////////
//  
/////////////////////////////////////////////////////////////////////////////////////////
	public static ServicesClientBootstrapConfig buildClientBootstrapConfig() {
		return ServicesClientBootstrapConfigBuilder.forClientApiAppCode(Q01AppCodes.API_APPCODE)
														  .exposingApi(Q01ClientAPI.class)
														  .ofServiceInterfacesExtending(Q01ServiceInterface.class)
														  .bootstrappedWith(Q01ClientBootstrapGuiceModuleForMain.class)
														  .build();
	}
}
