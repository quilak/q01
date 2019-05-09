package q01a.bootstrap.client.main;

import com.google.inject.Binder;
import com.google.inject.Provides;

import lombok.EqualsAndHashCode;
import q01a.context.Q01MockSecurityContextProvider;
import q01f.common.internal.Q01AppCodes;
import r01f.bootstrap.services.client.ServicesClientAPIBootstrapGuiceModuleBase;
import r01f.bootstrap.services.config.client.ServicesClientGuiceBootstrapConfig;
import r01f.inject.HasMoreBindings;
import r01f.model.annotations.ModelObjectsMarshaller;
import r01f.objectstreamer.Marshaller;
import r01f.objectstreamer.MarshallerBuilder;
import r01f.securitycontext.SecurityContext;

/**
 * Client-API bindings
 */
@EqualsAndHashCode(callSuper=true) // This is important for guice modules
public class Q01ClientBootstrapGuiceModuleForMain
  	 extends ServicesClientAPIBootstrapGuiceModuleBase 	// this is a client guice bindings module
  implements HasMoreBindings {
/////////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////
	public Q01ClientBootstrapGuiceModuleForMain(final ServicesClientGuiceBootstrapConfig servicesClientCfg) {
		super(servicesClientCfg);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  GUICE MODULE
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void configureMoreBindings(final Binder binder) {
		_bindModelObjectsMarshaller(binder);
		_bindModelObjectExtensionsModule(binder);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  USER CONTEXT PROVIDERS
/////////////////////////////////////////////////////////////////////////////////////////
	@Provides @SuppressWarnings("static-method")
	SecurityContext provideSecurityContext() {
		Q01MockSecurityContextProvider provider = new Q01MockSecurityContextProvider();
		return provider.get();
	}
/////////////////////////////////////////////////////////////////////////////////////////
// 	COMMON BINDINGS
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * bindings for the marshaller
	 */
	private static void _bindModelObjectsMarshaller(final Binder binder) {
		// Create the model objects marshaller
		Marshaller marshaller = MarshallerBuilder.findTypesToMarshallAt(Q01AppCodes.API_APPCODE)
												 .build();
		// Bind this instance to the model object's marshaller
		binder.bind(Marshaller.class).annotatedWith(ModelObjectsMarshaller.class)
									 .toInstance(marshaller);
	}
/////////////////////////////////////////////////////////////////////////////////////////
//  MODEL EXTENSIONS
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @param binder
	 * @return bindings for the model extensions
	 */
	private static void _bindModelObjectExtensionsModule(final Binder binder) {
		// nothing
	}
}
