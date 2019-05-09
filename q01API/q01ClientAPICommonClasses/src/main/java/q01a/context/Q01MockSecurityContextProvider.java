package q01a.context;



import javax.inject.Provider;

import r01f.guids.CommonOIDs.TenantID;

/**
 * Mock provider for user contexts
 */
public class Q01MockSecurityContextProvider
  implements Provider<Q01SecurityContext> {
/////////////////////////////////////////////////////////////////////////////////////////
//  Provider
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Q01SecurityContext get() {
		System.out.println("========>Providing a fresh new security context!");
		Q01SecurityContext outCtx = new Q01SecurityContext();
		outCtx.setTenantId(TenantID.DEFAULT);
		return outCtx;
	}

}
