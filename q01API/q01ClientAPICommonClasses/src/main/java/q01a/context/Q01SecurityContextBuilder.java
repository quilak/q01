package q01a.context;

import r01f.guids.CommonOIDs.AppCode;
import r01f.guids.CommonOIDs.UserCode;
import r01f.patterns.IsBuilder;
import r01f.securitycontext.SecurityContext;

public class Q01SecurityContextBuilder
  implements IsBuilder {
	
	/**
	 * Creates a {@link SecurityContext} for a physical user
	 * @param userCode
	 * @return
	 */
	public static Q01SecurityContext createFor(final UserCode userCode) {
		return new Q01SecurityContext(userCode);
	}
	/**
	 * Creates a {@link SecurityContext} for an app
	 * @param appCode
	 * @return
	 */
	public static Q01SecurityContext createForApp(final AppCode appCode) {
		return new Q01SecurityContext(appCode);
	}
}
